import kotlinx.coroutines.*

suspend fun main() {
    getUserFirstName(listOf("1", "2", "3", "4", "5")).forEach {
        println(it)
    }

}


suspend fun getUserFirstName(userIds: List<String>): List<String> {
    val firstNames = mutableListOf<Deferred<String>>()
    coroutineScope {
        for (id in userIds) {
            val firstName = async {
                getFirstName(id)
            }

            firstNames.add(firstName)
        }
    }

    return firstNames.awaitAll()
}


suspend fun getFirstName(userId: String): String {
    delay(1000)
    return "John"
}