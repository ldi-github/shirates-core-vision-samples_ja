package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class ExistImageDontExistImage1 : VisionTest() {

    @Test
    @Order(10)
    fun existImage_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.existImage("[アプリアイコン]")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun withScrollDown_existImage_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    withScrollDown {
                        it.existImage("[システムアイコン]")
                    }
                }
            }
        }
    }

    @Test
    @Order(30)
    fun withScrollDown_existImage_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                        .existImage("[ネットワークとインターネットアイコン]")
                        .scrollDown()
                }.expectation {
                    withScrollDown {
                        it.existImage("[ネットワークとインターネットアイコン]")
                    }
                }
            }
        }
    }

    @Test
    @Order(40)
    fun withScrollDown_existImageWithoutScroll_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    withScrollDown {
                        it.existImageWithoutScroll("[ネットワークとインターネットアイコン]")     // OK
                        it.existImageWithoutScroll("[システムアイコン]")     // NG
                    }
                }
            }
        }
    }

    @Test
    @Order(40)
    fun dontExistImage_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    it.dontExistImage("[システムアイコン]")
                }
            }
        }
    }

    @Test
    @Order(40)
    fun withScrollDown_dontExistImage_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    withScrollDown {
                        it.dontExistImage("[VPNアイコン]")
                    }
                }
            }
        }
    }

    @Test
    @Order(50)
    fun withScrollDown_dontExistImage_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    withScrollDown {
                        it.dontExistImage("[システムアイコン]")
                    }
                }
            }
        }
    }

    @Test
    @Order(60)
    fun withScrollDown_dontExistImageWithoutScroll_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    withScrollDown {
                        it.dontExistWithoutScroll("ユーザー補助")    // OK
                        it.dontExistWithoutScroll("通知")    // NG
                    }
                }
            }
        }
    }

}