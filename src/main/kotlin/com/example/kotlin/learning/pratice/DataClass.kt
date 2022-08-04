package com.example.kotlin.learning.pratice

// toString(), hashCode(), equals(), copy() 메서드를 자동으로 만들어 준다.
data class DataClass(val companyName : String, val name : String, var date : String, var seatNumber : Int)

class DataClassNormal(val companyName : String, val name : String, var date : String, var seatNumber : Int)

fun main(){
    val ticketA = DataClass("Air","LEE","2022-02-02",13)
    val ticketB = DataClassNormal("Air","LEE","2022-02-02",13)
    val ticketC = DataClass("Air","LEE","2022-02-02",13)
    val ticketD = DataClassNormal("Air","LEE","2022-02-02",13)

    println(ticketA) // toString 형태 출력
    println(ticketA.equals(ticketC)) // true
    println(ticketA.hashCode())
    println(ticketA.copy())

    println("------------------")

    println(ticketB) // 객체 메모리 주소 출력
    println(ticketB.equals(ticketD)) // false
    println(ticketB.hashCode())

}

