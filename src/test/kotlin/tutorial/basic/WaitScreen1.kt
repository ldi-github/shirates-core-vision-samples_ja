package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class WaitScreen1 : VisionTest() {

    @Test
    @Order(10)
    fun waitScreen() {

        scenario {
            case(1) {
                condition {
                    it.terminateApp()
                        .launchApp()
                }.action {
                    it.waitScreen("[Android設定トップ画面]")
                }.expectation {
                    it.screenIs("[Android設定トップ画面]")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun waitScreen_ERROR() {

        scenario {
            case(1) {
                condition {
                    it.terminateApp()
                        .launchApp()
                }.action {
                    it.waitScreen("[ネットワークとインターネット画面]")
                }
            }
        }
    }

    @Test
    @Order(30)
    fun waitScreenOf() {

        scenario {
            case(1) {
                condition {
                    it.terminateApp()
                        .launchApp()
                }.action {
                    it.waitScreenOf(
                        "[Android設定トップ画面]",
                        "[ネットワークとインターネット画面]",
                        "[接続設定画面]"
                    )
                    output("screenName=${it.screenName}")
                }.expectation {
                    it.screenIs("[Android設定トップ画面]")
                }
            }
        }
    }

    @Test
    @Order(40)
    fun waitScreenOf_ERROR() {

        scenario {
            case(1) {
                condition {
                    it.terminateApp()
                        .launchApp("Chrome")
                }.action {
                    it.waitScreenOf(
                        "[Android設定トップ画面]",
                        "[ネットワークとインターネット画面]",
                        "[接続設定画面]"
                    )
                }
            }
        }
    }
}