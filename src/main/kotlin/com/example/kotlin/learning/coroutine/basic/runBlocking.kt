package com.example.kotlin.learning.coroutine

import kotlinx.coroutines.*

/**
 * 1. main 스레드 실행
 * 2. runBlocking 을 통한 main thread blocking
 * 3. GlobalScope.launch coroutine 실행
 * 4. 2초동안 blocking 되어 있는 main thread 안에 scope 안에 있는 delay 1초 대기
 * 5. coroutine 안에 있는 로직 실행
 */
fun main(){
    // launch는 자신이 호출하는 스레드를 blocking 하지 않는다.
    GlobalScope.launch {
        delay(1000L)
        print("WORLD")
    }

    print("HELLO, ")

    // delay는 suspend fun 으로써 일시중단, Thread.sleep() 는 스레드 blocking
    // runBlocking : coroutine builder, blocking 해주는 coroutine
    runBlocking {
        delay(2000L)   // Thread.sleep(2000L) 과 같은 역할
    }

}