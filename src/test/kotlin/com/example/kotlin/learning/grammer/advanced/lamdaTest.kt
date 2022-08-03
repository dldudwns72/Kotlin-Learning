package com.example.kotlin.learning.grammer.advanced

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * Lamda 식 이란
 *  - 마치 value 처럼 사용할 수 있는 익명 함수
 *   1) 메소드에 파라미터로 넘겨줄 수 있다.
 *   2) return 값으로 사용할 수가 있다.
 *
 *   람다의 기본 정의
 *   val lamdaName : Type = { argumentList -> codeBody }
 */
class lamdaTest {

    //              input   output (타입을 선언해줌으로써 람다식 안에 변수(number)를 타입 추론 할 수 있다)
    // val square : (Int) -> (Int) = { number -> number * number} // 아래와 동일
    val square = { number : Int -> number * number}

    @Test
    fun printSquare(){
        val result = square(12)
        assertThat(result).isEqualTo(144)
    }

    val nameAge = {name : String, age : Int ->
        "my name is $name i'm $age"
    }

    @Test
    fun printNameAge(){
        val result = nameAge("lee",30)
        assertThat(result).isEqualTo("my name is lee i'm 30")

    }

    // 확장함수
    val pizzaIsGrate : String.() -> String ={
        "$this pizza is Grate"
    }

    @Test
    fun printPizza(){
        var pizzaName  = "Gold"
        println( pizzaName.pizzaIsGrate() )
    }

    val nameHeight : String.(Int) -> String = {
        // this 는 해당 람다식을 호출하는 객체를 뜻함, it 은 파라미터가 하나만 들어올 겨웅 해당 파라미터를 it으로 사용할 수 있다.
        "name is $this and height is $it"
    }

    @Test
    fun printNameAndHeight(){
        var name  = "YJ"
        println( name.nameHeight(180) )
    }

    // 람다의 return
    val calculatorGrater : (Int) -> String = {
        when(it){
            in 0..10 -> "fail"
            in 11..50 -> "pass"
            in 51..100 -> "perfect"
            else -> "error" // else 를 선언해주지 않는다면 it 에 100 이상 값이 올 경우 에러가 나와서 when 절 자체에서 문법 에러가 납니다.
        }
    }

    @Test
    fun printCalculator(){
        var number : Int = 11;
        println( calculatorGrater(number) )
    }

    // 람다를 표현하는 여러가지 방식
    fun invokLamda(lamda : (Double) -> Boolean) : Boolean {
        return lamda(3.22)
    }

    @Test
    fun invokLamdaTest(){
        val lamda = {number : Double -> number == 3.22}
        println( invokLamda(lamda) )
        println( invokLamda {true} )
        println( invokLamda {it >= 3.21 } ) // invokLamda ({it >= 3.21 }) ) 와 동일, 람다식 안에는 소괄호를 생략할 수 있다.
    }

}