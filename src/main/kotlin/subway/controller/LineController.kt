package subway.controller

import subway.presentation.InputView
import subway.presentation.OutputView
import subway.service.LineService
import subway.service.StationService

class LineController(
    inputView: InputView,
    outputView: OutputView,
    private val stationService: StationService,
    private val lineService: LineService
) : Controller(inputView, outputView) {

    override fun run() {
        manageLine()
    }

    private fun manageLine() {
        when (selectLineManagementOption()) {
            "1" -> addLine()
            "2" -> removeLine()
            "3" -> showLines()
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

    private fun printAddingLineResult() {
        outputView.printMessage(SUCCESS_TO_ADD_LINE_MESSAGE)
    }

    private fun showLines() {
        val lines = lineService.getLines()
        outputView.printLines(lines.getLinesAsText())
    }

    companion object {
        private const val SUCCESS_TO_ADD_LINE_MESSAGE = "[INFO] 지하철 노선이 등록되었습니다.\n"
        private const val SUCCESS_TO_REMOVE_LINE_MESSAGE = "[INFO] 지하철 노선이 삭제되었습니다.\n"

        private const val INVALID_DOWN_BOUND_STATION_EXCEPTION_MESSAGE = "[ERROR] 상행선과 하행선이 동일할 수 없습니다."
        private const val INVALID_LINE_EXCEPTION_MESSAGE = "[ERROR] 존재하지 않는 노선입니다.\n"
    }
}