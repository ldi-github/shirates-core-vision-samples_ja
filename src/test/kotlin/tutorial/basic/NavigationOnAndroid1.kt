package tutorial.basic

import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.appIs
import shirates.core.vision.driver.commandextension.goPreviousApp
import shirates.core.vision.driver.commandextension.launchApp
import shirates.core.vision.testcode.VisionTest

class NavigationOnAndroid1 : VisionTest() {

    @Test
    fun goPreviousAppTest() {

        scenario {
            case(1) {
                condition {
                    it.launchApp("[設定]")
                }.expectation {
                    it.appIs("[設定]")
                }
            }
            case(2) {
                action {
                    it.launchApp("[マップ]")
                }.expectation {
                    it.appIs("[マップ]")
                }
            }
            case(3) {
                action {
                    it.goPreviousApp()
                }.expectation {
                    it.appIs("[設定]")
                }
            }
        }
    }

}