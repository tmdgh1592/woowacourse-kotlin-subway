package subway.service

import subway.domain.Line
import subway.repository.LineRepository
import subway.repository.StationRepository

class LineService {
    fun init() {
        addStation(1, "2호선", "교대역")
        addStation(2, "2호선", "강남역")
        addStation(3, "2호선", "역삼역")

        addStation(1, "3호선", "교대역")
        addStation(2, "3호선", "남부터미널역")
        addStation(3, "3호선", "양재역")
        addStation(4, "3호선", "매봉역")

        addStation(1, "신분당선", "강남역")
        addStation(2, "신분당선", "양재역")
        addStation(3, "신분당선", "양재시민의숲역")
    }

    fun addStation(sequence: Int, lineName: String, stationName: String) {
        val line = LineRepository.getLine(lineName)
        line.addStation(sequence, stationName)
    }

    fun addLine(lineName: String, upBound: String, downBound: String) {
        val line = Line(lineName).apply {
            addStation(1, upBound)
            addStation(2, downBound)
        }
        LineRepository.addLine(line)
    }

    fun getSubwayMap(): Map<String, List<String>> {
        val lines = getAllLines()
        val subwayMap = hashMapOf<String, List<String>>()

        lines.forEach { line ->
            val stationsNames = line.stations().map { it.getName() }
            subwayMap[line.getName()] = stationsNames
        }
        return subwayMap
    }

    private fun getAllLines(): List<Line> {
        return LineRepository.lines()
    }
}