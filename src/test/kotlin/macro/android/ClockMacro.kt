package macro.android

import shirates.core.macro.Macro
import shirates.core.macro.MacroObject
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.driver.isApp
import shirates.core.vision.testcode.VisionTest

@MacroObject
object ClockMacro : VisionTest() {

    @Macro("[時計を再起動する]")
    fun restartClock() {

        it.terminateApp("[時計]")
            .launchApp("[時計]")
    }

    @Macro("[アラーム画面]")
    fun alarmScreen() {

        if (it.isApp("[時計]").not()) {
            restartClock()
        }
        if (it.isScreen("[アラーム画面]").not()) {
            it.tapLast("アラーム")
        }
        it.screenIs("[アラーム画面]")
    }

}