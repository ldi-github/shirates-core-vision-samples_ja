package tutorial.basic

import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class Scroll2 : VisionTest() {

    @Test
    fun scrollToRightEdge_scrollToLeftEdge() {

        scenario {
            case(1) {
                condition {
                    it.macro("[マップトップ画面]")
                }.action {
                    it.detect("レストラン").onLine {
                        it.scrollToRightEdge()
                    }
                }.expectation {
                    it.exist("もっと見る")
                }
            }
            case(2) {
                action {
                    it.detect("もっと見る").onLine {
                        it.scrollToLeftEdge()
                    }
                }.expectation {
                    it.dontExist("もっと見る")
                }
            }
        }
    }

}