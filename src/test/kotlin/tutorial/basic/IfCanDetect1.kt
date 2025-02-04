package tutorial.basic

import ifCanDetect
import ifCanDetectNot
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.driver.commandextension.scrollToBottom
import shirates.core.vision.testcode.VisionTest

class IfCanDetect1 : VisionTest() {

    @Test
    @Order(10)
    fun ifCanSelectTest() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    ifCanDetect("ネットワークとインターネット") {
                        OK("ifCanSelect called")
                    }.ifElse {
                        NG()
                    }

                    ifCanDetectNot("システム") {
                        OK("ifCanSelectNot called")
                    }.ifElse {
                        NG()
                    }
                }
            }
            case(2) {
                action {
                    it.scrollToBottom()
                }.expectation {
                    ifCanDetect("ネットワークとインターネット") {
                        NG()
                    }.ifElse {
                        OK("ifElse called")
                    }

                    ifCanDetectNot("システム") {
                        NG()
                    }.ifElse {
                        OK("ifElse called")
                    }
                }
            }
        }
    }

}