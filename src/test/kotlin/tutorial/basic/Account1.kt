package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.storage.account
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class Account1 : VisionTest() {

    @Test
    @Order(10)
    fun account() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                        .tap("設定を検索")
                        .screenIs("[Android設定検索画面]")
                }.action {
                    it.sendKeys(account("[account1].id"))
                }.expectation {
                    it.textIs(account("[account1].id"))
                }
            }
        }

    }
}