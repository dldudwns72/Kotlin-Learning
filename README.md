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

### When
```kotlin
when{
  number == 0 -> println("숫자는 0")
  number %2 == 0 -> println("숫자는 짝수")
  else -> println("노 숫자")
}
```
위 처럼 when( ) 괄호 안에 값이 없을 경우 조건을 주어 분기를 나눌 수 있다.

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

null이 아니면 실행하고, null이면 실행하지 않는다 (그대로 null)

### 앨비스 연산자 ?:
앞의 결과가 null 일 경우 대체 변수(값)를 넣어주는 경우 사용하는 연산자
```kotlin
var lastName : String? = null
val noFullName = name + (lastName ?: " No LastName")
// lee No LastName

if(njmber == null) { return 0 }
number ?: return 0 // 위에 형태가 이와 같은 형태로 같이 사용할 수 있다. (Ealry Return)
```

### !! 연산자
변수가 확실하게 null 이 아닐 경우 사용하는 연산자, null이 아닌것을 보장
EX) String? 타입을 String 타입에 할당하려 하는 경우 컴파일 에러가 발생하지만 !! 연산자 사용시 컴파일 성공
하지만 null 값이 들어온다면 런타임시 NPE 예외 발생
```kotlin
fun ignoreNull(str: String?): String {
  val mNotNull: String = str!! 
  // String? 타입인 변수 str이 String 타입인 변수에게 할당하기 위해 null이 아님을 보장하기 위해 !! 사용
  return mNotNull.uppercase()
}
```

### 플랫폼 타입
```kotlin
JAVA
// null 제어 여부에 따라 코틀린에서 어노테이션을 이해하고 null 체크가 일어난다, 어노테이션이 없다면 컴파일 시 에러는 안나지만 런타임시 에러가 발생할 수 있다.
@NotNull, @Nullable, X 
public String getName() {
    return name;
}

```

## 9. Class
### 생성방법
```kotlin
                    // 주 생성자
(open) class class명(name : String){
  
  init {
       클래스가 초기화 되는 시점에 한번 실행되는 블록, validation 로직을 넣기 좋다
    if(number >=0){
        throw new IllgelArgumentException()
    }
   } 
  
  // 부 생성자, 다른 생성자를 만들기 위해 사용함, 최종적으로는 주 생성자를 호출하기 위해 사용
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


- 기본적으로 constructor을 사용하는 것 보다 주 생성자에 default parameter 값을 넣어 사용하는 것을 추천한다

### 추상 클래스
코틀린도 자바와 마찬가지로 abstract를 사용하여 추상 클래스를 만든다.
추상클래스이니깐 변수는 final로 간주 되어서 val 로 선언을 해야한다.
```kotlin
abstract class Animal(
    protected val species: String, 
    protected open val legCount: Int // 해당 변수를 open 해주지 않으면 외부에서 변경할 수 없다.
){
    abstract fun move(){
        
    }
}

class Cat(
  species: String
) : Animal(species, 4){ // Cat 객체 생성 시 주 생성자에서 받은 변수 species를 사용하고 legCount는 선언 해준 값으로 넣어준다.
  override fun move(){
    println("~~~~")
  }
  
  private val tailCount = 1
  
  override val tailCount: Int 
    get() = super.legCount + this.tailCount // open 키워드를 사용하여 외부로의 확장을 해주어야 한다. 
}
```
클래스를 상속 받을때도 변수 처럼 콜론(:)를 사용하지만 컨벤션으로 변수는 변수명 바로 옆에, 상속은 한칸 띄고 콜론을 선언한다.
또한 자바와 코틀린은 추상클래스는 인스턴스화 할 수 없다.
상위 클래스를 설계할 때 생성자 또는 초기화 블록에 사용되는 프로퍼티에는 open을 피해야 합니다.

### Interface
사용 목적은 자바와 동일하다
```kotlin
interface interface명{
  fun 메소드{
        
  }
  fun 디폴트메소드(){
      
  }
}
--------------------------------------------
class 클래스명() : 인터페이스 {
    
