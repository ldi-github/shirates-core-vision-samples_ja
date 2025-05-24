package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.detect
import shirates.core.vision.driver.commandextension.detectLast
import shirates.core.vision.driver.commandextension.textIs
import shirates.core.vision.testcode.VisionTest

class Detect2 : VisionTest() {

    @Test
    @Order(10)
    fun detectLast() {

        scenario {
            case(1) {
                action {
                    it.detect("*設定*")
                }.expectation {
                    it.textIs("設定")
                }
            }
            case(2) {
                action {
                    it.detectLast("*設定*")
                }.expectation {
                    it.textIs("Bluetooth、ペア設定")
                }
            }
        }
    }

}