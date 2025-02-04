package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.commandextension.thisIsFalse
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class AndroidKeyboard1 : VisionTest() {

    @Test
    @Order(10)
    fun hideKeyboard() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                        .isKeyboardShown.thisIsFalse("キーボードが表示されています")
                }.action {
                    it.tap("設定を検索")
                }.expectation {
                    it.keyboardIsShown()
                }
            }
            case(2) {
                action {
                    it.hideKeyboard()
                }.expectation {
                    it.keyboardIsNotShown()
                }
            }
        }
    }

}