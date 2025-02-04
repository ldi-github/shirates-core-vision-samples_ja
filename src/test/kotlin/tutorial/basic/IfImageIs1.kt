package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.branchextension.ifImageIs
import shirates.core.vision.driver.branchextension.ifImageIsNot
import shirates.core.vision.driver.commandextension.detect
import shirates.core.vision.driver.commandextension.leftItem
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.testcode.VisionTest

class IfImageIs1 : VisionTest() {

    @Test
    @Order(10)
    fun ifImageIsTest() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.detect("ネットワークとインターネット")
                        .leftItem()
                        .ifImageIs("[ネットワークとインターネットアイコン]") {
                            OK("ifImageIs called")
                        }.ifElse {
                            NG()
                        }
                    it.detect("ネットワークとインターネット")
                        .leftItem()
                        .ifImageIsNot("[ネットワークとインターネットアイコン]") {
                            NG()
                        }.ifElse {
                            OK("ifElse called")
                        }
                }
            }
            case(2) {
                expectation {
                    it.detect("ネットワークとインターネット")
                        .leftItem()
                        .ifImageIs("[アプリアイコン]") {
                            NG()
                        }.ifElse {
                            OK("ifElse called")
                        }
                    it.detect("ネットワークとインターネット")
                        .leftItem()
                        .ifImageIsNot("[アプリアイコン]") {
                            OK("ifImageIsNot called")
                        }.ifElse {
                            NG()
                        }
                }
            }
        }
    }

}