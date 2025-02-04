package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.ifScreenIs
import shirates.core.vision.driver.commandextension.ifScreenIsNot
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.driver.commandextension.tap
import shirates.core.vision.testcode.VisionTest

class IfScreenIs1 : VisionTest() {

    @Test
    @Order(10)
    fun ifScreenIsTest() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    ifScreenIs("[Android設定トップ画面]") {
                        OK("ifScreenIs called")
                    }.ifElse {
                        NG()
                    }
                }
            }
            case(2) {
                action {
                    it.tap("ネットワークとインターネット")
                }.expectation {
                    ifScreenIs("[ネットワークとインターネット画面]") {
                        OK("ifScreenIs called")
                    }.ifElse {
                        NG()
                    }
                }
            }
        }
    }

    @Test
    @Order(20)
    fun ifScreenIsNotTest() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    ifScreenIsNot("[Android設定トップ画面]") {
                        NG()
                    }.ifElse {
                        OK("ifElse called")
                    }
                }
            }
            case(2) {
                action {
                    it.tap("ネットワークとインターネット")
                }.expectation {
                    ifScreenIsNot("[ネットワークとインターネット画面]") {
                        NG()
                    }.ifElse {
                        OK("ifElse called")
                    }
                }
            }
        }
    }

}