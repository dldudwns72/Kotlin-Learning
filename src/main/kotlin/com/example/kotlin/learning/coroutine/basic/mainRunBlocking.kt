package com.example.kotlin.learning.coroutine

import kotlinx.coroutines.*


fun main() =
    runBlocking {     // main 함수를 runBlocking 하였기 때문에 runBlocking 하위 로직들이 다 실행되기 전에는 main 함수가 종료되지 않는다.

        GlobalScope.launch {
            delay(1000L)
            print("WORLD")
        }

        print("HELLO, ")
        delay(2000L)

    }
