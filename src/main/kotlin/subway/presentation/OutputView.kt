package subway.presentation

class OutputView {



    fun printMessage(message: String) = println(message)

    fun printEnter() = println()

    fun printError(error: Exception) {
        printMessage(error.message!!)
        printEnter()
    }
}