    override fun 인터페이스선언메서드명() {
        super<인터페이스>.인터페이스선언메서드명()
    }
}
```
Java의 디폴트 메소드와 같이 사용할 수 있으며 코틀린은 앞에 default를 선언해주지 않아도 된다.
사용 방법은 추상클래스와 같이 콜론(:)을 이용하여 사용할 수 있으며 중복되는 인터페이스를 특정할 떄 super<타입>.함수 를 사용한다.
또한 인터페이스 내부에서 custom getter를 사용하여 변수의 값을 선언할 수 있다.



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

### custom getter
property 처럼 사용하기 위해 get() 을 선언하고 값을 넣어준다
기존의 get과 다 동일한 기능이지만 가독성에 따라 할 수 있는 방법으로 사용하면 된다

- 프로퍼티(property) : 필드 생성시 getter,setter가 있는 변수를 프로퍼티라 칭한다.
```kotlin
class Person (
  name: String, // 여기서 var,val 을 선언하면 자동으로 get,set이 생긴다.
  var age: Int
  ){   
  
// JAVA
public boolean isAudult(){
    return this.age >= 20
}

// Kotlin
fun isAdult(): Boolean {
    return this.age > 20
}
혹은
val isAdult: Boolean
 get() = this.age >= 20 // property 처럼 보이는 custom getter
  
// backing field  
  val name: String = name 
    get() = field.uppercase()
  
  var name = name // set이므로 var로 선언
    set(value){
        field = value.uppercase() // 들어오는 값을 모두 대문자로 바꿔서 set 한다.
    }
  
}

```
cutsom getter를 사용하여 파라미터로 통해 넘어온 값을 변경하여 get을 반환할 수 있다.
주 생성자에 있는 변수에 값을 할당해주기 위해 body안에서 변수를 다시 선언하고 get body 부분에 <strong>field</strong>를 선언해주어 해당 변수에 접근을 하며
값을 바꾸는 로직을 설정한 후 식을 마무리 하면 get 시 값이 변경되서 적용된다.

하지만 backing field를 사용하는 것 보단 별도의 함수를 만들어서 프로퍼티를 변경하는것이 좋다라고 생각된다.

## 10. 람다식 (Lamda)
 value 처럼 사용할 수 있는 익명 함수
 1. 메소드에 파라미터로 람다식을 넘겨줄 수 있다.
 2. return 값으로 사용할 수 있다.

### 기본 람다식 정의
```kotlin
val lamdaName1 : Type = { argumentList -> codeBody }
val lamdaName2 = { number : Int -> number * number}
val lamdaName3 = { name: String, age : Int -> "$name , $age (타입 추론 가능)"}
 // -> lamdaName("이름", 30) -> 이름, 30 (타입 추론 가능) 
```

### 확장함수
```kotlin
val extendLamda : String.() -> String = {
    "$this 이것은 람다 확장 함수"
}

