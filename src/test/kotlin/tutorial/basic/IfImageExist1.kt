package tutorial.basic

import ifImageExist
import ifImageExistNot
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.driver.commandextension.scrollToBottom
import shirates.core.vision.testcode.VisionTest

class IfImageExist1 : VisionTest() {

    @Test
    @Order(10)
    fun ifImageExistTest() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    ifImageExist("[ネットワークとインターネットアイコン]") {
                        OK("ifImageExist called")
                    }.ifElse {
                        NG()
                    }

                    ifImageExistNot("[システムアイコン]") {
                        OK("ifImageExistNot called")
                    }.ifElse {
                        NG()
                    }
                }
            }
            case(2) {
                action {
                    it.scrollToBottom()
                }.expectation {
                    ifImageExist("[ネットワークとインターネットアイコン]") {
                        NG()
                    }.ifElse {
                        OK("ifElse called")
                    }

                    ifImageExistNot("[位置情報アイコン]") {
                        NG()
                    }.ifElse {
                        OK("ifElse called")
                    }
                }
            }
        }
    }

}