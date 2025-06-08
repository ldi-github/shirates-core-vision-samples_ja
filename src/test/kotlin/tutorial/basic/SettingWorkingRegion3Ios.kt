package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.testcode.ios
import shirates.core.vision.driver.commandextension.detect
import shirates.core.vision.driver.commandextension.dontExist
import shirates.core.vision.driver.commandextension.exist
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.driver.commandextension.onRowOf
import shirates.core.vision.driver.commandextension.onThisElementRegion
import shirates.core.vision.driver.commandextension.row
import shirates.core.vision.testcode.VisionTest

@ios
class SettingWorkingRegion3Ios : VisionTest() {

    @Test
    @Order(10)
    fun row_onRowOf() {

        scenario {
            case(1) {
                condition {
                    it.macro("[iOS設定トップ画面]")
                }.expectation {
                    it.detect("Apple Account")
                        .row()
                        .onThisElementRegion {
                            it.exist("*サインインします。")
                            it.dontExist("一般")
                        }
                    it.detect("一般")
                        .row()
                        .onThisElementRegion {
                            it.dontExist("*サインインします。")
                            it.exist("一般")
                        }
                }
            }
            case(2) {
                expectation {
                    it.onRowOf("Apple Account") {
                        it.exist("*サインインします。")
                        it.dontExist("一般")
                    }
                    it.onRowOf("一般") {
                        it.dontExist("*サインインします。")
                        it.exist("一般")
                    }
                }
            }
        }
    }

}