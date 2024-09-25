import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    simpleFlow().collect { value ->
        println(value)
        println("Collecting From simpleFlow")
    }
}


fun simpleFlow(): Flow<Int> = flow {
    for (i in 1..5) {
        emit(i)
    }
}
