package subway.presentation

class OutputView {
    fun printStations(stations: List<String>) {
        printMessage("## 역 목록")
        printMessage(stations.joinToString("\n") {
            INFO_PREFIX + it
        })
        printEnter()
    }

    fun printMessage(message: String) = println(message)

    fun printEnter() = println()

    fun printError(error: Exception) {
        printMessage(error.message!!)
        printEnter()
    }

    companion object {
        private const val INFO_PREFIX = "[INFO] "
    }
}