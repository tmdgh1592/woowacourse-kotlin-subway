package subway.controller

import subway.presentation.InputView
import subway.presentation.OutputView
import subway.service.LineService
import subway.service.StationService

class SubwayController(
    inputView: InputView, outputView: OutputView
) : Controller(inputView, outputView) {
    private val stationService = StationService()
    private val lineService = LineService()

    private val stationController by lazy { StationController(inputView, outputView, stationService) }
    private val lineController by lazy { LineController(inputView, outputView, stationService, lineService) }
    private val sectionController by lazy { SectionController(inputView, outputView, lineService) }

    init {
        lineService.init()
    }

    override fun run() {
        do {
            val mainOption = selectMainOption()
            performMainOption(mainOption)
        } while (mainOption != QUIT_OPTION)
    }

    private fun performMainOption(option: String) {
        when (option) {
            "1" -> stationController.run()
            "2" -> lineController.run()
            "3" -> sectionController.run()
            "4" -> showSubwayMap()
        }
    }

    private fun selectMainOption(): String {
        val option = repeat(inputView::selectMainOption)
        outputView.printEnter()
        return option
    }

    private fun showSubwayMap() {
        val subwayMap = lineService.getSubwayMap()
        outputView.printSubwayMap(subwayMap)
    }

    companion object {
        private const val QUIT_OPTION = "Q"
    }
}