package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.testcode.ios
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.driver.waitForDisplay
import shirates.core.vision.testcode.VisionTest

@ios
class iOSSendKeys1 : VisionTest() {

    @Test
    @Order(10)
    fun sendKeys_clearInput() {

        scenario {
            case(1) {
                condition {
                    it.launchApp("[マップ]")
                        .waitForDisplay("マップで検索")
                        .tap()
                }.action {
                    it.sendKeys("safari")
                }.expectation {
                    it.textIs("safari")
                }
            }
            case(2) {
                action {
                    it.clearInput()
                }.expectation {
                    it.textIs("マップで検索")
                }
            }
        }
    }

}