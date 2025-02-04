package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class ExistDontExist1 : VisionTest() {

    @Test
    @Order(10)
    fun exist_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.exist("ネットワークとインターネット")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun exist_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.exist("システム")
                }
            }
        }
    }

    @Test
    @Order(30)
    fun existWithScrollDown_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.existWithScrollDown("システム")
                }
            }
        }
    }

    @Test
    @Order(40)
    fun existWithScrollDown_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.existWithScrollDown("ネットワークビジネス")
                }
            }
        }
    }

    @Test
    @Order(50)
    fun existWithScrollUp_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                        .flickAndGoDown()
                }.expectation {
                    it.existWithScrollUp("ネットワークとインターネット")
                }
            }
        }
    }

    @Test
    @Order(60)
    fun existWithScrollUp_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                        .flickAndGoDown()
                }.expectation {
                    it.existWithScrollUp("ネットワークビジネス")
                }
            }
        }
    }

    @Test
    @Order(70)
    fun dontExist_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.dontExist("システム")
                }
            }
        }
    }

    @Test
    @Order(80)
    fun dontExist_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.dontExist("ネットワークとインターネット")
                }
            }
        }
    }

    @Test
    @Order(90)
    fun withScrollDown_dontExist_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    withScrollDown {
                        it.dontExist("ネットワークビジネス")
                    }
                }
            }
        }
    }

    @Test
    @Order(100)
    fun withScrollDown_dontExist_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    withScrollDown {
                        it.dontExist("システム")
                    }
                }
            }
        }
    }

    @Test
    @Order(110)
    fun dontExistWithScrollUp_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                        .flickAndGoDown()
                }.expectation {
                    withScrollUp {
                        it.dontExist("ネットワークビジネス")
                    }
                }
            }
        }
    }

    @Test
    @Order(120)
    fun dontExistWithScrollUp_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                        .flickAndGoDown()
                }.expectation {
                    withScrollUp {
                        it.dontExist("システム")
                    }
                }
            }
        }
    }

    @Test
    @Order(130)
    fun withScrollDown_existWithoutScroll_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    withScrollDown {
                        it.existWithoutScroll("ネットワークとインターネット")    // OK
                        it.existWithoutScroll("システム")    // NG
                    }
                }
            }
        }
    }

    @Test
    @Order(140)
    fun withScrollUp_dontExistWithoutScroll_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                        .flickAndGoDown()
                }.expectation {
                    withScrollUp {
                        it.dontExistWithoutScroll("ディスプレイ")    // OK
                        it.dontExistWithoutScroll("システム")    // NG
                    }
                }
            }
        }
    }

}