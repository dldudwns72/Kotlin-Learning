package com.example.kotlin.learning.coroutine

import kotlinx.coroutines.*


fun main() = runBlocking {

    val job =  GlobalScope.launch { // launch builder 는 job 을 반환한다.
        delay(1000L)
        print("WORLD")
    }

    print("HELLO, ")
    job.join() // 위에 선언한 job이 완료될 때까지 join 에서 기다린다, 그래서 delay를 선언하지 않고도 위의 coroutine의 실행이 끝나는걸 기다릴 수 있다.
}