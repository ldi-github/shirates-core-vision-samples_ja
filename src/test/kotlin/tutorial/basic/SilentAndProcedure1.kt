package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.commandextension.silent
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class SilentAndProcedure1 : VisionTest() {

    @Test
    @Order(10)
    fun silent1() {

        scenario {
            case(1) {
                condition {
                    macro("[Android設定トップ画面]")
                }.action {
                    describe("<システム>をタップする")
                    silent {
                        it.tapWithScrollDown("システム")
                    }
                }.expectation {
                    it.screenIs("[システム画面]")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun procedure1() {

        scenario {
            case(1) {
                condition {
                    macro("[Android設定トップ画面]")
                }.action {
                    procedure("<System>をタップする") {
                        it.tapWithScrollDown("システム")
                    }
                }.expectation {
                    it.screenIs("[システム画面]")
                }
            }
        }
    }

}