var name = "LEE"
name.extendLamda() // -> LEE 이것은 람다 확장 함수
```
String 객체에 대하여 확장하여 함수를 만들 수 있다 (String.())

```kotlin
val extendWithAnotherType : String.(Int) -> String = {
  "$this 다른 파라미터를 받을 수 있다 $it 이것으로"
}
var stringThing = "호출 객체"
var intThing = 10
stringThing.extendWithAnotherType(intThing)
// -> 호출 객체 다른 파라미터를 받을 수 있다 10 이것으로
```

확장 함수를 사용하기 위해서는 그 함수를 다른 클래스나 함수와 마찬가지로 임포트 해야한다. <br/>
확장 함수의 이름이 같다면 import 시 as를 사용하여 별칭을 붙혀 이름을 다르게 하여 임포트 해야한다. <br/>
확장 함수에서는 본인 자신을 this로 호출하고, 생략 가능하다 <br/>

import 패키지명.extendWithAnotherType (확장함수) <br/>
해당 변수의 현재 타입 즉, 정적인 타입에 의해 어떤 확장함수가 호출될지 결정된다. EX) 변수: 반환타입 (정적 타입) = 값 이르 봤을 떄 반환 타임에 대하여 확장함수 호출함  <br/>

확장 함수는 클래스 밖에서 선언되며 호출 시 수신 객체로 지정한 변수의 정적 타입에 의해 호출이 결정되므로 확장 함수는 오버라이드 될 수 없다. <br/>
확장 함수와 멤버 함수가 이름이 겹치게 된다면 멤버 함수가 우선적으로 호출 된다. 오류가 발생함 <br/>
확장함수는 원본 클래스의 private, protected 멤버 접근이 불가능하다 <br/>

### 확장 프로퍼티
프로퍼티도 확장 가능하나 상태를 저장 할 수 없어 최소한 getter는 정의해주어야 한다.
```kotlin
var String.lastChar: Char
  get() = get(length - 1) // getter 정의
  set(value : Char) {
      this.setCharSet(length - 1, value)
  }

println("String값".lastChar) // >>> n
val sb = StringBuilder("Kotlin?") 
sb.lastChar = "!" // (setter로 설정한 로직을 탐)
println(sb) // >>> Kotlin!
```

### infix 함수
함수 선언 (fun) 앞에 붙는 지시어로 중위 호출 처럼 사용할 수 있게 해주는 함수 선언 방식이다
```kotlin
infix fun Int.add(other: Int): Int {
    return this + order
}

3 add 4 
```
위 처럼 infix 지시어 사용 시 함수를 중위 호출 처럼 사용 할 수 있습니다.


### inline 함수
함수가 호출되는 대신, 함수를 호출한 지점에 함수 본문을 그대로 복붙하고 싶은 경우 사용되는 함수<br/>
내부적으로 코드를 복사하기 떄문에, 인자로 전달 받은 함수는 다른 함수로 전달되거나 참조될 수 없습니다.
```kotlin
inline fun Int.add(other: Int): Int {
    return this + order
}

```
inline 함수의 사용은 성능 측정과 함께 신중하게 사용되어야 합니다.

### 지역함수
함수 내부에 비슷하게 사용되는 로직이 있다면 해당 내용을 다시 함수로 만들어 사용할 수 있다.

### 람다
이름없는 함수 
```kotlin
val isApple: (Fruit) -> Boolean = fun(fruit: Fruit) : Boolean {
    return fruit.name == "사과"
}
==

val isApple2:  (Fruit) -> Boolean = {fruit: Fruit -> fruit.name == "사과"}

