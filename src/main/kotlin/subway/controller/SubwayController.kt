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
            "2" -> manageLine()
            "4" -> showSubwayMap()
        }
    }

    private fun selectMainOption(): String {
        val option = repeat(inputView::selectMainOption)
        outputView.printEnter()
        return option
    }


    /**
     * 1. 역 관리 옵션
     * */

    private fun manageSubway() {
        when(selectSubwayManagementOption()) {
            "1" -> repeat(this::addStation)
            "2" -> repeat(this::removeStation)
            "3" -> showStations()
        }
    }

    private fun selectSubwayManagementOption(): String {
        val option = repeat(inputView::selectSubwayManagementOption)
        outputView.printEnter()
        return option
    }

    private fun addStation() {
        val addingSubway = inputView.inputAddingSubway()
        stationService.addStation(addingSubway)
        printAddingResult()
    }

    private fun removeStation() {
        val removingSubway = inputView.inputRemovingSubway()
        stationService.removeStation(removingSubway)
        printRemovingResult()
    }

    private fun showStations() {
        val stations = stationService.getStations()
        outputView.printStations(stations.getStationsNames())
    }

    private fun printAddingResult() {
        outputView.printMessage(SUCCESS_TO_ADD_STATION_MESSAGE)
    }

    private fun printRemovingResult() {
        outputView.printMessage(SUCCESS_TO_REMOVE_STATION_MESSAGE)
    }

    /**
     * 2. 노선 관리 옵션
     * */

    private fun manageLine() {
        when(selectLineManagementOption()) {
            "1" -> addLine()
        }
    }

    private fun selectLineManagementOption(): String {
        val option = repeat(inputView::selectLineManagementOption)
        outputView.printEnter()
        return option
    }

    private fun addLine() {
        val lineName = inputAddingLine()
        val upBoundStation = inputUpBoundStation()
    }

    private fun inputAddingLine(): String {
        val option = repeat(inputView::inputAddingLine)
        outputView.printEnter()
        return option
    }

    private fun inputUpBoundStation(): String {
        val upBoundStation = repeat(inputView::inputUpBoundStation)
        outputView.printEnter()
        return upBoundStation
    }

    /**
     * 4. 지하철 노선도 출력
     * */

    private fun showSubwayMap() {
        val subwayMap = lineService.getSubwayMap()
        outputView.printSubwayMap(subwayMap)
    }

    companion object {
        private const val QUIT_OPTION = "Q"
        private const val SUCCESS_TO_REMOVE_STATION_MESSAGE = "\n[INFO] 지하철 역이 삭제되었습니다.\n"
        private const val SUCCESS_TO_ADD_STATION_MESSAGE = "\n[INFO] 지하철 역이 등록되었습니다.\n"
    }
}