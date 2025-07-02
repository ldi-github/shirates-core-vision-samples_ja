package demo.vision.gallery

import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class ClassifierTest : VisionTest() {

    @Test
    fun classifiers() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                        .screenIs("[Android設定トップ画面]")
                }.action {
                    it.findImage("[ネットワークとインターネットアイコン]")
                }.expectation {
                    it.belowItem()
                        .imageIs("[接続設定アイコン]")
                    it.existImage("[アプリアイコン]")
                }
            }
            case(2) {
                condition {
                    it.tap("ネットワークとインターネット")
                        .screenIs("[ネットワークとインターネット画面]")
                }.expectation {
                    it.detect("機内モード")
                        .rightItem()
                        .checkIsOFF()
                }
            }
            case(3) {
                action {
                    it.tap()
                }.expectation {
                    it.checkIsON()
                }
            }
            case(4) {
                action {
                    it.tap()
                }.expectation {
                    it.checkIsOFF()
                }
            }
        }
    }
}