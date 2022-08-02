# Kotlin Grammar

## 1. 함수 (Function)
 ### 1. 리턴타입이 없는 경우
 ~~~ kotlin
 fun 함수명() : Unit { 
    ~~~
 }
 ~~~
 ### 2. 리턴타입이 있는 경우
 ~~~ kotlin
 fun 함수명(a: Int, b : Int) : 리턴타입 { 
    return a+b
 }
 ~~~

## 2. 변수 선언
### 1. val : 재할당 불가 변수 선언
```kotlin
val 변수명 : 리턴타입(생략가능) = 값
```
### 2. var : 일반 변수 선언
```kotlin
var 변수명 : 리턴타입(생략가능) = 값
```
리턴타입은 Kotlin에서 타입을 추론하여 생략 가능

## 3. String Template
- 템플릿 내 선언된 변수 값 집어넣기
- 템플릿 내 변수 ${변수명} 선언
- $(달러) 표기를 하고 싶을때는 백슬래쉬(\)$ 로 선언
~~~kotlin
var name  = "LEE"
var lastName = "YJ"
prinln("name is ${name + lastName} 입니다.") // name is LEEYJ 입니다.
~~~

## 4. 주석
 - 자바와 동일
 - // or /* */

## 5. 조건식
- if / else 사용
  - return 안에 조건문 선언 가능
  - 삼항연산자 처럼 표현 가능
- when 사용
    - java의 switch/case 와 유사
    - when(해당 값) 값 -> 리턴
    - 범위를 지정하여 값을 분기할때는 in 시작값 .. 끝값 사용
- ConditionalTest 참조

## 6. Array and List
### 1. Array
 - 타입을 섞어 여러가지 타입의 요소를 배열에 담을 수 있다.
 - 여러가지 타입의 요소를 배열에 담으면 해당 배열은 수정될 수 없다.
 - 하나의 타입으로 이루어진 array는 배열이 수정 가능하다.
```kotlin
val array = arrayOf(1,2,"ㅎㅇ",true)
val array2 = arrayOf(1,2,3,4)
// array[1] 과 array.get(1) 은 동일하다.
array2[0] = 5

```

### 2. List
- 타입을 섞어 여러가지 타입의 요소를 배열에 담을 수 있다.
- List의 요소들은 수정될 수 없으며, 단순한 읽기 전용이다.
```kotlin
val list = listOf(1,2,"ㅎㅇ",true) 
list[3] = 2 // 불가
```

### 3. MutableList
- 하나의 타입을 가진 요소들로 이루어진 리스트
- 요소를 추가하거나 제거, 수정할 수 있다.
```kotlin
val mutableList = arrayListOf<Int>()
mutableList.add(10)
mutableList.add(20)
```


## 7. 반복문 (For, While)
### &nbsp; 1. for
#### &nbsp;&nbsp;&nbsp; 1.Default
```kotlin
val students = arrayListOf<String>("lee","kim","park")
for(name in students){
  println("이름 : $name")
}

var sum = 0
for(i in 1..10){
    sum +=i
}
// sum = 55

var untilSum = 0
// 1 부터 9까지 (10미만) 반복
for(i in 1 until 10){
  sum +=i
}
// sum = 45
```
#### &nbsp;&nbsp;&nbsp; 2.step
```kotlin
var sum = 0
for(i in 1..10 step 2){
    // 2씩 건너띄어 반복
}
```

#### &nbsp;&nbsp;&nbsp; 3.downTo
```kotlin
var sum = 0
for(i in 10 downTo 5){
    // 10 부터 시작하여 5까지 거꾸로 반복
}
```

#### &nbsp;&nbsp;&nbsp; 3.downTo
```kotlin
var sum = 0
for(i in 10 downTo 5){
    // 10 부터 시작하여 5까지 거꾸로 반복
}
```

#### &nbsp;&nbsp;&nbsp; 4.withIndex
```kotlin
val students = arrayListOf<String>("lee","kim","park")
// Index 와 리스의 Element 를 사용할 수 있는 withIndex
for((index,name) in students.withIndex()){
    println("$index : $name")
}
```

