package subway.controller

import subway.presentation.InputView
import subway.presentation.OutputView

class SubwayController(
    inputView: InputView, outputView: OutputView
) : Controller(inputView, outputView) {

    override fun run() {
        do {
            val mainOption = selectMainOption()
        } while (mainOption != QUIT_OPTION)

    }

    private fun selectMainOption(): String {
        return repeat(inputView::selectMainOption)
    }

    companion object {
        private const val QUIT_OPTION = "Q"
    }
}