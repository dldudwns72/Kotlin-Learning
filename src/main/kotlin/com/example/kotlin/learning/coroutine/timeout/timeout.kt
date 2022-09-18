package com.example.kotlin.learning.coroutine.timeout

import kotlinx.coroutines.*

/**
 *  withTimeout 사용 시 해당 시간이 지나면 취소 된 후 Exception  반환
 *  withTimeoutOrNull 사용 시 해당 시간이 지나면 Exception 이 아닌 null 반환
 */
fun main() = runBlocking {
    val result = withTimeoutOrNull(1300L){
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
    }
    println("result $result")
//    withTimeout(1300L) {
//        repeat(1000) { i ->
//            println("I'm sleeping $i ...")
//            delay(500L)
//        }
//    }
}