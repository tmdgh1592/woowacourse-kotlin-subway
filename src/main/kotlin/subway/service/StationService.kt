package subway.service

import subway.domain.Stations
import subway.repository.LineRepository
import subway.repository.StationRepository

class StationService {
    fun getStations() = Stations(StationRepository.stations())

    fun removeStation(station: String) {
        val isContainStation = LineRepository.isContainStation(station)
        if (isContainStation) {
            throw IllegalArgumentException(UNABLE_TO_REMOVE_STATION_EXCEPTION_MESSAGE)
        }

        val deleteResult = StationRepository.deleteStation(station)
        if (deleteResult.not()) {
            throw IllegalArgumentException(NOT_EXIST_STATION_EXCEPTION_MESSAGE)
        }
    }

    companion object {
        private const val ERROR_PREFIX = "[ERROR]"
        private const val UNABLE_TO_REMOVE_STATION_EXCEPTION_MESSAGE = "$ERROR_PREFIX 노선에 추가된 역은 제거할 수 없습니다."
        private const val NOT_EXIST_STATION_EXCEPTION_MESSAGE = "$ERROR_PREFIX 존재하지 않는 역이름 입니다."
    }
}