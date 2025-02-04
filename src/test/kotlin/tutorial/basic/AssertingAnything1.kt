package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.packageName
import shirates.core.vision.driver.commandextension.appIs
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.driver.commandextension.screenIs
import shirates.core.vision.driver.commandextension.verify
import shirates.core.vision.testcode.VisionTest

class AssertingAnything1 : VisionTest() {

    @Test
    @Order(10)
    fun ok() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.verify("パッケージが\"com.android.settings\"であること") {
                        if (packageName == "com.android.settings") {
                            OK()
                        } else {
                            NG()
                        }
                    }
                    it.verify("アプリが[設定]かつ画面が[Android設定画面]であること") {
                        it.appIs("設定")
                        it.screenIs("[Android設定トップ画面]")
                    }
                }
            }
        }
    }

    @Test
    @Order(20)
    fun ng() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.verify("アプリが[Settings2]かつ画面が[Android設定画面]であること") {
                        it.appIs("Settings2")
                        it.screenIs("[Android設定画面]")
                    }
                }
            }
        }
    }

    @Test
    @Order(30)
    fun notImplemented() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.verify("アプリが[設定]かつ画面が[Android設定トップ画面]であること") {
                    }
                }
            }
        }
    }
}