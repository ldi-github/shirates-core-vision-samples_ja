package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.TestDriver.testContext
import shirates.core.logging.printInfo
import shirates.core.testcode.ios
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

@ios
class ColorScale1Ios : VisionTest() {

    @Test
    @Order(10)
    fun colorScale_GRAY32() {

        // default colorScale is GRAY_32
        printInfo("${testContext.visionColorScale}")

        scenario {
            case(1) {
                condition {
                    it.macro("[iOS設定トップ画面]")
                }.action {
                    v1 = detect("一般").leftItem()
                }.expectation {
                    it.imageIs("[一般アイコン]")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun colorScale_GRAY16() {

        // change colorScale to GRAY_16
        colorScaleGray16()
        printInfo("${testContext.visionColorScale}")

        scenario {
            case(1) {
                condition {
                    it.macro("[iOS設定トップ画面]")
                }.action {
                    v1 = detect("一般").leftItem()
                }.expectation {
                    it.imageIs("[一般アイコン]")
                }
            }
        }
    }

}