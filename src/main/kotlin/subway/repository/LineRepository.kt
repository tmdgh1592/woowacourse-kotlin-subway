package subway.repository

import subway.domain.Line
import java.lang.IllegalArgumentException
import java.util.*

object LineRepository {
    private val lines: MutableList<Line> = arrayListOf(
        Line("2호선"), Line("3호선"), Line("신분당선")
    )

    fun lines(): List<Line> = Collections.unmodifiableList(lines)

    fun addLine(line: Line) {
        lines.add(line)
    }

    fun getLine(lineName: String): Line =
        lines.find { it.getName() == lineName } ?: throw IllegalArgumentException(NOT_EXIST_LINE_EXCEPTION_MESSAGE)

    fun deleteLineByName(name: String): Boolean {
        return lines.removeIf { line ->
            line.getName() == name
        }
    }

    fun isRegisteredInLine(station: String): Boolean {
        lines.forEach { line ->
            if (line.contains(station)) {
                return true
            }
        }
        return false
    }

    private const val ERROR_PREFIX = "[ERROR]"
    private const val NOT_EXIST_LINE_EXCEPTION_MESSAGE = "$ERROR_PREFIX 존재하지 않는 노선입니다."
}