package com.example.kotlin.learning.grammer

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class NullTest {

    var name = "lee"

    @Test
    @DisplayName("컴파일 시점에 NPE 체크 ")
    fun nullCheck(){
        // 물음표(?) 를 타입 오른쪽에 선언 시 null 타입을 만들 수 있다.
        var nullName : String? = null
        nullName = "Lee"

        var nameInUpperCase = nullName?.uppercase() //toUpperCase Deprecated

        assertThat(nameInUpperCase).isEqualTo("LEE")
    }

    @Test
    @DisplayName(" ?: 연산자")
    fun elvisOperation(){
        var lastName : String? = null
        val noFullName = name + (lastName ?: " No LastName")

        assertThat(noFullName).isEqualTo("lee No LastName")

        lastName = "YJ"
        val fullName = name + (lastName?: " No LastName")
        assertThat(fullName).isEqualTo("leeYJ")
    }

    @Test
    @DisplayName("null이 아님을 나타내는 !! 연산자, 확실하게 null 이지 않을 경우 사용 (지양)")
    fun ignoreNulls(){
        assertThat(ignoreNull("kim")).isEqualTo("KIM")
        ignoreNullLet()
    }

    private fun ignoreNull(str: String?): String {
        val mNotNull: String = str!!
        return mNotNull.uppercase()
    }

    private fun ignoreNullLet() : Unit{
        val email : String? = null

        // let 내장 함수, 람다식을 변형? 알아봐야할듯
        email?.let {
            println("email is $email")
        }
    }


}