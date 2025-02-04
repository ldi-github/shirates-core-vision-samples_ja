package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class RelativeItem1 : VisionTest() {

    @Test
    @Order(10)
    fun belowItem_aboveItem() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    v1 = findImage("[接続設定アイコン]")
                }.expectation {
                    v1.belowItem().imageIs("[アプリアイコン]")
                    v1.aboveItem().imageIs("[ネットワークとインターネットアイコン]")
                }
            }
        }

    }

    @Test
    @Order(20)
    fun rightItem_leftItem() {

        scenario {
            case(1) {
                condition {
                    it.macro("[ファイルトップ画面]")
                }.action {
                    v1 = findImage("[音声ボタン]")
                }.expectation {
                    v1.rightItem(include = true).imageIs("[動画ボタン]")
                    v1.leftItem(include = true).imageIs("[画像ボタン]")
                }
            }
        }
    }
}