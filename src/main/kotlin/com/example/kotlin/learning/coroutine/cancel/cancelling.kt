package com.example.kotlin.learning.coroutine.cancel

import kotlinx.coroutines.*
import java.lang.Exception
import java.lang.System.currentTimeMillis

fun main() = runBlocking {
    val startTime = currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        // 코루틴 중단 시 해당 내용은 Exception 처리 되어 중단되었는지 확인할 수 있다.
        try{
            while (i < 5) {
            if (currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++} ...")
                    yield() // 중단 함수를 선언해주지 않는다면 cancel 할 수 없다.
                    nextPrintTime += 500L
                }
            }
        }catch (e: Exception){
            println("EXCEPTION : ${e.message}")
        }finally {
            withContext(NonCancellable){
                println("i'm running Finally")
                yield()
                println()
            }
            println("Resource 해제 하는 부분을 finally 부분에 설정 하면 취소 될 때 실행된다.")
        }

//            println("prev isActive : $isActive")
//
//            while (isActive) {
//            if (currentTimeMillis() >= nextPrintTime) {
//                    println("job: I'm sleeping ${i++} ...")
//                    yield() // 중단 함수를 선언해주지 않는다면 cancel 할 수 없다.
//                    nextPrintTime += 500L
//                }
//            }
//            println("next isActive : $isActive")

    }

    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // job을 취소하고 끝나기를 기다리는 메서드, join + cancel
    println("main: Now I can quit.")
}