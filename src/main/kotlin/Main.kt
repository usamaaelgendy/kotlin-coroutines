package org.example

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        task3()
    }
    GlobalScope.launch {
        task2()
    }

    task1()

    Thread.sleep(100000)
}

fun task1() {
    println("task1")
    println(Thread.currentThread().name)
    println("finish task1")
}

suspend fun task2() {
    println("task2")
    println(Thread.currentThread().name)
    delay(5000)
    println("finish task2")

}

suspend fun task3() {
    println("task3")
    println(Thread.currentThread().name)
    delay(1000)
    println("finish task3")
}