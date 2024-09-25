import kotlinx.coroutines.*

fun main() = runBlocking {
    val deferred1 = async { fetchData("Task 1") }
    val deferred2 = async { fetchData("Task 2") }

    println("Doing something else while waiting...")

    val result1 = deferred1.await()
    val result2 = deferred2.await()

    println("Results: $result1 and $result2")
}

suspend fun fetchData(taskName: String): String {
    println("$taskName started")
    delay(1000)
    return "$taskName completed"
}