// fruit 리스트와 리스트를 필터링하는 함수를 파라미터로 받아 필터링된 fruit를 반환하는 함수
private fun filterFruits(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit> {
    val result = mutableListOf<Fruit>()
    for (fruit in fruits) {
        if(filter.invoke(fruit)){
            results.add(fruit)
        }
    }
  return results
}

// 함수가 제일 마지막 파라미터로 설정 될 경우 아래와 같이 파라미터 부분에 함수를 넣지 않고 소괄호 밖에 람다를 사용 가능하다.
filterFruits(fruits) { it.name == "사과"} // it은 변수가 하나일 경우만 사용 가능
```
함수의 이름을 선언하지 않고 해당 리턴을 그대로 변수로 사용할 수 있다. <br/>
그러므로 변수에 할당한 함수를 파라미터로 사용할 수 있고, 익명 클래스처럼 바로 파라미터에 선언해서 사용할 수 있다.

함수의 타입 : (파라미터 타입 ...) -> 반환 타입 <br/>


### 람다의 Return
```kotlin
val returnLamda : (Type) -> ReturnType = {
    when(it){ // 파라미터가 한 개일 경우 it 으로 사용 가능하다
      in ~ -> 리턴값1
      in ~ -> 리턴값2
      else -> 해당하는 경우가 없는 경우 리턴값
    }
}
```

### 메서드 안의 람다 
```kotlin
// 람다식을 파라미터로 받아 람다식의 리턴값을 리턴한다.
fun invokeLamda(lamda : (Type) -> Type) : returnType {
    return lamda(Type)
}

val lamda = {number : Double -> number == 3.22}
invokLamda(lamda) // 람다식 선언 후 인자로 사용하여 메서드 사용
invokLamda {true} // 리턴형 직접 선언
invokLamda {it >= 3.21 } // 람다식을 바로 구현해도 된다.
```
 해당 예제 에서는 Double 타입을 파라미터로 받아 Boolean 값으로 값을 리턴해주는 람다식의 결과물을 리턴해주는 예제이다.

## 다양한 컬렉션 처리 기능

### filter & map
- filter : 리스트.filter { 식 } , 요소 내부 조건이 만족하는 요소만 찾아 배열로 반환, filterIndexed를 사용하여 인덱스를 같이 사용할 수 있다.
- map :  리스트.map{ 식 }, 리스트 내부를 돌면서 값을 변환 시켜주어 새로운 배열로 반환하는 함수, mapIndexed를 사용하여 인덱스를 같이 사용할 수 있다.
- mapNotNull : null이 아닌 결과만 가져오고 싶을 때 사용하는 함수

### all & none & any
- all : 리스트.all { 조건 } , 조건을 모두 만족하면 true, 아니면 false
- none : 리스트.none { 조건 } , 조건을 모두 불만족하면 true, 아니면 false
- any : 리스트.any { 조건}, 조건을 하나라도 만족하면 true, 그렇지않으면 false

### count & sortedBy & distinctBy
- count : 리스트.count(), 리스트의 크기 반환
- sortedBy : 리스트.sortedBy { 선언된 변수 }, 선언된 변수 기준으로 오름차순 정렬
- sortedByDescending : sortedBy의 반대, 내림차순
- distinctBy : 리스트.distinctBy { 중복 제거할 식}, 변형된 값을 기준으로 중복을 제거한다.

### first & last
- first : list.first(), 첫번째 값을 가져온다 (무조건 null이 아니어야함), list가 빈 경우 Exception 발생
- firstOrNull: list.firstOrNull(), 첫번째 값 또는 null을 가져온다
- last : list.last(), 마지막 값을 가져온다 (무조건 null이 아니어야함), list가 빈 경우 Exception 발생
- lastOrNull: list.lastOrNull(), 마지막 또는 null을 가져온다

### List -> Map groupBy (그루핑)
```kotlin
val map: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name}
```
과일이름 (fruit.name) 기준으로 키가 생성되고 value 값으로 해당 과일이름에 대한 리스트 생성

### id -> Map associateBy (그루핑)
```kotlin
val map: Map<String, Fruit> = fruits.associateBy { fruit -> fruit.id}
```
중복되지 않는 키를 가지고 map을 만들 때 사용된다.


## 11. Data Class (POJO)
toString(), hashCode(), equals(), copy() 메서드를 자동으로 생성하여 사용할 수 있는 Class
```kotlin
data class class명 (val ~ , var~ ...)
```

### Enum Class
추가적인 클래스를 상속 받을 수 없으며, 인터페이스는 구현할 수 있으며, 각 코드가 싱글톤인 상태가 ENUM 이다.
```kotlin
enum class Country(
  private val code: String
){ 
  KOREA("KO"),
  AMERICA("US")
}
```

```java
public enum Country{
  KOREA("KO"),
  AMERICA("US")
  ;
  
  private final String code;

