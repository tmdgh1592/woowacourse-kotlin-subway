package subway.util

class InputValidator {
    fun validateMainOption(option: String): String {
        if (option !in listOf("1", "2", "3", "4", "Q")) {
            throw IllegalArgumentException(INVALID_OPTION_EXCEPTION_MESSAGE)
        }
        return option
    }

    fun validateSubwayManagementOption(option: String): String {
        if (option !in listOf("1", "2", "3", "B")) {
            throw IllegalArgumentException(INVALID_OPTION_EXCEPTION_MESSAGE)
        }
        return option
    }

    companion object {
        private const val ERROR_PREFIX = "[ERROR]"
        const val INVALID_OPTION_EXCEPTION_MESSAGE = "$ERROR_PREFIX 존재하지 않는 옵션입니다."
    }
}