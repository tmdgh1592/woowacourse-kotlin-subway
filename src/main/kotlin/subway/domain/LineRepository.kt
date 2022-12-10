package subway.domain

import java.util.*

object LineRepository {
    private val lines: MutableList<Line> = arrayListOf(
        Line("2호선"), Line("3호선"), Line("신분당선")
    )

    fun lines(): List<Line> = Collections.unmodifiableList(lines)

    fun addLine(line: Line) {
        lines.add(line)
    }

    fun deleteLineByName(name: String): Boolean {
        return lines.removeIf { line ->
            line.getName() == name
        }
    }
}