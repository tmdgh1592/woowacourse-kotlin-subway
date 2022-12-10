package subway.service

import subway.domain.Stations
import subway.repository.StationRepository

class StationService {
    fun getStations() = Stations(StationRepository.stations())
}