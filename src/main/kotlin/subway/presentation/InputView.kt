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
            "## ?????? ??????\n" + "1. ??? ??????\n" + "2. ?????? ??????\n" + "3. ?????? ??????\n" + "4. ????????? ????????? ??????\n" + "Q. ??????\n\n" + "## ????????? ????????? ???????????????."
        private const val SUBWAY_MANAGEMENT_SELECT_MESSAGE =
            "## ??? ?????? ??????\n" + "1. ??? ??????\n" + "2. ??? ??????\n" + "3. ??? ??????\n" + "B. ????????????\n\n" + "## ????????? ????????? ???????????????."
        private const val LINE_MANAGEMENT_SELECT_MESSAGE =
            "## ?????? ?????? ??????\n" + "1. ?????? ??????\n" + "2. ?????? ??????\n" + "3. ?????? ??????\n" + "B. ????????????\n" + "\n" + "## ????????? ????????? ???????????????."
        private const val SECTION_MANAGEMENT_SELECT_MESSAGE =
            "## ?????? ?????? ??????\n" + "1. ?????? ??????\n" + "2. ?????? ??????\n" + "B. ????????????\n" + "\n" + "## ????????? ????????? ???????????????."

        private const val SUBWAY_ADDING_INPUT_MESSAGE = "## ????????? ??? ????????? ???????????????."
        private const val SUBWAY_DELETE_INPUT_MESSAGE = "## ????????? ??? ????????? ???????????????."

        private const val LINE_ADDING_INPUT_MESSAGE = "## ????????? ?????? ????????? ???????????????."
        private const val LINE_REMOVING_INPUT_MESSAGE = "## ????????? ?????? ????????? ???????????????."

        private const val UP_BOUND_STATION_INPUT_MESSAGE = "## ????????? ????????? ?????? ????????? ????????? ???????????????."
        private const val DOWN_BOUND_STATION_INPUT_MESSAGE = "## ????????? ????????? ?????? ????????? ????????? ???????????????."

        private const val SECTION_LINE_REMOVING_INPUT_MESSAGE = "## ????????? ????????? ????????? ???????????????."
        private const val SECTION_STATION_REMOVING_INPUT_MESSAGE = "## ????????? ????????? ?????? ???????????????."

        private const val LINE_INPUT_MESSAGE = "## ????????? ???????????????."
        private const val STATION_INPUT_MESSAGE = "## ???????????? ???????????????."
        private const val SEQUENCE_INPUT_MESSAGE = "## ????????? ???????????????."
    }
}