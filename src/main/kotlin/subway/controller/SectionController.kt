package subway.controller

import subway.presentation.InputView
import subway.presentation.OutputView
import subway.service.LineService

class SectionController(
    inputView: InputView,
    outputView: OutputView,
    private val lineService: LineService
) : Controller(inputView, outputView) {

    override fun run() {
        manageSection()
    }

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

    companion object {
        private const val SUCCESS_TO_ADD_SECTION_MESSAGE = "[INFO] 구간이 등록되었습니다."
        private const val SUCCESS_TO_REMOVE_SECTION_MESSAGE = "[INFO] 구간이 삭제되었습니다."
        private const val INVALID_SECTION_EXCEPTION_MESSAGE = "[ERROR] 존재하지 않는 노선 또는 역입니다."
    }
}