  Country(String code){
      this.code = code;
  }
}
```
위의 코틀린 enum class와 java enum 클래스는 동일한 내용의 코드이다 

Enum에 대한 분기처리를 할 때 코틀린에서는 when을 사용해서 가독성 있는 분기처리를 할 수 있다.
```kotlin
fun handleCountry (country: Country){
    when(country){
      Country.KOREA -> TODO()
      Country.AMERICA -> TODO()
      // else -> // 해당 구문을 선언하지 않아줘도 된다 이미 enum값 내부를 알고 있으므로 
    }
}
```

### Sealed Class, Sealed Interface
Enum 클래스 보다 유연하지만, 하위 클래스를 제한 하는 sealed class <br/>
컴파일 타임 때 하위 클래스의 타입을 모두 기억한다 즉 런타임때 클래스 타입이 추가 될 수 없다. <br/>
하위 클래스는 같은 패키지에 있어야 한다. Enum 과 다른점은 클래스를 상속 받을 수 있으며, 하위 클래스는 멀티 인스턴스가 가능하다.

추상화가 필요한 Entity or DTO에 sealed class를 활용한다.
```kotlin
sealed class Car(
  val name: String,
  val price: Long
)

class Avante: Car("아반떼",2000)
class Sonata: Car("소나타",3000)

------------------------------
fun 함수(car: Car)
when (car){
    is Avante -> TODO()
    is Sonata -> TODO()
}
```


## 12. private class, Companion
private class 나 method를 읽을 수 있도록 하는 companion object, Java의 static과 같은 기능 <br/>
companion object (동반 객체)는 하나의 객체로 간주되어 이름을 붙일 수도 있고, interface를 구현할 수도 있다.
```kotlin
class class명 private construtor(val ~, val ~ ...){
  companion object 생성메서드명 : 인터페이스 { // 이름 생략 가능, 이름을 넣는 순간 객체 생성시 Companion 선언 대신 생성한 이름으로 사용, 상속 가능
    val myBook = "변수 선언"
    fun create() = Book(getId(), myBook)
    
    
    override fun getId(): Int {
      return 55;
    }
  }

  val 인스턴스명 = 클래스명.create()
  val 인스턴스명 = 클래스명.생성메서드명.create()
  val 변수 = 클래스명.getID() // 해당 값 참조
  ------------------------------------
  companion object {
    private const val MIN_AGE = 1
    
   @JvmStatic
   fun jvmStaticFun(): 리턴타입 {
       return ~
   }
  }
  
  val 인스턴스명 = 클래스.jvmStaticFun() // @JvmStatic을 선언하지 않으면 클래스.Companion.jvmStaticFun 으로 선언 해야 한다.
}

