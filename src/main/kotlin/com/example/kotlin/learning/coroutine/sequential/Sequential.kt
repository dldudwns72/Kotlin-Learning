package com.example.kotlin.learning.coroutine.sequential

import kotlinx.coroutines.*
import kotlin.system.*

/**
 * 기존 작업 같았을 경우에는 One() 메서드가 실행되는 도중에 Two() 메서드를 진행하여서 비동기 적으로 진행될 텐데
 * coroutine 내부에서 One(), Two() 함수가 중단 함수 (suspend)로 선언 되었기 때문에 동기적으로 순차적으로 실행이 된다.
 * async 는 JOB을 상속받은 Deffered 객체를 반환한다.
 */
fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        // 코루틴 내 블럭에서 서로 연관되지않고 독립적인 로직이 있다면 해당 기능들은 비동기 적으로 작동해도 된다
        // 비동기적으로 작동하기 위해서는 async & await 키워드를 사용하여 해당 로직들은 비동기로 할 수 있게 끔 처리한다.
        val one = async{ doSomethingUsefulOne() }
        val two = async{ doSomethingUsefulTwo() }

        // async 로 선언된 함수를 await로 실행된 부분에서 비동기로 실행된다.
        println("The answer is ${one.await() + two.await()}") // 42
    }

    val asyncTime = measureTimeMillis {
        val one = async (start = CoroutineStart.LAZY) {doSomethingUsefulOne() }
        val two = async (start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }

        // start를 선언해주지 않으면 해당 async로 만들어진 job이 비동기적으로 실행되지않아 동기적으로 작동하게 된다.
        one.start()
        two.start()
        println("The Async answer is ${one.await() + two.await()}") // 42
    }

    println("Completed time in $time ms") // delay 시간 2000 + a
    println("Completed asyncTime in $asyncTime ms") // delay 시간 2000 + a
}

suspend fun doSomethingUsefulOne(): Int {
    delay(1000L) // pretend we are doing something useful here
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L) // pretend we are doing something useful here, too
    return 29
}