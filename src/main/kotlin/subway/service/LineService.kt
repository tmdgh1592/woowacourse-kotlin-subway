package subway.service

import subway.repository.LineRepository

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
}