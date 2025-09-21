package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.isEmulator
import shirates.core.vision.driver.branchextension.ifTrue
import shirates.core.vision.driver.commandextension.caption
import shirates.core.vision.driver.commandextension.exist
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.driver.commandextension.tapWithScrollDown
import shirates.core.vision.testcode.VisionTest

class IfTrueIfFalse1 : VisionTest() {

    @Test
    @Order(10)
    fun ifTrueIfFalse() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    isEmulator
                        .ifTrue {
                            it.caption("on emulator")
                                .tapWithScrollDown("*エミュレートされた*")
                        }
                        .ifElse {
                            it.caption("on real device")
                                .tapWithScrollDown("デバイス情報")
                        }
                }.expectation {
                    isEmulator
                        .ifTrue {
                            it.caption("on emulator")
                                .exist("*エミュレートされた*")
                        }
                        .ifElse {
                            it.caption("on real device")
                                .exist("デバイス情報")
                        }
                }
            }
        }
    }

    @Test
    @Order(20)
    fun ifTrueIfFalse_withMessage() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    isEmulator
                        .ifTrue("on emulator") {
                            it.tapWithScrollDown("*エミュレートされた*")
                        }
                        .ifElse("on real device") {
                            it.tapWithScrollDown("デバイス情報")
                        }
                }.expectation {
                    isEmulator
                        .ifTrue("on emulator") {
                            it.exist("*エミュレートされた*")
                        }
                        .ifElse("on real device") {
                            it.exist("デバイス情報")
                        }
                }
            }
        }
    }
}