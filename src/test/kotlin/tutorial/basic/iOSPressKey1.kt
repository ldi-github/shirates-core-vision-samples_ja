package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.testcode.ios
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

@ios
class iOSPressKey1 : VisionTest() {

    @Test
    @Order(10)
    fun pressBack() {

        scenario {
            case(1) {
                condition {
                    it.appIs("[設定]")
                        .launchApp("[マップ]")
                        .appIs("[マップ]")
                }.action {
                    it.pressBack()
                }.expectation {
                    it.appIs("[設定]")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun pressHome() {

        scenario {
            case(1) {
                condition {
                    it.macro("[iOS設定トップ画面]")
                }.action {
                    it.pressHome()
                }.expectation {
                    it.screenIs("[iOSホーム画面]")
                }
            }
        }
    }

}