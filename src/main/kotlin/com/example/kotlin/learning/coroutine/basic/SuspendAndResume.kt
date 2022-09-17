package com.example.kotlin.learning.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
    launch {
        repeat(5) { i ->
            delay(100L)
            println("COROUTINE A : $i")
        }
    }

    launch {
        repeat(5) { i ->
            delay(100L)
            println("COROUTINE B : $i")
        }
    }

    println("MAIN THREAD")
}