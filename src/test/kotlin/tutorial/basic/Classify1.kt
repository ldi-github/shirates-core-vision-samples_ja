package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.commandextension.thisIs
import shirates.core.vision.driver.classify
import shirates.core.vision.driver.classifyFull
import shirates.core.vision.driver.commandextension.detect
import shirates.core.vision.driver.commandextension.leftItem
import shirates.core.vision.driver.commandextension.screenIs
import shirates.core.vision.testcode.VisionTest

class Classify1 : VisionTest() {

    @Test
    @Order(10)
    fun classify() {

        scenario {
            case(1) {
                condition {
                    it.screenIs("[Android設定トップ画面]")
                }.action {
                    v1 = it.detect("ネットワークとインターネット")
                        .leftItem()
                    s1 = v1.classify()
                }.expectation {
                    s1.thisIs("[ネットワークとインターネットアイコン]", message = "label is $s1")
                }
            }
            case(2) {
                action {
                    s2 = v1.classifyFull()
                }.expectation {
                    s2.thisIs(
                        "@a_Android設定_Android設定トップ画面_[ネットワークとインターネットアイコン]",
                        message = "fullLabel is $s2"
                    )
                }
            }
        }
    }

}