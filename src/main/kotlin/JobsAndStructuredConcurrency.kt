import kotlinx.coroutines.*

fun main() {

    val parentJob = Job()
    val jop = GlobalScope.launch(parentJob) {
        val child1 = launch {
            getUserFromNetwork()

        }
        val child2 = launch {
            getUserFromDatabase()
        }

        joinAll(child1, child2)

        launch { delay(1000)
            println("Start launch ")
        }

        println("End After delay ")

    }
//    jop.cancel()

    Thread.sleep(5000)
}


suspend fun getUserFromNetwork(): String {
    println("Start getUserFromNetwork")
    delay(2000)
    println("End getUserFromNetwork")
    return "Usama From Api"
}

suspend fun getUserFromDatabase(): String {
    println("Start getUserFromDatabase")

    delay(2000)
    println("End getUserFromDatabase")
    return "Usama From Database"
}