package macro.android

import ifCanDetect
import shirates.core.macro.Macro
import shirates.core.macro.MacroObject
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

@MacroObject
object MapsMacro : VisionTest() {

    @Macro("[マップトップ画面]")
    fun mapsTopScreen() {

        if (it.isScreen("[マップトップ画面]")) {
            return
        }

        it.terminateApp("[マップ]")
            .launchApp("[マップ]")
            .ifCanDetect("通知") {
                it.tap("許可")
            }
            .ifCanDetect("Make it your map") {
                it.tap("スキップ")
            }

        if (it.isScreen("[マップトップ画面]")) {
            return
        }

        it.tapCenterOfScreen()
        if (it.isScreen("[マップトップ画面]")) {
            return
        }

        it.tapCenterOfScreen()
        if (it.isScreen("[マップトップ画面]")) {
            return
        }

        it.screenIs("[マップトップ画面]")
    }
}