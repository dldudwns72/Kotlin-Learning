package com.example.kotlin.learning.grammer

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class VariableTest {

    @Test
    @DisplayName("상수값 val, 재할당 불가")
    fun valTest(){
        val value1 : Int = 9;
        // value1 = 10; // 에러 발생, val로 선언된 변수는 수정될 수 없다.
    }

    @Test
    @DisplayName("변수 선언 var")
    fun varTest(){
        var value1 : Int = 9;
        value1 = 10;
        assertThat(value1).isEqualTo(10);

        var value2 = 15 // Kotiln은 타입을 추론하여 타입을 선언해주지 않아도 된다.
        assertThat(value2).isEqualTo(15)

        var stringValue = "name"; // var stringValue : String = "name"
        assertThat(stringValue).isEqualTo("name");
    }
}