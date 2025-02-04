package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.driver.commandextension.manual
import shirates.core.vision.testcode.VisionTest

class Manual1 : VisionTest() {

    @Test
    @Order(10)
    fun manualTest() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.manual("開始時にアニメーションが表示されること")
                }
            }
        }

    }
}