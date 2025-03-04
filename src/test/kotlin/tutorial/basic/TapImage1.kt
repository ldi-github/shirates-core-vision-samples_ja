package tutorial.basic

import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.pressBack
import shirates.core.vision.driver.commandextension.screenIs
import shirates.core.vision.driver.commandextension.tapImage
import shirates.core.vision.driver.commandextension.withScrollDown
import shirates.core.vision.testcode.VisionTest

class TapImage1 : VisionTest() {

    @Test
    fun tapImage() {

        scenario {
            case(1) {
                action {
                    it.tapImage("[ネットワークとインターネットアイコン]")
                }.expectation {
                    it.screenIs("[ネットワークとインターネット画面]")
                }
            }
            case(2) {
                condition {
                    it.pressBack()
                }.action {
                    withScrollDown {
                        it.tapImage("[システムアイコン]")
                    }
                }.expectation {
                    it.screenIs("[システム画面]")
                }
            }
        }
    }

}