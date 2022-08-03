package com.example.kotlin.learning.grammer

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ConditionalTest {

    @Test
    fun printMaxValue(){
        assertThat(maxBy(1, 2)).isEqualTo(2);
        assertThat(maxBy2(2, 4)).isEqualTo(4);
        assertThat(maxBy3(6, 2)).isEqualTo(6);
    }

    private fun maxBy(a :Int,b : Int) : Int{
        if(a > b){
            return a;
        }else{
            return b;
        }
    }

    private fun maxBy2(a:Int,b :Int) : Int{
        return if(a > b){
            a;
        }else{
            b;
        }
    }

    private fun maxBy3(a:Int,b :Int) = if(a>b) a else b;

    @Test
    fun printCheckNum(){
        checkNum(5)
        assertThat(checkReturnNum(50)).isEqualTo(100);
        assertThat(checkReturnNum(3)).isEqualTo(6);
        assertThat(whenInTest(5)).isEqualTo("Over 1 Under 10")
        assertThat(whenInTest(33)).isEqualTo("Big Number")

    }

    private fun checkNum(score : Int){
        // return 할 값이 없으면 when 안에 else를 선언하지 않아도 된다.
        when(score){
            1 -> println("1점 입니다.")
            3 -> println("3점 입니다.")
            5,6,7 -> println("5점 이상 7점 이하 입니다.")
        }
    }

    private fun checkReturnNum(score : Int): Int {
        var num = when(score){
            1 -> score
            3 -> score + 3
            5,6,7 -> score + 10
            else -> 100 // 생략 시 에러
        }
        return num;
    }

    // 티입 추론은 변수에만~
    private fun whenInTest(score:Int) : String{
        var returnValue =  when(score){
            in 1..10 -> "Over 1 Under 10"
            in 11..20 -> "Over 11 Under 20"
            else -> "Big Number"
        }

        return returnValue
    }

    @Test
    @DisplayName("list 에서 요소를 찾아 분기를 타는 경우")
    fun whileInList(){
        val list = listOf<String>("aA","bB","cC")

        var returnValue : String


//       when{
//           "A" in list -> returnValue = "에이"
//           "B" in list -> returnValue = "비"
//           "C" in list -> returnValue = "씨"
//           else -> returnValue ="모름"
//       }
        // 위와 동일한 문법, 해당 조건을 만족하는것을 찾으면 바로 break 된다.
        returnValue = when{
            "A" in list -> "에이"
            "B" in list -> "비"
            "C" in list -> "씨"
            else -> "모름"
        }

        println(returnValue)

    }


}