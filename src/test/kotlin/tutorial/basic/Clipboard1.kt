package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.commandextension.thisIs
import shirates.core.driver.commandextension.writeToClipboard
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class Clipboard1 : VisionTest() {

    @Test
    @Order(10)
    fun element_clipboard() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    it.detect("設定")
                        .clipboardText()
                }.expectation {
                    readClipboard()
                        .thisIs("設定")
                }
            }
            case(2) {
                condition {
                    it.exist("ネットワークとインターネット")
                }.action {
                    it.clipboardText()
                }.expectation {
                    readClipboard()
                        .thisIs("ネットワークとインターネット")
                }
            }
        }

    }

    @Test
    @Order(20)
    fun string_clipboard() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    "String1".writeToClipboard()
                }.expectation {
                    readClipboard()
                        .thisIs("String1")
                }
            }
        }

    }

}