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
    fun ifCanDetectTest() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    ifCanDetect("ネットワークとインターネット") {
                        OK("ifCanDetect called")
                    }.ifElse {
                        NG()
                    }

                    ifCanDetectNot("システム") {
                        OK("ifCanDetectNot called")
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

                    ifCanDetectNot("ユーザー補助") {
                        NG()
                    }.ifElse {
                        OK("ifElse called")
                    }
                }
            }
        }
    }

}