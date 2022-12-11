package subway.controller

import subway.presentation.InputView
import subway.presentation.OutputView
import subway.service.StationService

class StationController(inputView: InputView, outputView: OutputView, private val stationService: StationService) :
    Controller(inputView, outputView) {

    override fun run() {
        manageStation()
    }

    private fun manageStation() {
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

    companion object {
        private const val SUCCESS_TO_REMOVE_STATION_MESSAGE = "\n[INFO] 지하철 역이 삭제되었습니다.\n"
        private const val SUCCESS_TO_ADD_STATION_MESSAGE = "\n[INFO] 지하철 역이 등록되었습니다.\n"
    }

}