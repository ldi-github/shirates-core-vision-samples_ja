package macro

import shirates.core.macro.Macro
import shirates.core.macro.MacroObject
import shirates.core.vision.driver.commandextension.tap
import shirates.core.vision.driver.commandextension.waitScreen
import shirates.core.vision.testcode.VisionTest

@MacroObject
object MacroObject1 : VisionTest() {

    @Macro("[Network preferences Screen]")
    fun internetScreen() {

        it.waitScreen("[Android設定トップ画面]")
            .tap("ネットワークとインターネット")
        it.waitScreen("[ネットワークとインターネット画面]")
            .tap("Internet")
        it.waitScreen("[Internet Screen]")
            .tap("Network preferences")
    }

}