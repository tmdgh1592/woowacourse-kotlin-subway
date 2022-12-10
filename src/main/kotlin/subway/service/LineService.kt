package subway.service

import subway.repository.LineRepository

class LineService {

    fun addStationOf(sequence: Int, lineName: String, stationName: String) {
        val line = LineRepository.getLine(lineName)
        line.addStation(sequence, stationName)
    }
}