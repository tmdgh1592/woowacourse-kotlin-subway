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


    companion object {
        private const val MAIN_OPTION_SELECT_MESSAGE =
            "## 메인 화면\n" + "1. 역 관리\n" + "2. 노선 관리\n" + "3. 구간 관리\n" + "4. 지하철 노선도 출력\n" + "Q. 종료\n\n" + "## 원하는 기능을 선택하세요."
        private const val SUBWAY_MANAGEMENT_SELECT_MESSAGE =
            "## 역 관리 화면\n" + "1. 역 등록\n" + "2. 역 삭제\n" + "3. 역 조회\n" + "B. 돌아가기\n\n" + "## 원하는 기능을 선택하세요."
        private const val LINE_MANAGEMENT_SELECT_MESSAGE =
            "## 노선 관리 화면\n" + "1. 노선 등록\n" + "2. 노선 삭제\n" + "3. 노선 조회\n" + "B. 돌아가기\n" + "\n" + "## 원하는 기능을 선택하세요."

        private const val SUBWAY_ADDING_INPUT_MESSAGE = "## 등록할 역 이름을 입력하세요."
        private const val SUBWAY_DELETE_INPUT_MESSAGE = "## 삭제할 역 이름을 입력하세요."

        private const val LINE_ADDING_INPUT_MESSAGE = "## 등록할 노선 이름을 입력하세요."
        private const val UP_BOUND_STATION_INPUT_MESSAGE = "## 등록할 노선의 상행 종점역 이름을 입력하세요."
    }
}