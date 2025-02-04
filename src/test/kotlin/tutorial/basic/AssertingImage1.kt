package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.detect
import shirates.core.vision.driver.commandextension.imageIs
import shirates.core.vision.driver.commandextension.leftItem
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.testcode.VisionTest

class AssertingImage1 : VisionTest() {

    @Test
    @Order(10)
    fun imageIs() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    v1 = it.detect("ネットワークとインターネット")
                        .leftItem()
                }.expectation {
                    v1.imageIs("[ネットワークとインターネットアイコン]")
                }
            }
        }
    }

}