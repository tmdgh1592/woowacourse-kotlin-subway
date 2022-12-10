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
            performMainOption(mainOption)
        } while (mainOption != QUIT_OPTION)
    }

    /**
     * 메인 옵션
     * */

    private fun performMainOption(option: String) {
        when(option) {
            "1" -> manageSubway()
        }
    }

    private fun selectMainOption(): String {
        val option = repeat(inputView::selectMainOption)
        outputView.printEnter()
        return option
    }


    /**
     * 역 관리 옵션
     * */

    private fun manageSubway() {
        when(selectSubwayManagementOption()) {
            "2" -> repeat(this::removeStation)
            "3" -> showStations()
        }
    }

    private fun selectSubwayManagementOption(): String {
        val option = repeat(inputView::selectSubwayManagementOption)
        outputView.printEnter()
        return option
    }

    private fun showStations() {
        val stations = stationService.getStations()
        outputView.printStations(stations.getStationsNames())
    }

    private fun removeStation() {
        val removingSubway = inputView.inputRemovingSubway()
        stationService.removeStation(removingSubway)
    }

    companion object {
        private const val QUIT_OPTION = "Q"
    }
}