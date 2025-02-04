package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.knownIssue
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.driver.commandextension.manual
import shirates.core.vision.testcode.VisionTest

class KnownIssues1 : VisionTest() {

    @Test
    @Order(10)
    fun knownIssue() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.manual("開始時にアニメーションが表示されること")
                        .knownIssue(
                            message = "アニメーションがスムーズに表示されない",
                            ticketUrl = "https://issues.example.com/TICKET-1234"
                        )
                }
            }
        }

    }

}