package demo.vision

import org.junit.jupiter.api.Test
import shirates.core.testcode.android
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

@android
class AndroidSettingsVisionDemo : VisionTest() {

    @Test
    fun airplaneModeSwitch() {

        scenario {
            case(1) {
                condition {
                    it.screenIs("[Android設定トップ画面]")
                }.action {
                    it.tap("ネットワークとインターネット")
                }.expectation {
                    it.screenIs("[ネットワークとインターネット画面]")
                }
            }
            case(2) {
                condition {
                    it.detect("機内モード")
                        .rightItem()
                        .checkIsOFF()
                }.action {
                    it.tap()
                }.expectation {
                    it.detect("機内モード")
                        .rightItem()
                        .checkIsON()
                }
            }
            case(3) {
                action {
                    it.tap()
                }.expectation {
                    it.detect("機内モード")
                        .rightItem()
                        .checkIsOFF()
                }
            }
        }
    }
}