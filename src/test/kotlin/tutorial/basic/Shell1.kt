package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.TestMode.isRunningOnWindows
import shirates.core.driver.commandextension.thisContains
import shirates.core.driver.commandextension.thisIsFalse
import shirates.core.driver.commandextension.thisIsTrue
import shirates.core.driver.commandextension.thisStartsWith
import shirates.core.utility.misc.ShellUtility
import shirates.core.vision.driver.commandextension.shell
import shirates.core.vision.driver.commandextension.shellAsync
import shirates.core.vision.testcode.VisionTest

class Shell1 : VisionTest() {

    @Test
    @Order(10)
    fun shell() {

        scenario {
            case(1) {
                action {
                    if (isRunningOnWindows) {
                        s1 = it.shell("ping", "localhost").resultString
                    } else {
                        s1 = it.shell("ping", "localhost", "-c", "3").resultString
                    }
                }.expectation {
                    s1.thisContains("ping")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun shellAsync() {

        var shellResult: ShellUtility.ShellResult? = null

        scenario {
            case(1) {
                action {
                    if (isRunningOnWindows) {
                        shellResult = it.shellAsync("ping", "localhost")
                    } else {
                        shellResult = it.shellAsync("ping", "localhost", "-c", "3")
                    }
                }.expectation {
                    shellResult!!.hasCompleted.thisIsFalse("hasCompleted=false")
                }
            }
            case(2) {
                expectation {
                    // resultString calls waitFor() in it
                    shellResult!!.resultString.thisStartsWith("PING localhost (127.0.0.1)")
                    shellResult!!.hasCompleted.thisIsTrue("hasCompleted=true")
                }
            }
        }
    }
}