package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class SettingWorkingRegion2 : VisionTest() {

    @Test
    @Order(10)
    fun cellOf_onCellOf() {

        scenario {
            case(1) {
                condition {
                    it.macro("[アラーム画面]")
                }.expectation {
                    it.detect("8:30")
                        .cell()
                        .onThisElementRegion {
                            it.exist("月、火、水、木、金")
                            it.dontExist("日、土")
                        }
                    it.detect("9:00")
                        .cell()
                        .onThisElementRegion {
                            it.dontExist("月、火、水、木、金")
                            it.exist("日、土")
                        }
                }
            }
            case(2) {
                expectation {
                    it.onCellOf("8:30") {
                        it.exist("月、火、水、木、金")
                        it.dontExist("日、土")
                    }
                    it.onCellOf("9:00") {
                        it.dontExist("月、火、水、木、金")
                        it.exist("日、土")
                    }
                }
            }
        }
    }

}