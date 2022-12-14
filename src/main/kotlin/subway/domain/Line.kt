package subway.domain

class Line(private val name: String) {
    private val stations = arrayListOf<Station>()

    fun getName() = name

    fun contains(stationName: String): Boolean {
        stations.find { it.getName() == stationName } ?: return false
        return true
    }

    fun stations() = stations.toList()

    fun addStation(sequence: Int, stationName: String) {
        validateDuplication(stationName)
        validateSequence(sequence - 1)

        if (sequence == stations.size) {
            stations.add(Station(stationName))
            return
        }
        stations.add(sequence - 1, Station(stationName))
    }

    fun removeStation(stationName: String): Boolean =
        stations.removeIf { it.getName() == stationName }

    private fun validateDuplication(newStationName: String) {
        stations.forEach { station ->
            val stationName = station.getName()
            if (stationName == newStationName) {
                throw IllegalArgumentException(DUPLICATED_STATION_EXCEPTION_MESSAGE)
            }
        }
    }

    private fun validateSequence(sequence: Int) {
        if (sequence > stations.size) {
            throw IllegalArgumentException(INVALID_SEQUENCE_EXCEPTION_MESSAGE)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other is Line) {
            return this.name == other.name
        }
        return false
    }

    override fun toString(): String = name

    companion object {
        private const val ERROR_PREFIX = "[ERROR]"
        private const val DUPLICATED_STATION_EXCEPTION_MESSAGE = "$ERROR_PREFIX 노선에 이미 추가하고자 하는 역이름이 존재합니다."
        private const val INVALID_SEQUENCE_EXCEPTION_MESSAGE = "$ERROR_PREFIX 해당 순서에 역을 추가하실 수 없습니다."
    }
}