package macro.android

import shirates.core.macro.Macro
import shirates.core.macro.MacroObject
import shirates.core.vision.driver.commandextension.isScreen
import shirates.core.vision.driver.commandextension.launchApp
import shirates.core.vision.driver.commandextension.screenIs
import shirates.core.vision.driver.commandextension.terminateApp
import shirates.core.vision.driver.waitForDisplay
import shirates.core.vision.testcode.VisionTest

@MacroObject
object FilesMacro : VisionTest() {

    @Macro("[ファイルを再起動]")
    fun restartFiles() {

        it.terminateApp("com.google.android.documentsui")
            .launchApp("com.google.android.documentsui")
    }

    @Macro("[ファイルトップ画面]")
    fun mapsTopScreen() {

        if (it.isScreen("[ファイルトップ画面]")) {
            return
        }

        it.terminateApp("com.google.android.documentsui")
            .launchApp("com.google.android.documentsui")
            .waitForDisplay("ダウンロード")

        if (it.isScreen("[ファイルトップ画面]")) {
            return
        }

        restartFiles()

        it.screenIs("[ファイルトップ画面]")
    }
}