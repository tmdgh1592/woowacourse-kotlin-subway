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
        when (option) {
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
        when (selectSubwayManagementOption()) {
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
        printAddingStationResult()
    }

    private fun removeStation() {
        val removingSubway = inputView.inputRemovingSubway()
        stationService.removeStation(removingSubway)
        printRemovingStationResult()
    }

    private fun showStations() {
        val stations = stationService.getStations()
        outputView.printStations(stations.getStationsNames())
    }

    private fun printAddingStationResult() {
        outputView.printMessage(SUCCESS_TO_ADD_STATION_MESSAGE)
    }

    private fun printRemovingStationResult() {
        outputView.printMessage(SUCCESS_TO_REMOVE_STATION_MESSAGE)
    }

    /**
     * 2. 노선 관리 옵션
     * */

    private fun manageLine() {
        when (selectLineManagementOption()) {
            "1" -> addLine()
            "2" -> removeLine()
        }
    }

    private fun selectLineManagementOption(): String {
        val option = repeat(inputView::selectLineManagementOption)
        outputView.printEnter()
        return option
    }

    private fun addLine() {
        val lineName = inputAddingLine()
        val upBoundStation = repeat(this::inputUpBoundStation)
        val downBoundStation = repeat(this::inputDownBoundStation)
        if (isSameBoundStation(upBoundStation, downBoundStation)) {
            return
        }

        lineService.addLine(lineName, upBoundStation, downBoundStation)
        printAddingLineResult()
    }

    private fun inputAddingLine(): String {
        val lineName = repeat(inputView::inputAddingLine)
        outputView.printEnter()
        return lineName
    }

    private fun inputUpBoundStation(): String {
        val upBoundStation = repeat(inputView::inputUpBoundStation)
        validateExistingStation(upBoundStation)
        outputView.printEnter()
        return upBoundStation
    }

    private fun inputDownBoundStation(): String {
        val downBoundStation = repeat(inputView::inputDownBoundStation)
        validateExistingStation(downBoundStation)
        outputView.printEnter()
        return downBoundStation
    }

    private fun removeLine() {
        val removingLine = inputRemovingLine()
        val removeResult = lineService.removeLine(removingLine)
        printRemovingLineResult(removeResult)
    }

    private fun printRemovingLineResult(result: Boolean) {
        if (result.not()) {
            outputView.printMessage(INVALID_LINE_EXCEPTION_MESSAGE)
            return
        }
        outputView.printMessage(SUCCESS_TO_REMOVE_LINE_MESSAGE)
    }

    private fun inputRemovingLine(): String {
        val removingLine = repeat(inputView::inputRemovingLine)
        outputView.printEnter()
        return removingLine
    }

    private fun validateExistingStation(downBoundStation: String) {
        stationService.isExistStation(downBoundStation)
    }

    private fun isSameBoundStation(upBoundStation: String, downBoundStation: String): Boolean {
        if (upBoundStation == downBoundStation) {
            try {
                throw IllegalArgumentException(INVALID_DOWN_BOUND_STATION_EXCEPTION_MESSAGE)
            } catch (error: IllegalArgumentException) {
                outputView.printError(error)
                return true
            }
        }
        return false
    }

    private fun printAddingLineResult() {
        outputView.printMessage(SUCCESS_TO_ADD_LINE_MESSAGE)
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
        private const val SUCCESS_TO_ADD_LINE_MESSAGE = "[INFO] 지하철 노선이 등록되었습니다.\n"
        private const val SUCCESS_TO_REMOVE_LINE_MESSAGE = "[INFO] 지하철 노선이 삭제되었습니다.\n"

        private const val INVALID_DOWN_BOUND_STATION_EXCEPTION_MESSAGE = "[ERROR] 상행선과 하행선이 동일할 수 없습니다."
        private const val INVALID_LINE_EXCEPTION_MESSAGE = "[ERROR] 존재하지 않는 노선입니다.\n"
    }
}