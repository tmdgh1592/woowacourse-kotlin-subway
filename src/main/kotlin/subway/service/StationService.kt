package subway.service

import subway.domain.Stations
import subway.repository.LineRepository
import subway.repository.StationRepository

class StationService {
    fun getStations() = Stations(StationRepository.stations())

    fun addStation(station: String) {
        val isAlreadyExist = StationRepository.isExist(station)
        if (isAlreadyExist) {
            throw IllegalArgumentException(IS_ALREADY_EXIST_STATION_EXCEPTION_MESSAGE)
        }
        StationRepository.addStation(station)
    }

    fun removeStation(station: String) {
        val isRegisteredInLine = LineRepository.isRegisteredInLine(station)
        if (isRegisteredInLine) {
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
        private const val IS_ALREADY_EXIST_STATION_EXCEPTION_MESSAGE = "$ERROR_PREFIX 이미 등록된 역 이름입니다."
    }
}