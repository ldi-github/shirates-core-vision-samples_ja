package macro.ios

import shirates.core.macro.Macro
import shirates.core.macro.MacroObject
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

@MacroObject
object iOSSettingsMacro : VisionTest() {

    @Macro("[iOS設定トップ画面]")
    fun iosSettingsTopScreen() {

        if (it.isScreen("[iOS設定トップ画面]")) {
            if (it.canDetect("一般").not()) {
                it.flickAndGoUp()
            }
            return
        }

        it.restartApp("[設定]")
            .screenIs("[iOS設定トップ画面]")
    }

    @Macro("[デベロッパ画面]")
    fun developerScreen() {

        if (it.isScreen("[デベロッパ画面]")) {
            if (it.canDetect("設定")) {
                return
            }
            it.flickTopToBottom()
            if (it.canDetect("設定")) {
                return
            }
        }

        iosSettingsTopScreen()
        it.tapWithScrollDown("デベロッパ")
            .screenIs("[デベロッパ画面]")
    }

    @Macro("[一般画面]")
    fun settingsGeneralScreen() {

        if (it.isScreen("[一般画面]")) {
            return
        }

        iosSettingsTopScreen()
        it.tapWithScrollDown("一般")
            .screenIs("[一般画面]")
    }

}