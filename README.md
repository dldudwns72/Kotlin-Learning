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