```
중간에 있는 코드 "private const val MIN_AGE = 1" 코드는 companion object안에서 사용 가능한 변수 이다<br/>

@JvmStatic 어노테이션을 사용한다면 companion object 에 이름을 할당해 주지 않아도 클래스 선언 후 바로 사용할 수 있다.

## 13. object Class, SingleTon Pattern
Java의 싱글톤 패턴과 같이, 하나의 객체가 전역적으로 사용되어 정보를 가지고 있을 떄 사용
```kotlin
object Class명 {
    ....
}
val 인스턴스명 = Class명.메서드명()
```
생성된 인스턴스는 다른곳에서 전역적으로 사용 가능하다.

### 익명 클래스
특정 인터페이스나 클래스를 상속받은 구현체를 일회성으로 사용할 떄 쓰는 클래스<br/>
코틀린에서는 "object: 타입이름" 를 사용하여 익명 클래스를 선언한다.
```kotlin
moveSomething(object: Moveable {
    override fun move(){
        println("움직인다.")
    }
})
```
Java에서는 인자로 new Moveable 해서 익명클래스를 구현하여 인자로 넘겨주었지만 kotlin 에서는 위 코드처럼 구현하여 동작한다.

### 중첩 클래스

#### 1. 클래스 내부의 클래스
 - 내부 클래스가 외부 클래스를 참조 할 수 있도록 만든 내부 클래, 지양하는 내부 클래스
 - inner 예약어를 사용하여 코틀린에서는 바깥 클래스를 참조 할 수 있는 내부 클래스를 사용할 수 있다.
 - 바깥 클래스 참조를 위해 this.@바깥 클래스 로 사용할 수 있다

#### 2.static 내부 클래스 (권장)
 - 내부클래스 선언 시 static을 사용
 - 코틀린에서는 static 이 없기 때문에 그냥 내부 클래스로 선언해도 코틀린은 바깥 클래스에 대한 연결이 없는 중첩 클래스가 만들어진다.

## 14. Type
코틀린에서는 변수 타입이 추론 가능하여 변수의 타입을 알 수 있다.
하지만 자바와 달리 작은 타입 + 큰 타입에 대해 자동으로 변환하여 더하여 값을 주지 않는다 (암시적 변경 불가능)
그러하여 to변환타입()을 사용해야 합니다.

### 기본 타입 변환
```kotlin
val number1 = 3
val number2 : Long = number1.toLong()
```

### 타입 캐스팅
```kotlin
fun printAgeIfPerson(obj : Any){
    if ( obj is Person){  // !is
        val person = obj as Person // as?
        println(person) // smart cast
    }
}
```
- (!)is : Java에서 instanceOf와 동일, obj가 Person이라면 true, 아니면 false, 느낌표(!) 를 앞에 붙이면 반대 의미 <br/>
value <strong>is</strong> Type : value 가 Type 이면 true, 아니면 false

- as(?) : Java에서 타입 캐스팅과 동일, obj라는 변수를 Person 타입이라 간주한다.<br/>
물음표(?) 가 붙을 경우 obj가 null 이 아니라면 Person 타입으로 변화를 시키고, null 이라면 safe call 처럼 전체 null이 되는 것 <br/>

### 코틀린 특이 타입
#### 1. Any
- Java의 Object class 역할 (모든 객체의 최상위 타입)
- 모든 Privitive Type의 최상의 타입도 Any이다. 
- Any 자체로는 null을 포함할 수 없어 null을 포함하고 싶다면, Any? 로 표현
- Any 에 equals / hasCode / toString 존재

#### 2. Unit
- Java의 void 역할 (모든 객체의 최상위 타입)
- void와의 차이점은 Unit 그 자체로 타입 인자로 사용 가능
- 함수형 프로그래밍에서 Unit은 단 하나의 인스턴스만 갖는 타입, 코틀린의 Unit은 실제 존재하는 타입

#### 3. Noting
- 함수가 정상적으로 끝나지 않았다는 사실을 표현하는 역할
- 무조건 예외를 반환하는 함수 / 무한루프 함수 등
```kotlin
fun fail(message : String) : Nothing {
    throw java.lang.IllegalArgumentException(message)
}
```

#### 객체간 비교 연산자
객체간 비교 연산을 하는 경우 코틀린에서는 객체1 > 객체2 로 선언 했을 경우 자동으로 compareTo를 호출하여 사용한다.
```kotlin
val money1 = Money(1000)
val money2 = money1
val money3 = Money(2000)

money1 > money3 // compareTo 호출하여 비고
money1 === money2 // 동등성 비교 ( 값이 같은지)
money1 == money3 // 동일성 비교 (주소값이 같은지, Java의 equals 호출)
```

## 예외 처리

### 1. trt catch finally 
```kotlin
try {
    ~~
}catch (e : Exception){
    throw IllegalArgumentException("잘못된 인자 입력")
}
```
문법적으로는 java try catch finally 완전 동일
타입이 뒤에 위치하고 있으며, new 연산자를 사용하지 않고 포맷팅이 간결하다

```kotlin
fun parseIntOrThrow(str: String): Int? {
  return try {
      str.toInt()
  }catch (e : Exception){
      throw IllegalArgumentException("잘못된 인자 입력")
  }
}
```
try ~ catch 가 expression 으로 표현 될 수 있다

### 2. Checked Exception, Unchecked Exception
코틀린은 모두 Unchecked Exception 으로 처리가 된다.
throws를 하지 않는다.
?? 먼내용이지


### 3. try with resources
코틀린에서는 자바 처럼 정식적으로 try with resource 라는 구문은 없다
use를 사용하여 같은 기능을 구현한다.
```kotlin

