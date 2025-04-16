package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.exist
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.driver.commandextension.screenIs
import shirates.core.vision.testcode.VisionTest

class ScreenIsAndIsScreen2 : VisionTest() {

    @Test
    @Order(10)
    fun screenIs_with_verifyFunc_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.screenIs("[Android設定トップ画面]") {   // OK
                        exist("設定")         // OK（ログは出力されない）
                        exist("設定を検索")    // OK（ログは出力されない）
                    }
                }
            }
        }
    }

    @Test
    @Order(20)
    fun screenIs_with_verifyFunc_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.screenIs("[Android設定トップ画面]") {   // OK
                        exist("システム")   // NG（ログは出力される）
                    }
                }
            }
        }
    }

}