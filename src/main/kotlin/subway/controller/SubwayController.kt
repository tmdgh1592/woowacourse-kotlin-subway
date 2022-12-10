package subway.controller

import subway.presentation.InputView
import subway.presentation.OutputView

class SubwayController(
    inputView: InputView, outputView: OutputView
) : Controller(inputView, outputView) {

    override fun run() {
        val mainOption = selectMainOption()
    }

    private fun selectMainOption(): String {
        return repeat(inputView::selectMainOption)
    }
}