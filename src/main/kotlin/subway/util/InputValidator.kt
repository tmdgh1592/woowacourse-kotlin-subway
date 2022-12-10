package subway.util

class InputValidator {
    fun validateMainOption(option: String): String {
        if (option !in listOf("1", "2", "3", "4", "Q")) {
            throw IllegalArgumentException(INVALID_MAIN_OPTION_EXCEPTION_MESSAGE)
        }
        return option
    }

    companion object {
        private const val ERROR_PREFIX = "[ERROR]"
        const val INVALID_MAIN_OPTION_EXCEPTION_MESSAGE = "$ERROR_PREFIX 존재하지 않는 옵션입니다."
    }
}