package subway.controller

import subway.presentation.InputView
import subway.presentation.OutputView
import java.util.function.Supplier

abstract class Controller(
    internal val inputView: InputView, internal val outputView: OutputView
) {

    /**
     * Controller 실행 호출 함수
     *
     * */
    abstract fun run()

    internal fun <T> repeat(inputReader: Supplier<T>): T = try {
        inputReader.get()
    } catch (error: IllegalArgumentException) {
        printError(error)
        repeat(inputReader)
    }

    private fun printError(error: Exception) {
        outputView.printError(error)
    }
}