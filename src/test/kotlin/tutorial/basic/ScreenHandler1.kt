package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.exist
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.driver.commandextension.tap
import shirates.core.vision.driver.eventextension.onScreen
import shirates.core.vision.testcode.VisionTest

class ScreenHandler1 : VisionTest() {

    @Test
    @Order(10)
    fun screenHandler() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    onScreen("[ネットワークとインターネット画面]") {
                        it.tap("インターネット", last = true)
                    }.onScreen("[インターネット画面]") {
                        it.tap("AndroidWifi")
                    }
                    it.tap("ネットワークとインターネット")
                    /**
                     * onScreen("[ネットワークとインターネット画面]") が呼ばれます
                     */
                    /**
                     * onScreen("[インターネット画面]") が呼ばれます
                     */
                }.expectation {
                    it.exist("ネットワークの詳細")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun screenHandler_keep() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    onScreen("[ネットワークとインターネット画面]") { c ->
                        it.tap("インターネット", last = true)
                        c.keep = true   // スクリーンハンドラーは登録されたままになります。登録解除されません。
                    }
                    it.tap("ネットワークとインターネット")
                }.expectation {
                    it.exist("ネットワーク設定")
                }
            }
        }
    }

    @Test
    @Order(30)
    fun screenHandler_permanent() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    onScreen("[ネットワークとインターネット画面]", permanent = true) {
                        it.tap("インターネット", last = true)
                    }
                    it.tap("ネットワークとインターネット")
                }.expectation {
                    it.exist("ネットワーク設定")
                }
            }
        }
    }

}