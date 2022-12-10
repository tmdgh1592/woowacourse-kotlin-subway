package subway.repository

import subway.domain.Station
import java.util.*

object StationRepository {
    private val stations: MutableList<Station> = arrayListOf(
        Station("교대역"), Station("강남역"), Station("역삼역"),
        Station("남부터미널역"), Station("양재역"), Station("양재시민의숲역"), Station("매봉역")
    )

    fun stations(): List<Station> =
        Collections.unmodifiableList(stations)

    fun addStation(station: Station) {
        stations.add(station)
    }

    fun deleteStation(name: String?): Boolean {
        return stations.removeIf { station: Station ->
            station.getName() == name
        }
    }
}