package subway.controller

import camp.nextstep.edu.missionutils.Console
import subway.presentation.InputView
import subway.presentation.OutputView
import subway.service.LineService
import subway.service.StationService

class SubwayController(
    inputView: InputView, outputView: OutputView
) : Controller(inputView, outputView) {
    private val stationService = StationService()
    private val lineService = LineService()

    init {
        lineService.init()
    }

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