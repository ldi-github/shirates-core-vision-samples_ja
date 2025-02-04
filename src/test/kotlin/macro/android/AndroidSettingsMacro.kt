package macro.android

import shirates.core.macro.Macro
import shirates.core.macro.MacroObject
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.driver.syncScreen
import shirates.core.vision.testcode.VisionTest

@MacroObject
object AndroidSettingsMacro : VisionTest() {

    @Macro("[Android設定トップ画面]")
    fun androidSettingsTopScreen() {

        if (it.isScreen("[Android設定トップ画面]")) {
            it.flickAndGoUpTurbo()
            return
        }

        it.restartApp()
            .launchApp("[設定]")
            .screenIs("[Android設定トップ画面]")

        it.flickAndGoUp()
        it.syncScreen()
    }

    @Macro("[Android設定検索画面]")
    fun androidSearchScreen() {

        if (it.isScreen("[Android設定検索画面]")) {
            return
        }
        androidSettingsTopScreen()
        it.tap("設定を検索")
            .screenIs("[Android設定検索画面]")
    }

    @Macro("[ネットワークとインターネット画面]")
    fun networkAndInternetScreen() {

        if (it.isScreen("[ネットワークとインターネット画面]")) {
            it.flickAndGoUpTurbo()
            return
        }

        androidSettingsTopScreen()
        it.tapWithScrollUp("ネットワークとインターネット")
            .screenIs("[ネットワークとインターネット画面]")
    }

    @Macro("[インターネット画面]")
    fun internetScreen() {

        if (it.isScreen("[インターネット画面]")) {
            it.flickAndGoUpTurbo()
            return
        }

        androidSettingsTopScreen()
        it.tap("ネットワークとインターネット")
            .screenIs("[ネットワークとインターネット画面]")
        it.tap("インターネット")
            .screenIs("[インターネット画面]")
    }

    @Macro("[接続設定画面]")
    fun connectedDevicesScreen() {

        if (it.isScreen("[接続設定画面]")) {
            it.flickAndGoUpTurbo()
            return
        }

        androidSettingsTopScreen()
        it.tapWithScrollDown("接続設定")
            .screenIs("[接続設定画面]")
    }

    @Macro("[バッテリー画面]")
    fun batteryScreen() {

        if (it.isScreen("[バッテリー画面]")) {
            it.flickAndGoUpTurbo()
            return
        }

        androidSettingsTopScreen()
        it.tapWithScrollDown("バッテリー")
            .screenIs("[バッテリー画面]")
    }

    @Macro("[壁紙とスタイル画面]")
    fun wallpaperAndStyleScreen() {

        if (it.isScreen("[壁紙とスタイル画面]")) {
            return
        }

        androidSettingsTopScreen()
        it.tapWithScrollDown("壁紙とスタイル")
            .screenIs("[壁紙とスタイル画面]")
    }

    @Macro("[ユーザー補助画面]")
    fun accessibilityScreen() {

        if (it.isScreen("[ユーザー補助画面]")) {
            it.flickAndGoUpTurbo()
            return
        }

        androidSettingsTopScreen()
        it.tapWithScrollDown("[ユーザー補助]")
            .screenIs("[ユーザー補助画面]")
    }

    @Macro("[システム画面]")
    fun systemScreen() {

        if (it.isScreen("[システム画面]")) {
            it.flickAndGoUpTurbo()
        }

        androidSettingsTopScreen()
        it.flickAndGoDownTurbo()
            .tapWithScrollDown("システム")
            .screenIs("[システム画面]")
    }

    @Macro("[開発者向けオプション画面]")
    fun developerOptionsScreen() {

        systemScreen()
        it.tapWithScrollDown("開発者向けオプション")
            .screenIs("[開発者向けオプション画面]")
    }

}