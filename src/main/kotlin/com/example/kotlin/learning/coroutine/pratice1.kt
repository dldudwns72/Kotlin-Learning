package com.example.kotlin.learning.coroutine

import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main(){

    // launch : coroutine builder, scope 안에서 실행된다.
    GlobalScope.launch {
        delay(1000L)
        print("WORLD")
    }

    print("HELLO, ")
    Thread.sleep(2000L)

    examThread() // coroutine 과 thread를 사용하여 비교하였을 때 결과는 똑같다.

    // 결과값 : HELLO, WORLD
    // WHY? : MAIN 스레드 먼저 실행 후 coroutine이 실행되는데 main 스레드 "HELLO" 출력 후 스레드 대기상태 2초 중
}

fun examThread(){
    thread { // GlobalScope.launch 과 동가
        Thread.sleep(1000L)
        print("WORLD")
    }

    print("HELLO, ")
    Thread.sleep(2000L)
}