```

### default parameter
```kotlin
fun repeat(str: String, num: Int = 3, isUse : Boolean = false){
    
}
repeat("REPEAT") // repeat("REPEAT",3,false) 와 동일
```
밖에서 파라미터를 넣어주지 않는다면 파라미터 값에 넣은 기본값을 사용한다.

### named argument
```kotlin
fun repeat(str: String, num: Int = 3, isUse : Boolean = false){
    
}
repeat("REPEAT", isUse = true)  //repeat("REPEAT",3,true) 와 동일
```
인자에 변수명을 같이 선언해주어 값을 설정 할 수 있다 (변수의 순서와 상관없이)
빌더패턴처럼 사용할 수 있다
해당 문법은 Java 에서는 사용할 수 없다.

### 같은 타입의 여러 파라미터 받기 (가변인자)
```kotlin
fun method(vararg strings: String){
    
}
val array = arrayOf("a","b","c")
method(*array)
```
vararg를 사용하여 가변인자를 받을 수 있으며, 
가변인자 함수를 배열과 호출할 떄는 배열을 바로 넣는 대신 스프레드 연산자(*)를 붙여주어야 한다.

## 접근 제어자
코틀린은 자바와 달리 패키지로 관리되는 것이 아닌 C#의 namespace 처럼 파일로 관리 된다 <br/>
그러하여 접근 제어를 선언해주는 방법이 JAVA랑 약간 다르다
생성자에 접근 지시어를 붙일 때는 constructor를 명시적으로 써주어야 한다.

### 1. public
모든 곳에서 접근 가능
### 2. protected 
선언된 클래스 또는 하위 클래스에서만 접근 가능 <br/>
자바에서의 같은 패키지에서 사용 가능하다는 제어가 사라짐
### 3. internal
같은 모듈에서만 접근 가능
### 4. private
선언된 클래스 내에서만 접근 가능

### java와 kotlin을 함께 사용할 때 주의할 점
Internal은 바이트코드 상 public이 되므로 Java 코드에서는 Kotlin 모듈의 Internal 코드를 가져올 수 있습니다.
또한 Kotlin의 protected와 Java의 protected는 다르며, Java는 같은 패키지의 Kotlin protected 멤버에 접근할 수 있다.


## Type Alias &  as Import
### 1. Type Alias
```kotlin
typealias FruitFilter = (Fruit) -> Boolean

fun filterFruits(fruits: List<Fruit>, filter: FruitFilter) { // (Fruit) -> Boolean
    
}

-----------------------------------------
data calss 이름이긴클래스이다(
  val name: String
)

typealias USGTMap = Map<String, 이름이긴클래스이다>
```
이름이 긴 클래스를 컬렉션에 사용하거나, 반환형이 길 경우 별칭을 주어 간단하게 사용 할 수 있다.

### 2. as Import
```kotlin
import package경로~~~ as 별칭
```
다른 패키지의 동일한이름의 다른 함수를 사용하고 싶을 떄 별칭을 주어 구분하는 것으로 as 뒤에 별칭으로 import 한 내용을 사용한다.


## forEach 에서의 break & continue
### break
```kotlin
run {
    numbers.forEach { number -> if(number ==2) { return@run } }
}
```

굳이 forEach안에서 break 조건을 걸고 싶다면, run 안에 선언해주고 break 부분에 return@run을 명시한다.

### continue
```kotlin
    numbers.forEach { number -> if(number ==2) { return@forEach } }
