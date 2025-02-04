package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class RelativeText1 : VisionTest() {

    @Test
    @Order(10)
    fun belowText_aboveText() {

        scenario {
            case(1) {
                condition {
                    it.macro("[ネットワークとインターネット画面]")
                }.action {
                    v1 = detect("機内モード")
                }.expectation {
                    v1.belowText().textIs("アクセスポイントとテザリング")
                    v1.aboveText().textIs("T-Mobile")
                }
            }
        }

    }

    @Test
    @Order(20)
    fun rightText_leftText() {

        scenario {
            case(1) {
                condition {
                    it.macro("[マップトップ画面]")
                }.action {
                    v1 = detect("保存済み")
                }.expectation {
                    v1.rightText().textIs("投稿")
                    v1.leftText().textIs("スポット")
                }
            }
        }
    }
}