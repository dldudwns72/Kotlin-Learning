package com.example.kotlin.learning.grammer

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LoopTest {


    @Test
    @DisplayName("for문")
    fun forTest(){
        val students = arrayListOf<String>("lee","kim","park")
        for(name in students){
            println("이름은 :  $name")
        }

        var sum : Int = 0
        for(i in 1..10){
            sum+= i
        }
        assertThat(sum).isEqualTo(55)

        var sumStep : Int = 0
        // 2만큼 띄워서 반복 1,3,5,7,9
        for(i in 1..10 step 2) {
            // 1,3,5,7,9
            sumStep+= i
        }
        assertThat(sumStep).isEqualTo(25)

        var sumDownTo = 0
        // 10부터 5까지 거꾸로 덧셈
        for(i in 10 downTo 5){
            sumDownTo += i
        }
        assertThat(sumDownTo).isEqualTo(45)

        var sumUntil= 0
        // 10부터 5까지 거꾸로 덧셈
        for(i in 1 until 10){ // 1~99번까지 (100을 실행하지 않는다는것)
            sumUntil += i
        }
        assertThat(sumUntil).isEqualTo(45)
    }

    @Test
    @DisplayName("인덱스와 이름 같이 사용하는 withIndex")
    fun forIndexWithName(){
        val students = arrayListOf<String>("lee","kim","park")

        for((index,name) in students.withIndex()){
            println("$index : $name")
        }
    }

    @Test
    @DisplayName("while 문")
    fun whileTest(){

        val students = arrayListOf<String>("lee","kim","park")

        var index = 0
        while(index < 10){
            println(index)
            index++
        }

        var withIndex = 0

    }



}