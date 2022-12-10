package subway.domain

class Stations(private val stations: List<Station>) {
    fun getStationsNames() = stations.map {
        it.getName()
    }
}