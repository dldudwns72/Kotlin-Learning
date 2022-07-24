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
- ConditionalTest 참조 
- 

