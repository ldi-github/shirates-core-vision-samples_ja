package tutorial.basic

import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class Tap1 : VisionTest() {

    @Test
    fun tap() {

        scenario {
            case(1) {
                action {
                    it.tap("ネットワークとインターネット")
                        .tap("AndroidWifi")
                    it.pressBack()
                        .pressBack()
                }
            }
            case(2) {
                action {
                    it.tapWithScrollDown("ユーザー補助")
                        .tapWithScrollDown("タイミングの調節")
                    it.pressBack()
                        .pressBack()
                }
            }
        }
    }

    @Test
    fun tapByCoordinates() {

        scenario {
            case(1) {
                action {
                    val v = detect("ネットワークとインターネット")
                    it.tap(x = v.bounds.centerX, y = v.bounds.centerY)
                }.expectation {
                    it.screenIs("[ネットワークとインターネット画面]")
                }
            }
        }
    }

    @Test
    fun tapItemUnder() {

        scenario {
            case(1) {
                action {
                    it.tapItemUnder("モバイル、Wi-Fi、アクセスポイント")
                }.expectation {
                    it.screenIs("[接続設定画面]")
                }
            }
            case(2) {
                condition {
                    it.pressBack()
                }.action {
                    withScrollDown {
                        it.tapItemUnder("充電が完了しました")
                    }
                }.expectation {
                    it.screenIs("[システム画面]")
                }
            }
        }
    }

}