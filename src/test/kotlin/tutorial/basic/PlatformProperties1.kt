package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.TestMode.isAndroid
import shirates.core.driver.TestMode.isiOS
import shirates.core.driver.commandextension.thisIs
import shirates.core.driver.commandextension.thisIsFalse
import shirates.core.driver.commandextension.thisIsTrue
import shirates.core.driver.platformMajorVersion
import shirates.core.driver.platformName
import shirates.core.driver.platformVersion
import shirates.core.vision.testcode.VisionTest

class PlatformProperties1 : VisionTest() {

    @Test
    @Order(10)
    fun platformProperties() {

        scenario {
            case(1) {
                expectation {
                    platformName
                        .thisIs("android")

                    platformVersion
                        .thisIs("16")

                    platformMajorVersion
                        .thisIs(16)

                    isAndroid
                        .thisIsTrue()

                    isiOS
                        .thisIsFalse()
                }
            }
        }
    }

}