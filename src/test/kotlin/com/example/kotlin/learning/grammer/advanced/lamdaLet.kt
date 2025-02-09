package com.example.kotlin.learning.grammer.advanced

import org.junit.jupiter.api.Test

data class lamdaLet (
    var name: String,
    var age: Int,
    var addr: String
    )


class Main(){
    @Test
    fun letTest(){
        var testLet = lamdaLet("lee",30,"dongjak")

        var a = testLet.let { it.addr } // 람다식 안에 있는 값으로 반환한다.
        var b = testLet.run { name }

        var c: String? = null
        var d = c?.let { "cool" }
        c = "kk"
        var e = c.run { "hot" }

//        var g = testLet.apply { this.name = "apply" }
//        var f = g.also { it.name = "also" }
        var h = c?.let{"kool"}

        println("a $a")
        println("b $b")
        println("c $c")
        println("d $d")
        println("e $e")
//        println("f ${f.name}")
//        println("g ${g.name}")
        println("h $h")
    }
}


