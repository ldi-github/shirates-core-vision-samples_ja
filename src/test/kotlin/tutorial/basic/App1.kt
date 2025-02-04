package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.storage.app
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class App1 : VisionTest() {

    @Test
    @Order(10)
    fun app() {

        scenario {
            case(1) {
                condition {
                    it.launchApp("[設定]")
                        .tap("設定を検索")
                        .screenIs("[Android設定検索画面]")
                        .tap("設定を検索")
                }.action {
                    it.sendKeys(app("[設定].packageOrBundleId"))
                }.expectation {
                    it.textIs(app("[設定].packageOrBundleId"))
                }
            }
        }
    }
}