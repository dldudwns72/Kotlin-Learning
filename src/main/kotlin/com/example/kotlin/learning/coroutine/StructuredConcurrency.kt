package com.example.kotlin.learning.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {

    /**
     * GlobalScope 를 설정하지 않고 runBlocking 안에서 coroutine 를 사용할 수 있게 끔 한다.
     * 각 GlobalScope 사용 시 각 launch 마다 반환되는 job의 join 을 계속 해주어 main 스레드가 멈추지 않게 해야한다.
     * Top level coroutine 을 만들지 말고 , runBlocking 하위 차일드 coroutine을 만들면 상위 코루틴이 하위 코루틴을 기다려 주기 때문에 이런 구조적 코루틴이 좋다
     */
    this.launch { // 실행순서 2
        delay(1000L)
        print("HELLO, ")
        myWorld()
    }

    launch { // 실행순서 3
        delay(1000L)
        print("WORLD")
    }

    println("MAIN HELLO") // 실행순서 1

}

suspend fun myWorld() { // 실행순서 4 : 실행순서 2가 진행되고 myWorld()가 실행될 때 delay에서 멈추고 다음 coroutine 이 실행되기 때수
    delay(1000L)
    println("MY WORLD")
}