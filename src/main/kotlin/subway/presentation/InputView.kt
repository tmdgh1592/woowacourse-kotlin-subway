package subway.presentation

import camp.nextstep.edu.missionutils.Console
import subway.util.InputValidator

class InputView(
    private val inputValidator: InputValidator = InputValidator()
) {

    fun selectMainOption(): String {
        println(MAIN_OPTION_SELECT_MESSAGE)
        val option = Console.readLine()
        return inputValidator.validateMainOption(option)
    }

    fun selectSubwayManagementOption(): String {
        println(SUBWAY_MANAGEMENT_SELECT_MESSAGE)
        val option = Console.readLine()
        return inputValidator.validateSubwayManagementOption(option)
    }

    fun selectLineManagementOption(): String {
        println(LINE_MANAGEMENT_SELECT_MESSAGE)
        val option = Console.readLine()
        return inputValidator.validateLineManagementOption(option)
    }

    fun selectSectionManagementOption(): String {
        println(SECTION_MANAGEMENT_SELECT_MESSAGE)
        val option = Console.readLine()
        return inputValidator.validateSectionManagementOption(option)
    }

    fun inputAddingSubway(): String {
        println(SUBWAY_ADDING_INPUT_MESSAGE)
        return inputValidator.validateLength(Console.readLine())
    }

    fun inputRemovingSubway(): String {
        println(SUBWAY_DELETE_INPUT_MESSAGE)
        return Console.readLine()
    }

    fun inputAddingLine(): String {
        println(LINE_ADDING_INPUT_MESSAGE)
        return inputValidator.validateLength(Console.readLine())
    }

    fun inputUpBoundStation(): String {
        println(UP_BOUND_STATION_INPUT_MESSAGE)
        return Console.readLine()
    }

    fun inputDownBoundStation(): String {
        println(DOWN_BOUND_STATION_INPUT_MESSAGE)
        return Console.readLine()
    }

    fun inputRemovingLine(): String {
        println(LINE_REMOVING_INPUT_MESSAGE)
        return inputValidator.validateLength(Console.readLine())
    }

    fun inputLine(): String {
        println(LINE_INPUT_MESSAGE)
        return Console.readLine()
    }

    fun inputStation(): String {
        println(STATION_INPUT_MESSAGE)
        return Console.readLine()
    }

    fun inputSequence(): Int {
        println(SEQUENCE_INPUT_MESSAGE)
        return inputValidator.validateNumber(Console.readLine())
    }

    fun inputRemovingSectionLine(): String {
        println(SECTION_LINE_REMOVING_INPUT_MESSAGE)
        return inputValidator.validateLength(Console.readLine())
    }

    fun inputRemovingSectionStation(): String {
        println(SECTION_STATION_REMOVING_INPUT_MESSAGE)
        return inputValidator.validateLength(Console.readLine())
    }

    companion object {
        private const val MAIN_OPTION_SELECT_MESSAGE =
            "## 메인 화면\n" + "1. 역 관리\n" + "2. 노선 관리\n" + "3. 구간 관리\n" + "4. 지하철 노선도 출력\n" + "Q. 종료\n\n" + "## 원하는 기능을 선택하세요."
        private const val SUBWAY_MANAGEMENT_SELECT_MESSAGE =
            "## 역 관리 화면\n" + "1. 역 등록\n" + "2. 역 삭제\n" + "3. 역 조회\n" + "B. 돌아가기\n\n" + "## 원하는 기능을 선택하세요."
        private const val LINE_MANAGEMENT_SELECT_MESSAGE =
            "## 노선 관리 화면\n" + "1. 노선 등록\n" + "2. 노선 삭제\n" + "3. 노선 조회\n" + "B. 돌아가기\n" + "\n" + "## 원하는 기능을 선택하세요."
        private const val SECTION_MANAGEMENT_SELECT_MESSAGE =
            "## 구간 관리 화면\n" + "1. 구간 등록\n" + "2. 구간 삭제\n" + "B. 돌아가기\n" + "\n" + "## 원하는 기능을 선택하세요."

        private const val SUBWAY_ADDING_INPUT_MESSAGE = "## 등록할 역 이름을 입력하세요."
        private const val SUBWAY_DELETE_INPUT_MESSAGE = "## 삭제할 역 이름을 입력하세요."

        private const val LINE_ADDING_INPUT_MESSAGE = "## 등록할 노선 이름을 입력하세요."
        private const val LINE_REMOVING_INPUT_MESSAGE = "## 삭제할 노선 이름을 입력하세요."

        private const val UP_BOUND_STATION_INPUT_MESSAGE = "## 등록할 노선의 상행 종점역 이름을 입력하세요."
        private const val DOWN_BOUND_STATION_INPUT_MESSAGE = "## 등록할 노선의 하행 종점역 이름을 입력하세요."

        private const val SECTION_LINE_REMOVING_INPUT_MESSAGE = "## 삭제할 구간의 노선을 입력하세요."
        private const val SECTION_STATION_REMOVING_INPUT_MESSAGE = "## 삭제할 구간의 역을 입력하세요."

        private const val LINE_INPUT_MESSAGE = "## 노선을 입력하세요."
        private const val STATION_INPUT_MESSAGE = "## 역이름을 입력하세요."
        private const val SEQUENCE_INPUT_MESSAGE = "## 순서를 입력하세요."
    }
}