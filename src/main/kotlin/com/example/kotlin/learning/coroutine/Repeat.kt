package com.example.kotlin.learning.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main() = runBlocking {
    repeat(100_000){ i ->
        launch {
            delay(1000L)
            println("i : $i")
        }

// 스레드와 비교해 보았을 때 coroutine 이 상당히 빠르다.
//        thread {
//            Thread.sleep(1000L)
//            print(".")
//        }
    }
}