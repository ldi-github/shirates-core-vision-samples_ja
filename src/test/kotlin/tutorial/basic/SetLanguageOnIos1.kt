package tutorial.basic

import org.junit.jupiter.api.Test
import shirates.core.driver.behavior.LanguageHelper
import shirates.core.testcode.ios
import shirates.core.vision.driver.commandextension.exist
import shirates.core.vision.testcode.VisionTest

@ios
class SetLanguageOnIos1 : VisionTest() {

    @Test
    fun setLanguageAndLocale() {

        scenario {
            case(1) {
                action {
                    LanguageHelper.setLanguageAndLocale(language = "ja", locale = "JP")
                }.expectation {
                    it.exist("設定", waitSeconds = 10.0)
                }
            }
            case(2) {
                action {
                    LanguageHelper.setLanguageAndLocale(language = "en", locale = "US")
                }.expectation {
                    it.exist("Settings", waitSeconds = 10.0)
                }
            }
        }
    }

}