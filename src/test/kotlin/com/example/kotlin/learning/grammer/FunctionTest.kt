package com.example.kotlin.learning.grammer

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class FunctionTest {

    @Test
    @DisplayName("함수 선언 방법")
    fun generateFunc() : Unit {
        // fun 함수명() : 리턴타입 {}
        // 리턴타입 Unit은 Java에서 void, Unit은 생략 가능
        println("Hello Kotlin")
    }

    @Test
    @DisplayName("두개의 값을 더하여 리턴하는 함수를 print ")
    fun printAddFunc(){
        println(addFunc(1,2))
    }

    private fun addFunc(a : Int, b : Int) : Int {
        // fun 함수명(변수명 : 타입 ... ) : 리턴타입 {}
        return a+b;
    }


}