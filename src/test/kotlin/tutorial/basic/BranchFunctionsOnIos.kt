package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.testcode.ios
import shirates.core.vision.driver.branchextension.*
import shirates.core.vision.driver.commandextension.describe
import shirates.core.vision.driver.commandextension.screenIs
import shirates.core.vision.testcode.VisionTest


@ios
class BranchFunctionsOnIos : VisionTest() {

    @Test
    @Order(10)
    fun branch_platform_device() {

        scenario {
            case(1) {
                condition {
                    it.screenIs("[iOS設定トップ画面]")
                }.action {
                    android {
                        virtualDevice {
                            describe("この処理はAndroidエミューレーターにおいて呼び出されました")
                        }
                        realDevice {
                            describe("この処理はAndroid実機において呼び出されました")
                        }
                    }
                    ios {
                        virtualDevice {
                            describe("この処理はiOSシミュレーターにおいて呼び出されました")
                        }
                        realDevice {
                            describe("この処理はiOS実機において呼び出されました")
                        }
                    }
                }.expectation {
                    it.screenIs("[iOS設定トップ画面]")
                }
            }
            case(2) {
                action {
                    emulator {
                        describe("この処理はAndroidエミュレーターにおいて呼び出されました")
                    }
                    simulator {
                        describe("この処理はiOSシミュレーターにおいて呼び出されました")
                    }
                    realDevice {
                        describe("この処理は実機において呼び出されました")
                    }
                }.expectation {
                    it.screenIs("[iOS設定トップ画面]")
                }
            }
        }

    }
}