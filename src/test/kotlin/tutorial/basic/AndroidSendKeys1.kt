package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.clearInput
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.driver.commandextension.sendKeys
import shirates.core.vision.driver.commandextension.textIs
import shirates.core.vision.testcode.VisionTest

class AndroidSendKeys1 : VisionTest() {

    @Test
    @Order(10)
    fun sendKeys_clearInput() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定検索画面]")
                }.action {
                    it.sendKeys("時計")
                }.expectation {
                    it.textIs("時計")
                }
            }
            case(2) {
                action {
                    it.clearInput()
                }.expectation {
                    it.textIs("設定を検索")
                }
            }
        }
    }

}