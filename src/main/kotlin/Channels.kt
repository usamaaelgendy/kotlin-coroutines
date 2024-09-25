import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

fun main() {
    runBlocking {
        val channel = Channel<Int>()

        launch {
            for (x in 1..5) {
                println("Sending: $x")
                channel.send(x)
                delay(1000)
            }
            channel.close()
        }

        launch {
            for (y in channel) {
                println("Received: $y")
                delay(2000)
            }
        }
    }
}