### &nbsp; 2. While
```kotlin
var index = 0
while(index <10){
    index++
}
```


## 8. Nullable
null 값이 가능할 떄 참조는 명시적으로 nullable로 표시되어야 합니다.
타입 선언시 ? 가 붙는다면 null 할당 가능, 그렇지 않다면 null 허용 불가
null 확인을 런타임 때가 아닌 컴파일 시점에서 확인한다.
```kotlin
var nullable: String? = "null 가능"
var nonNullable: String = "null 불가능"
```

### Safe call
```kotlin
val notNull: String = "Kotlin"
val nullable: String? = null
println(nullable?.length)
println(notNull?.length) // 불필요한 Safe Call

println(a?.b?.c?.d?.length) // 해당 객체들 중 null이 하나라도 있다면 null 리턴
```

### 앨비스 연산자 ?:
null 일 경우 대체 변수를 넣어주는 경우 사용하는 연산자
```kotlin
var lastName : String? = null
val noFullName = name + (lastName ?: " No LastName")
// lee No LastName
```

### !! 연산자
변수가 확실하게 null 이 아닐 경우 사용하는 연산자, null이 아닌것을 보장
EX) String? 타입을 String 타입에 할당하려 하는 경우 컴파일 에러가 발생하지만 !! 연산자 사용시 컴파일 성공
```kotlin
fun ignoreNull(str: String?): String {
  val mNotNull: String = str!! 
  // String? 타입인 변수 str이 String 타입인 변수에게 할당하기 위해 null이 아님을 보장하기 위해 !! 사용
  return mNotNull.uppercase()
}
```

## 9. Class
### 생성방법
```kotlin
// 
(open) class class명(name : String){
  
  // 주 생성자
  init {
       
   } 
  
  // 부 생성자
  constructor(val name : String, val age : Int) : this(name){
      
  }
  
  open fun method명(){
      
  }
}
```
1. 코틀린에서 class는 기본적으로 final의 성질을 가지고 있으며 상속을 받기 위해서는 class 앞에 open 명령어를 적어주어야 한다.
2. class 파라미터에 변수 선언 시 해당 class에서는 선언한 변수를 사용할 수 있다.
3. init 명령어를 통하여 class의 주 생성자를 선언하여 생성자 역할을 할 수 있다
4. init 이외의 추가 생성자를 하는 방법으로 constructor 명령어를 사용하여 생성자 추가로 생성 가능 (init이 없다면 constructor으로만 생성자 생성 가능)
5. constructor 에서 좌측에 this 선언 후 클래스에서 파라미터로 사용하는 변수명을 쓸 경우 해당 변수를 사용 가능
6. 메소드 선언 시에 해당 메소드를 다른 클래스에서 override 할 경우 open 명령어를 통하여 외부에 노출 가능하도록 해야 한다.

### 상속
```kotlin
class 서브클래스 : 슈퍼클래스(){
    override fun 슈퍼클래스에서사용하는메소드명(){
        super.슈퍼클래스에서사용하는메소드()
        super.슈퍼클래스에서사용하는 변수
        override 해서 선언할 메소드 내용        
    }
}
```
1. 클래스명 좌측에 :(콜론) 슈퍼클래스명() 선언 시 해당 클래스를 상속받아 사용할 수 있다.
2. 슈퍼클래스에서 open 명령어를 통해 외부에 노출이 된 클래스만 상속 가능하다
3. 슈퍼클래스에서 메소드에 open 명령어를 통해 외부에 노출이 된 메소드를 override 하여 재선언 할 수 있다
4. super 명령어를 통하여 슈퍼 클래스의 메소드와 변수를 사용할 수 있다.

### 사용 방법
```kotlin
fun main(){
    val human1 = Human()
    val human2 = Human("kim")
    val human3 = Human("LEE",30)
  
    // Human을 확장한 객체
    val korean = Korea()
    korean.Human클래스의 메서드
    korean.Korea클래스의 메서드        
}
```