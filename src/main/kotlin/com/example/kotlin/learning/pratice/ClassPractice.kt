package com.example.kotlin.learning.pratice

// class 는 default 가 외부로 노출할 수 없어서 open 을 사용함으로써 외부에서 상속을 할 수 있도록 한다.
open class ClassPractice (var name : String = "Anonymous"){

    // 부 생성자는 클래스의 인자를 받아야 한다. 주 생성자가 없으면 constructor으로 선언된게 주 생성자가 된다.
    constructor(name: String, age :Int) : this(name){
        println("이름은 : $name 나이는 : $age")
    }

    // 객체 생성 시 실행 시키는 것, 주 생성자
    init {
        println("Create Member")
    }

    open fun eatingCake(){
        println("Eating Cake")
    }
}

class Korean(var lastName : String = "Korean") : ClassPractice(){

    override fun eatingCake(){
        super.eatingCake()
        super.name = "KIM"
        println("Eating Cake With Korean $name")
    }

}

fun main(){
    val eating = ClassPractice("lee")
    eating.eatingCake()
    println(eating.name)
    println("-----------------")

    val eating2 = ClassPractice()
    println(eating2.name)
    println("-----------------")

    val eating3 = ClassPractice("park",30)
    // 이름은 : park 나이는 : 30
    println("-----------------")

    val korean = Korean("JU")
    korean.eatingCake()
    println( korean.lastName)

    val korean2 = Korean()
    korean2.eatingCake()

}