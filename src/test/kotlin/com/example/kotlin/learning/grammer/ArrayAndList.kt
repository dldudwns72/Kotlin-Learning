package com.example.kotlin.learning.grammer

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ArrayAndList {

    @Test
    fun array(){
        val array1 = arrayOf(1,2,3,"Array",true) // 여러가지 타입이 들어갈 수 있다, 자동으로 타입 추론됨
        val array = arrayOf(1,2,34,5,6)
        assertThat(array.get(0)).isEqualTo(1)
        assertThat(array[1]).isEqualTo(2)

        // 값 변경 가능, 하지만 array1 배열과 같이 타입이 지정되지 않고 여러가지 타입이 배열 안에 담겨 있다면 내용은 변경 불가능 하다.
        array[2] = 5 // as Nothing 은 무엇인가..
        assertThat(array.get(2)).isEqualTo(5)
    }

    @Test
    fun list(){
        //1. List : 값을 변경할 수 없는 리스트, 읽기 전용
        val list = listOf(1,2,3,"a",false) // 여러가지 타입이 들어갈 수 있다, 자동으로 타입 추론됨

        assertThat(list.get(0)).isEqualTo(1)
        assertThat(list.get(1)).isEqualTo(2)
        // list[2] = 5 // 불가
        assertThat(list.get(2)).isEqualTo(3)
    }

    @Test
    @DisplayName("요소들을 변경 가능한 리스트")
    fun mutableList(){
        //2. mutableList : 값을 변경할 수 있는 리스트,
        // arrayList 값의 참조값 자체가 바뀌지 않으므로 val 으로 선언해도 된다.
        val arrayList = arrayListOf<Int>() // 동일한 타입만 들어갈 수 있다.
        arrayList.add(10)
        arrayList.add(20)
        arrayList.add(30)
        assertThat(arrayList.get(0)).isEqualTo(10)
        assertThat(arrayList[1]).isEqualTo(20)

        arrayList[2] = 40
        assertThat(arrayList[2]).isEqualTo(40)

        // removeAt : 특정 인덱스 데이터 삭제
        arrayList.removeAt(1);

        // remove는 list에서 해당 요소를 찾아 해당 요소가 있다면 제거하고 true 를 반환
        val isRemove = arrayList.remove(20)
        assertThat(isRemove).isEqualTo(false)

    }
}