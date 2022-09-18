# What is Coroutine?
" CO + Routine" 의 합성어로 써 같이 협동, 같이 를 나타내는 CO 와 Routine 을 합쳐서 협동하는 루틴이다.


### Routine
- 일반적인 루틴(일종의 함수) 요청이 들어오면 중간에 일시중단 되지 않고 하나의 루틴이 끝나고 난 뒤 응답을 하게 된다 (in & out)


### Coroutine
- 코루틴은 이전에 자신이 실행이 마지막으로 중단되었던 지점 다음의 장소에서 실행을 재개한다.(in & (suspend & execute ...) & out)
- 비동기 처리를 간단하게 처리할 수 있게 해준다. (중단 시점을 개발자가 선택하여 할 수 있기 때문)
- 비동기 코드 (async)를 순차적인 코드 (Sequential)로 변경할 수 있도록 한다.

## 코루틴을 사용하지 않았을 때 
- ### 일반적인 경우
  - 네트워크를 통해 값을 가져오는 상태가 있다고 가정하였을 떄 해당 값을 가지고 데이터를 사용하는 경우 일반적으로 코드 작성 시 네트워크 응답 값이 호출되지 않고 해당 값을 사용하려고 할 떄 networkException 이 발생하며 해당 데이터를 사용할 수 없습니다.
(네트워크 연결이 완료되지 않았는데 데이터를 담으려고 했기 때문)
- ### Thread를 사용하는 경우
  - Thread를 생성하여 사용하려고 하여도 UI쓰레드가 아닌 별도 쓰레드를 사용하여 데이터를 사용하기 때문에 thread exception이 발생 합니다.
- ### Callback을 사용하는 경우
  - thread를 통하여 서버의 값을 호출하고 다시 메인 쓰레드에 switcing 을 하여 값을 담아주도록 하는 형태는 순차적으로 할 수는 있지만 많은 callBack으로 인하여 메모리 과부하가 걸릴 수 있다. (OOM)

## 코루틴을 사용할 때 
- 별도의 callback, Thread 를 사용하지 않고도 별도의 루틴이 생성되어 위와 같은 상황을 해결할 수 있다.


## Coroutine Builder
### 1. GlobalScope.launch
 - 전역 scope 안에서 coroutine 을 만들어 실행 시킨다. 
 - main 스레드를 멈추지 않고 스코프 안에서만 멈춘다.
### 2. RunBlocking
 - main thread 를 멈추게 한다 (blocking)
 - runBlocking 안에서 다른 thread를 실행할 수 있다.


## suspend fun
- coroutine 에서 일시중단 지점을 찾기 위해 사용되는 함수


## CANCEL
- 코루틴이 실행됨에 있어서 해당 코루틴을 취소 시키는 방법
- 코루틴 취소를 위해서는 코루틴 안에 일시 중단하는 함수(suspend) 함수가 선언 되어 있어야 취소 할 수 있다.
- yield() 함수를 통해 중단 함수를 선언 해 줄 수 있다.
- cancel 될 때 해당 job 에서 Exception 을 던져준다. 그래서 try catch 로 처리 후 해당 코루틴이 취소 되었는지 파악 할 수 있다.
- 혹은 코루틴의 JOB 이 실행중인지 알 수 있는 isActive 를 활용하여 중단된 코루틴인지 확인할 수 있다.

### 1. JOB CANCEL
- job cancel()

### 2. 취소는 협동적이여야 한다.
- 취소 시키는 job 에는 중단 함수(suspend) 가 선언 되어 있어야 취소 할 수 있다.
- 혹은 isActive 를 사용하여 해당 job 이 실행중인지 파악한 후 job 내부 로직을 실행할 수 있다

### 3. TimeOut
- withTimeout or withTimeoutOrNull 을 사용하여 시간 설정을 해준 후 job을 시간을 확인하여 취소를 해준다.