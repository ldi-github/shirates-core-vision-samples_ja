package tutorial.basic

import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.appIs
import shirates.core.vision.driver.commandextension.launchApp
import shirates.core.vision.driver.commandextension.terminateApp
import shirates.core.vision.testcode.VisionTest

class LaunchApp1 : VisionTest() {

    @Test
    fun launchApp() {

        scenario {
            case(1) {
                condition {
                    it.terminateApp()   // Refers packageOrBundleId in testConfig.json
                }.action {
                    it.launchApp()  // Refers packageOrBundleId in testConfig.json
                }.expectation {
                    it.appIs("[設定]")  // App Nickname in app.json
                    it.appIs("設定")    // App Nickname in app.json
                    it.appIs("com.android.settings")    // package
                }
            }
            case(2) {
                condition {
                    it.terminateApp("[Chrome]")     // App Nickname in app.json
                }.action {
                    it.launchApp("[Chrome]")
                }.expectation {
                    it.appIs("[Chrome]")
                }
            }
            case(3) {
                condition {
                    it.terminateApp("com.android.chrome")   // package
                }.action {
                    it.launchApp("com.android.chrome")
                }.expectation {
                    it.appIs("com.android.chrome")
                }
            }
            case(4) {
                condition {
                    it.terminateApp("Chrome")   // App Nickname in app.json
                }.action {
                    it.launchApp("Chrome")
                }.expectation {
                    it.appIs("Chrome")
                }
            }
            case(5) {
                condition {
                    it.terminateApp("[Play Store]")     // App Nickname in app.json
                }.action {
                    it.launchApp("[Play Store]")
                }.expectation {
                    it.appIs("[Play Store]")
                }
            }
        }
    }

}