```
굳이 forEach안에서 continue 조건을 걸고 싶다면 break 부분에 return@forEach 명시한다. <br/>

하지만 웬만하면 for문안에 기존에 사용하던 for문 안에서 처리하는것이 좋다.


## Label@
```kotlin
loop@ for(i in 1..100){
    for(j in 1..100){
        if(j == 2){
            break@loop
        }
    }
  println("${i} , ${j}") // 1 , 1
}
```
for 문 선언 전에 라벨 표기 후 for문 안에서 break@라벨명 시 안쪽 for문에서 멈추는 것이 아닌 바깥쪽 for문에서 반복이 중지됩니다. 하지만 사용하지 않는것을 추천합니다.


## method chaning 을 위한 TakeIf & TakeUnless
### TakeIf
```kotlin
fun getNumberOrNull(): Int? {
    return if(number <= 0){
        null
    } else {
        number
    }
}

========= 동일한 코드 ===================

fun getNumberOrNull(): Int? {
    return number.takeIf { it > 0} // 참이면 number 반환, 아니면 null 반환
}

```
주어진 조건을 만족하면 그 값이, 그렇지 않으면 null이 반환된다.

### TakeUnless
```kotlin
fun getNumberOrNull(): Int? {
    return number.takeUnless { it <= 0} // 참이면 null 반환, 아니면 number 반환
}
```
주어진 조건을 만족하지 않으면 그 값이, 그렇지 않으면 null이 반환된다.


## Scope Function 
- 람다를 사용해 일시적인 영역을 만들고, 코드를 더 간결하게 만들거나, method chaning에 활용하는 함수를 뜻함

### let
- 람다의 결과를 나타내는 let
- 파라미터를 일반 함수로 받아 함수 내부를 사용하므로 it을 사용 
- 하나 이상의 함수를 call chain 결과로 호출 할 때
- non-null 값에 대해서만 code block를 실행 시킬 떄 (많이 사용됨)
- 일회성으로 제한된 영역에 지역 변수를 만들 떄

### run
- 람다의 결과를 나타내는 run
- 파라미터를 확장 함수로 받아 본인 자신을 this로 호출하고 생략할 수 있다 , this를 사용
- 객체 초기화와 반환 값의 계산을 동시에 해야할 떄 EX) 객체를 만들어 DB에 바로 저장하고 저장하고 난 뒤의 인스턴스를 활용할 떄

### also
- 객체 그 자체가 반환된다, it을 사용
- 객체를 수정하는 로직이 call chain 중간에 필요할 때 (객체 수정 중 중간 로직을 추가하고 싶을 떄)

### apply
- 객체 그 자체가 반환된다, this를 사용
- 객체를 수정하는 로직이 call chain 중간에 필요할 때 (값을 설정해주고 해당 객체를 반환해 줄 떄) 

### it 과 this의 차이점
this : 생략이 가능한 대신, 다른 이름을 붙일 수 없다.  EX) person.run { age } // this.age를 사용하지 않고 age만을 사용 가능 
it : 생략이 불가능한 대신, 다른 이름을 붙일 수 있다.  EX) person.let { p -> p.age } // it 대신 p를 사용

```kotlin
val value1 = person.let {
    it.age
}

val value2 = person.run {
  this.age
}
=========value1,value2는 람다의 결과인 age를 나타냄 ============

val value3 = person.also {
  it.age
}

val value4 = person.apply {
  this.age
}
=========value3,value4는 객체 자체인 persion을 최종값으로 리턴 ============
```

### with(파라미터, 람다)
- this를 사용해 접근하고, this는 생략 가능하다.
- 특정 객체를 다른 객체로 변환해야 하는데, 모듈 간의 의존생에 의해 정적 팩토리 혹은 toClass 함수를 만들기 어려울  