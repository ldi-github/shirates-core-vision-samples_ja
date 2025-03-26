package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.driver.commandextension.screenIs
import shirates.core.vision.driver.commandextension.tap
import shirates.core.vision.driver.eventextension.onScreen
import shirates.core.vision.testcode.VisionTest

class ScreenHandler1 : VisionTest() {

    @Test
    @Order(10)
    fun screenHandler() {

        scenario {
            case(1) {
                condition {
                    onScreen("[Android設定トップ画面]") {
                        it.tap("ネットワークとインターネット")
                    }
                    onScreen("[ネットワークとインターネット画面]") {
                        it.tap("インターネット", last = true)
                    }
                }.action {
                    it.macro("[Android設定トップ画面]")
                    /**
                     * onScreen("[Android設定トップ画面]") が呼ばれます
                     */
                    /**
                     * onScreen("[ネットワークとインターネット画面]") が呼ばれます
                     */
                }.expectation {
                    it.screenIs("[インターネット画面]")
                }
            }
        }
    }

}