# What is Coroutine?
" CO + Routine" 의 합성어로 써 같이 협동, 같이 를 나타내는 CO 와 Routine 을 합쳐서 협동하는 루틴이다.


### Routine
- 일반적인 루틴(일종의 함수) 요청이 들어오면 중간에 일시중단 되지 않고 하나의 루틴이 끝나고 난 뒤 응답을 하게 된다 (in & out)


### Coroutine
- 코루틴은 이전에 자신이 실행이 마지막으로 중단되었던 지점 다음의 장소에서 실행을 재개한다.(in & (suspend & execute ...) & out)
- 비동기 처리를 간단하게 처리할 수 있게 해준다. (중단 시점을 개발자가 선택하여 할 수 있기 때문)
- 비동기 코드 (async)를 순차적인 코드 (Sequential)로 변경할 수 있도록 한다.
- 중단 되더라도 루틴 내의 정보가 사라지지 않는다.
- 프로세스에 종속적인 쓰레드와 달리, 코루틴은 중단/재개 시 쓰레드를 옮겨다니면서 사용할 수 있다.
  - 하나의 쓰레드로 코루틴 N개가 번갈아 실행될 수 있어 메모리를 전부 공유하므로 context switching 비용이 적다.

```groovy
implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2")
```

### vm option 코루틴 설정
```groovy
-Dkotlinx.coroutines.debug
```

## 코루틴을 사용하지 않았을 때 
- ### 일반적인 경우
  - 네트워크를 통해 값을 가져오는 상태가 있다고 가정하였을 떄 해당 값을 가지고 데이터를 사용하는 경우 일반적으로 코드 작성 시 네트워크 응답 값이 호출되지 않고 해당 값을 사용하려고 할 떄 networkException 이 발생하며 해당 데이터를 사용할 수 없습니다.
(네트워크 연결이 완료되지 않았는데 데이터를 담으려고 했기 때문)
- ### Thread 를 사용하는 경우
  - Thread 를 생성하여 사용하려고 하여도 UI쓰레드가 아닌 별도 쓰레드를 사용하여 데이터를 사용하기 때문에 thread exception이 발생 합니다.
- ### Callback 을 사용하는 경우
  - thread 를 통하여 서버의 값을 호출하고 다시 메인 쓰레드에 switcing 을 하여 값을 담아주도록 하는 형태는 순차적으로 할 수는 있지만 많은 callBack으로 인하여 메모리 과부하가 걸릴 수 있다. (OOM)

## 코루틴을 사용할 때 
- 별도의 callback, Thread 를 사용하지 않고도 별도의 루틴이 생성되어 위와 같은 상황을 해결할 수 있다.


## Coroutine Builder (코루틴 생성)
### 1. GlobalScope.launch
 - 전역 scope 안에서 coroutine 을 만들어 실행 시킨다. 
 - main 스레드를 멈추지 않고 스코프 안에서만 멈춘다.

### 2. RunBlocking
 - main thread 를 멈추게 한다 (blocking)
 - runBlocking 안에서 다른 thread 를 실행할 수 있다.

### 3. launch 
- 반환 값이 없는 코드를 실행할 떄 사용
- launch 의 타입은 Job 으로 코루틴을 나타내는 객체이다.
  - Job 을 통해 코루틴을 제어 할 수 있다.
    - job.cancel()
      - 실행 중인 코루틴 취소 / 반복적인 작업을 하는 코루틴을 종료 시킬 수 있따.
    - job.join()
      - 해당 코루틴이 끝날 떄 까지 대기하였다가 다음 코루틴 실행
- 예외 발생 시 바로 예외 캐치

### 4. async
- 주어진 함수의 실행 결과를 반환할 수 있다.
  - Job 의 하위 타입인 Deferred 를 반환 받고 실행된 결과를 가져오는 await 가 존재 // async -> async 결과값 .await
  - 내부 로직은 launch 와 동일하게 비동기로 처리되면 값을 반환 받기 위해 사용됨
- async 에서 await 를 실행하지 않으면 예외 캐치를 할 수 없다.



### Root 코루틴 생성
- CoroutineScope(Dispatchers.Default): 새로운 쓰레드에 Root 코루틴 생성
- 자식 코루틴에서 예외가 발생하면 부모 코루틴에서 해당 예외를 캐치한다.
  - EX) 부모 코루틴 runBlocking 내에 자식 코루틴으로 await 이 생성되어 예외 발생 시 부모 코루틴으로 전파되므로 예외를 캐치함
  - 그러나 CoroutineScope(Dispatchers.Default).async 처럼 루트 코루틴으로 생성되면 예외는 await 호출하지 않으면 캐치하지 않음
    - 전파할 곳이 없어서 캐치하지 않음

### 자식 코루틴이 부모 코루틴으로 전파하지 않게끔 하는 방법
- SupervisorJob
  - async(SupervisorJob) 으로 사용 가능
    - 실제 부모 자식 코루틴 관계 이지만 예외를 부모 코루틴으로 전파하지 않는다.

