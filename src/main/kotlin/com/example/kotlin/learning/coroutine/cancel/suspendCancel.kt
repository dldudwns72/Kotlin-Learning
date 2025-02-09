package com.example.kotlin.learning.coroutine.cancel

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.cancellation.CancellationException

fun main(): Unit = runBlocking {
//    val job1 = launch {
//        println("Job 1 started")
//        delay(1000L)
//        println("Job 1")
//    }
//
//    val job2 = launch {
//        delay(1000L)
//        println("Job 2")
//    }
//
//    println("other Job")
//    delay(100L)
//    job1.cancel() // job1 코루틴이 실행되는 도중 delay 를 만나 해당 코루틴을 양보해주고


    val job3 = launch {
        println("job3")
        try {
            delay(2000L) // delay suspend 함수가 CancellationException 을 가지고 있어 중단되고 job3.cancel()를 만나서 취소 확인하고 exception 발생
        } catch (e: CancellationException) {
            println("CancellationException")
            throw e
        }
        println("job3 end")
    }

    delay(100L)
    println("취소 시작")
    job3.cancel()
    println("취소 끝")

}