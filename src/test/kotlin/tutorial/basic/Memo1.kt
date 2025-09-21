package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.commandextension.thisIs
import shirates.core.logging.printInfo
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.driver.waitForDisplay
import shirates.core.vision.testcode.VisionTest

class Memo1 : VisionTest() {

    @Order(10)
    @Test
    fun writeMemo_readMemo() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                        .tapWithScrollDown("ストレージ")
                        .waitForDisplay("GB")
                        .flickAndGoDownTurbo()
                }.action {
                    writeMemo("アプリ", it.detect("アプリ").rightText().text)
                    writeMemo("一時システムファイル", it.detect("一時システムファイル").rightText().text)
                }.expectation {
                    readMemo("アプリ").printInfo()
                    readMemo("一時システムファイル").printInfo()
                }
            }
        }
    }

    @Order(20)
    @Test
    fun memoTextAs_readMemo() {

        scenario {
            case(1) {
                condition {
                    it.macro("[ネットワークとインターネット画面]")
                }.action {
                    it.detect("SIM").belowText().memoTextAs("SIM")
                    it.detect("VPN").belowText().memoTextAs("VPN")
                }.expectation {
                    it.readMemo("SIM").thisIs("T-Mobile")
                    it.readMemo("VPN").thisIs("なし")
                }
            }
        }

    }
}