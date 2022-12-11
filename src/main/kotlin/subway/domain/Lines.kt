package subway.domain

class Lines(private val lines: List<Line>) {
    fun makeSubwayMap(): Map<String, List<String>> = hashMapOf<String, List<String>>().apply {
        lines.forEach { line ->
            val stationsNames = line.stations().map { it.getName() }
            this[line.getName()] = stationsNames
        }
    }

    fun getLinesAsText(): List<String> = lines.map { it.toString() }
}