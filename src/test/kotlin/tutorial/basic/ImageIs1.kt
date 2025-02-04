package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class ImageIs1 : VisionTest() {

    @Test
    @Order(10)
    fun imageIs() {

        scenario {
            case(1) {
                condition {
                    it.screenIs("[Android設定トップ画面]")
                }.action {
                    v1 = it.detect("ネットワークとインターネット")
                        .leftItem()
                }.expectation {
                    v1.imageIs("[ネットワークとインターネットアイコン]")
                }
            }
            case(2) {
                expectation {
                    v1.imageFullLabelIs("@a[Android設定アプリ][Android設定トップ画面][ネットワークとインターネットアイコン]")
                }
            }
        }
    }

}