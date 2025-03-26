package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.commandextension.thisIs
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.driver.commandextension.screenIs
import shirates.core.vision.driver.commandextension.tap
import shirates.core.vision.driver.tempSelector
import shirates.core.vision.driver.tempValue
import shirates.core.vision.testcode.VisionTest

class TempSelector1 : VisionTest() {

    @Test
    @Order(10)
    fun tempSelector1() {

        tempSelector("{最初のアイテム}", "ネットワークとインターネット")

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    it.tap("{最初のアイテム}")
                }.expectation {
                    it.screenIs("[ネットワークとインターネット画面]")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun tempValue1() {

        scenario {
            case(1) {
                condition {
                    tempSelector("{nickname1}", "value1")
                }.expectation {
                    tempValue("{nickname1}").thisIs("value1")
                }
            }
            case(2) {
                condition {
                    tempSelector("{nickname1}", "value2")
                }.expectation {
                    tempValue("{nickname1}").thisIs("value2")
                }
            }
        }
    }

}