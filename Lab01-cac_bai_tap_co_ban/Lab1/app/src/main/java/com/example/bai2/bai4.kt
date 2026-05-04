package com.example.coroutinesample

import kotlinx.coroutines.*
import kotlin.random.Random

object DataProviderManager {
    fun getRandomValue(): Double {
        return Random.nextDouble(1.0, 100.0)
    }
}


enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

suspend fun getValue(): Double {
    delay(1000) // giả lập tác vụ lâu
    return DataProviderManager.getRandomValue()
}

suspend fun processValue(): Double {
    val value = getValue()
    return value * 2
}

fun main() {

    println("=== BÀI 4: COROUTINE ===")


    runBlocking {
        val output = getValue()
        println("runBlocking output: $output")
    }

    val job: Job = GlobalScope.launch {
        val output = getValue()
        println("GlobalScope.launch output: $output")
    }

    // Hủy coroutine
    job.cancel()


    runBlocking {
        val deferred = async {
            processValue()
        }

        println("Async result: ${deferred.await()}")
    }


    try {
        val number = 10 / 0
        println(number)
    } catch (exception: Exception) {
        println("Caught exception: ${exception.message}")
    }

    val direction = Direction.NORTH

    when (direction) {
        Direction.NORTH -> println("Going North")
        Direction.SOUTH -> println("Going South")
        Direction.WEST  -> println("Going West")
        Direction.EAST  -> println("Going East")
    }

    println("=== KẾT THÚC BÀI 4 ===")
}
