package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.platformMajorVersion
import shirates.core.vision.driver.commandextension.exist
import shirates.core.vision.driver.commandextension.output
import shirates.core.vision.driver.commandextension.tap
import shirates.core.vision.testcode.VisionTest

class SkipAndNotImpl1 : VisionTest() {

    @Test
    @Order(10)
    fun skipCase() {

        scenario {
            case(1) {
                condition {
                    output("platformMajorVersion=$platformMajorVersion")
                    if (platformMajorVersion > 5) {
                        SKIP_CASE("case(1) skipped.")   // Skip execution of commands (log only)
                    }
                }.action {
                    it.tap("ネットワークとインターネット")  // Skipped
                }.expectation {
                    it.exist("機内モード")    // Skipped
                }
            }
            case(2) {
                action {
                    it.tap("ネットワークとインターネット")  // Executed
                }.expectation {
                    it.exist("機内モード")    // Executed
                }
            }
        }
    }

    @Test
    @Order(20)
    fun skipScenario() {

        scenario {
            case(1) {
                condition {
                    output("platformMajorVersion=$platformMajorVersion")
                    if (platformMajorVersion > 5) {
                        SKIP_SCENARIO()     // Skip execution of commands (log only)
                    }
                }.action {
                    it.tap("ネットワークとインターネット")  // Skipped
                }.expectation {
                    it.exist("機内モード")    // Skipped
                }
            }
            case(2) {
                action {
                    it.tap("インターネット")  // Skipped
                }.expectation {
                    it.exist("ネットワークを追加")    // Skipped
                }
            }
        }
    }

    @Test
    @Order(30)
    fun notImpl_case() {

        scenario {
            case(1) {
                action {
                    it.tap("ネットワークとインターネット")  // Executed
                }.expectation {
                    it.exist("機内モード")    // Executed
                }
            }
            case(2) {
                condition {
                    NOTIMPL()   // Abort this test
                }.action {
                    it.tap("ネットワークとインターネット")  // Not reached
                }.expectation {
                    it.exist("機内モード")    // Not reached
                }
            }
            case(3) {
                action {
                    it.tap("インターネット")  // Not reached
                }.expectation {
                    it.exist("ネットワークを追加")    // Not reached
                    NOTIMPL("To be implement.")     // Not reached
                }
            }
        }
    }

    @Test
    @Order(40)
    fun notImpl_scenario() {

        scenario {
            NOTIMPL()   // Abort this scenario

            case(1) {
                action {
                    it.tap("ネットワークとインターネット")    // Not reached
                }.expectation {
                    it.exist("機内モード")   // Not reached
                }
            }
        }
    }

}