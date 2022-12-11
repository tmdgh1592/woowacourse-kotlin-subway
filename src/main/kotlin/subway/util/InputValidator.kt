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

    fun validateLineManagementOption(option: String): String {
        if (option !in listOf("1", "2", "3", "B")) {
            throw IllegalArgumentException(INVALID_OPTION_EXCEPTION_MESSAGE)
        }
        return option
    }

    fun validateLength(text: String, length: Int = 2): String {
        if (text.length < length) {
            throw IllegalArgumentException(INVALID_LENGTH_EXCEPTION_MESSAGE.format(length))
        }
        return text
    }

    companion object {
        private const val ERROR_PREFIX = "[ERROR]"
        private const val INVALID_OPTION_EXCEPTION_MESSAGE = "$ERROR_PREFIX 선택할 수 없는 기능입니다."
        private const val INVALID_LENGTH_EXCEPTION_MESSAGE = "$ERROR_PREFIX 길이가 %d 이상이어야 합니다."
    }
}