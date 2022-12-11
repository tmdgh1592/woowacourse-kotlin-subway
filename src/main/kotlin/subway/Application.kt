package subway

import subway.controller.Controller
import subway.controller.SubwayController
import subway.presentation.InputView
import subway.presentation.OutputView

fun main() {
    val subwayController: Controller = SubwayController(InputView(), OutputView())
    subwayController.run()
}