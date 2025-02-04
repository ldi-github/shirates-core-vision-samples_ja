package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class AndroidPressKey1 : VisionTest() {

    @Test
    @Order(10)
    fun pressBack() {

        scenario {
            case(1) {
                condition {
                    it.macro("[ネットワークとインターネット画面]")
                }.action {
                    it.pressBack()
                }.expectation {
                    it.screenIs("[Android設定トップ画面]")
                }
            }

        }
    }

    @Test
    @Order(20)
    fun pressHome() {

        scenario {
            case(1) {
                condition {
                    it.macro("[ネットワークとインターネット画面]")
                }.action {
                    it.pressHome()
                }.expectation {
                    it.screenIs("[Androidホーム画面]")
                }
            }

        }
    }

    @Test
    @Order(30)
    fun pressTab() {

        scenario {
            case(1) {
                condition {
                    it.macro("[ファイルトップ画面]")
                }.action {
                    it.pressTab()
                        .pressTab()
                        .pressTab()
                        .pressTab()
                        .pressTab()
                        .pressTab()
                        .pressTab()
                        .pressTab()
                }
            }
        }

    }

}