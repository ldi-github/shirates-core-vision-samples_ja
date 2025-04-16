package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.commandextension.thisIsFalse
import shirates.core.driver.commandextension.thisIsTrue
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class CanDetect1 : VisionTest() {

    @Test
    @Order(10)
    fun canDetect() {

        scenario {
            case(1) {
                expectation {
                    it.canDetect("設定")
                        .thisIsTrue("<設定>が見つかりました")
                }
            }
            case(2) {
                expectation {
                    it.canDetectWithScrollDown("システム")
                        .thisIsTrue("<システム>が見つかりました（下方向スクロールあり）")
                }
            }
            case(3) {
                expectation {
                    it.canDetectWithScrollUp("設定")
                        .thisIsTrue("<設定>が見つかりました（上方向スクロールあり）")
                }
            }
            case(4) {
                expectation {
                    withScrollDown {
                        it.canDetectAll("設定", "システム")
                            .thisIsTrue("<設定>が見つかりました（下方向スクロールあり）")
                    }
                }
            }
            case(5) {
                expectation {
                    withScrollUp {
                        it.canDetectAll("システム", "設定")
                            .thisIsTrue("<設定>が見つかりました（上方向スクロールあり）")
                    }
                }
            }
        }
    }

    @Test
    @Order(20)
    fun canDetect_true() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.canDetect("ネットワークとインターネット")
                        .thisIsTrue(message = "canDetect(\"ネットワークとインターネット\") is true")
                }
            }
        }
    }

    @Test
    @Order(30)
    fun canDetect_false() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.canDetect("ネットワークビジネス")
                        .thisIsFalse("canDetect(\"ネットワークビジネス\") is false")
                }
            }
        }
    }

    @Test
    @Order(40)
    fun canDetectWithScrollDown_true() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.canDetectWithScrollDown("システム")
                        .thisIsTrue("canDetectWithScrollDown(\"システム\") is true")
                }
            }
        }
    }

    @Test
    @Order(50)
    fun canDetectWithScrollDown_false() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.canDetectWithScrollDown("ネットワークビジネス")
                        .thisIsFalse("canDetectWithScrollDown(\"ネットワークビジネス\") is false")
                }
            }
        }
    }

    @Test
    @Order(60)
    fun canDetectWithScrollUp_true() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                        .flickBottomToTop()
                }.expectation {
                    it.canDetectWithScrollUp("ネットワークとインターネット")
                        .thisIsTrue("canDetectWithScrollUp(\"Netowork & internet\") is true")
                }
            }
        }
    }

    @Test
    @Order(70)
    fun canDetectWithScrollUp_false() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                        .flickBottomToTop()
                }.expectation {
                    it.canDetectWithScrollUp("ネットワークビジネス")
                        .thisIsFalse("canDetectWithScrollUp(\"ネットワークビジネス\") is false")
                }
            }
        }
    }

}