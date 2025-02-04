package tutorial.basic

import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.appIs
import shirates.core.vision.driver.commandextension.tapAppIcon
import shirates.core.vision.testcode.VisionTest

class TapAppIcon1 : VisionTest() {

    @Test
    fun tapAppIcon() {

        scenario {
            case(1) {
                action {
                    it.tapAppIcon("Chrome")
                }.expectation {
                    it.appIs("[Chrome]")
                }
            }
            case(2) {
                action {
                    it.tapAppIcon("Play ストア")
                }.expectation {
                    it.appIs("[Playストア]")
                }
            }
        }
    }

}