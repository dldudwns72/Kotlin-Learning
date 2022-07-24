package com.example.kotlin.learning.grammer

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class StringTemplate {

    @Test
    @DisplayName("String Template ")
    fun stringTemplateTest(){
        var name = "lee"
        val nickname = "JUN"
        println("my name is ${name + nickname}")
    }

}