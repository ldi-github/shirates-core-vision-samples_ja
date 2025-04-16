package tutorial.inaction

import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.flickAndGoDown
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.driver.commandextension.screenIs
import shirates.core.vision.driver.commandextension.tapWithScrollDown
import shirates.core.vision.testcode.VisionTest

class TextIndex1 : VisionTest() {

    @Test
    fun textIndexScenario1() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    it.flickAndGoDown()
                        .tapWithScrollDown("システム")
                        .tapWithScrollDown("開発者向けオプション")
                }.expectation {
                    it.screenIs("[開発者向けオプション画面]")
                }
            }
        }
    }

}