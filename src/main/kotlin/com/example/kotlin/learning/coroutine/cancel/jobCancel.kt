package com.example.kotlin.learning.coroutine.cancel

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val job = launch {
        (1..5).forEach {
            printWithThread(it)
            delay(500)
        }
    }
    printWithThread(9999) // launch 는 호출한 scope 를 blocking 하지 않아 먼저 먼저 호출됨
    delay(1000)
    job.cancel()
}

fun printWithThread(content: Any) {
    println(Thread.currentThread().name + content.toString())
}