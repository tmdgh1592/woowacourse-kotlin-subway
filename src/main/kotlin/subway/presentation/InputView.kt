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


    companion object {
        const val MAIN_OPTION_SELECT_MESSAGE =
            "## 메인 화면\n" + "1. 역 관리\n" + "2. 노선 관리\n" + "3. 구간 관리\n" + "4. 지하철 노선도 출력\n" + "Q. 종료\n\n" + "## 원하는 기능을 선택하세요."
        const val SUBWAY_MANAGEMENT_SELECT_MESSAGE =
            "## 역 관리 화면\n" + "1. 역 등록\n" + "2. 역 삭제\n" + "3. 역 조회\n" + "B. 돌아가기\n\n" + "## 원하는 기능을 선택하세요."
    }
}