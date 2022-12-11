package subway.service

import subway.domain.Line
import subway.repository.LineRepository

class LineService {
    fun init() {
        addSection(1, "2호선", "교대역")
        addSection(2, "2호선", "강남역")
        addSection(3, "2호선", "역삼역")

        addSection(1, "3호선", "교대역")
        addSection(2, "3호선", "남부터미널역")
        addSection(3, "3호선", "양재역")
        addSection(4, "3호선", "매봉역")

        addSection(1, "신분당선", "강남역")
        addSection(2, "신분당선", "양재역")
        addSection(3, "신분당선", "양재시민의숲역")
    }

    fun addSection(sequence: Int, lineName: String, stationName: String) {
        val line = LineRepository.getLine(lineName)
        line.addStation(sequence, stationName)
    }

    fun removeSection(lineName: String, stationName: String): Boolean {
        val line = LineRepository.getLine(lineName)
        return line.removeStation(stationName)
    }

    fun addLine(lineName: String, upBound: String, downBound: String) {
        val line = Line(lineName).apply {
            addStation(1, upBound)
            addStation(2, downBound)
        }
        LineRepository.addLine(line)
    }

    fun removeLine(lineName: String) = LineRepository.deleteLineByName(lineName)

    fun getSubwayMap(): Map<String, List<String>> {
        val lines = getAllLines()
        val subwayMap = hashMapOf<String, List<String>>()

        lines.forEach { line ->
            val stationsNames = line.stations().map { it.getName() }
            subwayMap[line.getName()] = stationsNames
        }
        return subwayMap
    }

    fun getAllLines(): List<Line> = LineRepository.lines()
}