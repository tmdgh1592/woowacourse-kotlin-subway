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
            "1" -> stationController.run()
            "2" -> lineController.run()
            "3" -> manageSection()
            "4" -> showSubwayMap()
        }
    }

    private fun selectMainOption(): String {
        val option = repeat(inputView::selectMainOption)
        outputView.printEnter()
        return option
    }

    /**
     * 3. 구간 관 옵션
     * */

    private fun manageSection() {
        when (selectSectionManagementOption()) {
            "1" -> addSection()
            "2" -> removeSection()
        }

    }

    private fun selectSectionManagementOption(): String {
        val option = repeat(inputView::selectSectionManagementOption)
        outputView.printEnter()
        return option
    }

    private fun addSection() {
        val line = inputLine()
        val station = inputStation()
        val sequence = inputSequence()

        try {
            lineService.addSection(sequence, line, station)
            printAddingSectionResult()
        } catch (error: IllegalArgumentException) {
            outputView.printError(error)
        }
    }

    private fun inputLine(): String {
        val line = inputView.inputLine()
        outputView.printEnter()
        return line
    }

    private fun inputStation(): String {
        val station = inputView.inputStation()
        outputView.printEnter()
        return station
    }

    private fun inputSequence(): Int {
        val sequence = repeat(inputView::inputSequence)
        outputView.printEnter()
        return sequence
    }

    private fun printAddingSectionResult() {
        outputView.printMessage(SUCCESS_TO_ADD_SECTION_MESSAGE)
    }

    private fun removeSection() {
        val removingSectionLine = inputRemovingSectionLine()
        val removingSectionStation = inputRemovingSectionStation()

        val removeSuccess = lineService.removeSection(removingSectionLine, removingSectionStation)
        printRemovingSectionResult(removeSuccess)
    }

    private fun inputRemovingSectionLine(): String {
        val removingSectionLine = repeat(inputView::inputRemovingSectionLine)
        outputView.printEnter()
        return removingSectionLine
    }

    private fun inputRemovingSectionStation(): String {
        val removingSectionStation = repeat(inputView::inputRemovingSectionStation)
        outputView.printEnter()
        return removingSectionStation
    }

    private fun printRemovingSectionResult(removeSuccess: Boolean) {
        if (removeSuccess) {
            outputView.printMessage(SUCCESS_TO_REMOVE_SECTION_MESSAGE)
        } else {
            outputView.printMessage(INVALID_SECTION_EXCEPTION_MESSAGE)
        }
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
        private const val SUCCESS_TO_ADD_SECTION_MESSAGE = "[INFO] 구간이 등록되었습니다."
        private const val SUCCESS_TO_REMOVE_SECTION_MESSAGE = "[INFO] 구간이 삭제되었습니다."
        private const val INVALID_SECTION_EXCEPTION_MESSAGE = "[ERROR] 존재하지 않는 노선 또는 역입니다."
    }
}