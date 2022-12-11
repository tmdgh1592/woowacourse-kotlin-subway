package subway.presentation

class OutputView {
    fun printStations(stations: List<String>) {
        printMessage("## 역 목록")
        printMessage(stations.joinToString("\n") {
            INFO_PREFIX + it
        })
        printEnter()
    }

    fun printSubwayMap(subwayMap: Map<String, List<String>>) {
        printMessage("## 지하철 노선도")
        subwayMap.entries.forEach { (line, stations) ->
            printMessage(INFO_PREFIX + line)
            printMessage("$INFO_PREFIX---")

            printMessage(stations.joinToString("\n") {
                INFO_PREFIX + it
            })
            printEnter()
        }
    }

    fun printLines(lines: List<String>) {
        printMessage("## 노선 목록")
        printMessage(lines.joinToString("\n") {
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