### 예외를 다루는 바법 
- try catch 를 이용하여 예외를 잡아 코루틴이 취소되지 않게 할 수 있다.
- CoroutineExceptionHandler 을 사용해서 로깅과 같은 기능을 추가할 수 있다.
```Kotlin
fun main(): Unit = runBlocking {
    val exceptionHandler = CoroutineExceptionHandler { _, _ ->
      printWithThread("예외")
    }
  
    val job = CoroutineScope(Dispatchers.Default).launch(exceptionHandler) {
      throw IllegalArgumentException()
    }
    delay(1_000L)
}
// 출력 결과
// [DefaultDispatcher-worker-1 @coroutine#2] 예외
```


### yield()
- 현재 코루틴을 중단하고, 다른 코루틴이 실행 되도록 한다. (스레드를 양보한다)

### delay(ms)
- ms 만큼 해당 코루틴을 멈춘다.


## suspend fun
- coroutine 에서 일시중단 지점을 찾기 위해 사용되는 함수
- 코루틴이 중지 되었다가 재개 **될 수 있는** 지점
  - ㅇㅇ
- 다른 suspend fun 함수를 실행 시킬 수 있다.


## CANCEL
- 코루틴이 실행됨에 있어서 해당 코루틴을 취소 시키는 방법
- 코루틴 취소를 위해서는 코루틴 안에 delay, yield 함수와 같은 일시 중단하는 함수(suspend) 함수가 선언 되어 있어야 취소 할 수 있다.
- 코루틴이 다 실행 된 후 .cancel() 함수를 실행하면 중간 취소가 되지 않은것이니
  - cancel 될 때 해당 job 에서 Exception 을 던져준다. 그래서 try catch 로 처리 후 해당 코루틴이 취소 되었는지 파악 할 수 있다.
- 혹은 코루틴의 JOB 이 실행중인지 알 수 있는 isActive 를 활용하여 중단된 코루틴인지 확인할 수 있다.

### 1. JOB CANCEL
- job cancel()

### 2. 취소는 협동적이여야 한다.
- 취소 시키는 job 에는 중단 함수(suspend) 가 선언 되어 있어야 취소 할 수 있다.
- 혹은 isActive 를 사용하여 해당 job 이 실행중인지 파악한 후 job 내부 로직을 실행할 수 있다

### 3. TimeOut
- withTimeout or withTimeoutOrNull 을 사용하여 시간 설정을 해준 후 job을 시간을 확인하여 취소를 해준다.


### Job Life Cycle

NEW - ACTIVE -> COMPLETING -> COMPLETED
          CANCELLING -> CANCELLED


부모 코루틴에서 두개의 자식 코루틴이 있을 떄 하나의 코루틴에 예외가 발생하였고, 다른 자식 코루틴이 종료가 되지 않으면, 예외가 발생한 코루틴에서
부모코루틴에게로 취소 요청을 보내고 부모 코루틴은 다른 자식 코루틴에게 취소 요청을 보내게 되어 다른 코루틴에서도 취소가 진행된다.


## Structured Concurrency 
- 부모/자식 관계의 코루틴이 한 몸 처럼 움직이는 것
- 코드 내의 에러가 유실되지 않고 적절히 보고되도록, 부모 ->
- 다만 CancellationException 은 정상적인 취소로 간주하기 때문에 부모 코루틴에게 전파되지 않고, 부모 코루틴의 다른 자식 코루틴을 취소 시키지도 않는다.

## Coroutine 의 구성 요소
- launch/async 는 CoroutineScope 의 확장 함수 이다.


### CoroutineScope 의 주요 역할
- 코루틴이 탄생할 수 있는 영역
- CoroutineContext 를 저장하는 역할
  - 코루틴과 관련된 여러가지 데이터를 가지고 있는 객체
  - Map + Set 을 합쳐놓은 형태
    - Key - Value 형태의 데이터 저장(Map), 같은 key 의 데이터는 유일 (Set)

### CoroutineDispatcher
- 코루틴이 사용되는 쓰레드를 지정해준다.
- Dispatcher.Default
- Dispatcher.IO
- Dispatcher.Main
- 쓰레드 풀 생성 Executors.newSingleThreadExecutor()
  - threadPool.asCoroutineDispatcher() 을 통해 코루틴을 설정한 Thread Pool 에서 사용될 수 있게 한다.

### suspend 함수

#### coroutineScope
- launch / async 처럼 새로운 코루틴을 만들지만, 주어진 함수 블록이 바로 실행되는 특징
- 새로 생긴 코루틴과 자식 코루틴들이 모두 완료된 이후, 반환된다.
- coroutineScope 으로 만든 코루틴은 이전 코루틴의 자식 코루틴이 된다.
``` kotlin
fun main(): Unit = runBlocking {
  printWithThread("START")
  printWithThread(calculateResult())
  printWithThread("END")
}

suspend fun calculateResult(): Int = coroutineScope {
  val num1 = async {
    delay(1_000L)
    10 
  }
  val num2 = async {
    delay(1_000L)
    20
  }
  
  num1.await() + num2.await()
}
// 출력 결과
// START
// 30
// END
```
#### withContext
- coroutineScope 과 동일하나, context 에 변화를 줄 수 있어 Dispatcher 를 바꿔 사용할 떄 활용해 볼 수 있다.
- withContext(Dispatchers.Default)


#### withTimeout / withTimeoutOrNull
- 주어진 시간 안에 코루틴이 완료되지 않으면 withTimeout 은 TimeoutCancellationException 을 던지게 되고, withTimeoutOrNull 은 null을 반환하게 된다.