package subway.domain

class Station(private val name: String) {

    fun getName(): String = name

    override fun equals(other: Any?): Boolean {
        if (other is Station) {
            return this.name == other.name
        }
        return false
    }
}