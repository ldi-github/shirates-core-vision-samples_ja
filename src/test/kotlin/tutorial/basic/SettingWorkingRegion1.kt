package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.logging.printInfo
import shirates.core.utility.time.StopWatch
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class SettingWorkingRegion1 : VisionTest() {

    @Test
    @Order(10)
    fun settingWorkingRegion() {

        scenario {
            case(1) {
                condition {
                    it.screenIs("[Android設定トップ画面]")
                }.expectation {
                    onTopRegion(topRate = 0.35) {
                        it.exist("設定を検索")
                        it.dontExist("ストレージ")
                    }
                }
            }
            case(2) {
                expectation {
                    onBottomRegion {
                        it.dontExist("設定を検索")
                        it.exist("ストレージ")
                    }
                }
            }
            case(3) {
                expectation {
                    onMiddleRegion(upperRate = 0.1, lowerRate = 0.2) {
                        it.dontExist("設定を検索")
                        it.exist("アプリ")
                        it.exist("通知")
                    }
                }
            }
            case(4) {
                expectation {
                    val v = detect("設定を検索")
                    val r = v.rect
                    onRegion(left = r.left, top = r.top, right = r.right, bottom = r.bottom) {
                        it.exist("設定を検索")
                    }
                }
            }
            case(5) {
                expectation {
                    onUpperHalfRegion {
                        it.exist("設定を検索")
                        it.dontExist("ストレージ")
                    }
                }
            }
            case(6) {
                expectation {
                    onLowerHalfRegion {
                        it.dontExist("設定を検索")
                        it.exist("ストレージ")
                    }
                }
            }
            case(7) {
                expectation {
                    onLeftHalfRegion {
                        it.existImage("[ネットワークとインターネットアイコン]")
                    }
                }
            }
            case(8) {
                expectation {
                    onRightHalfRegion {
                        it.dontExistImage("[ネットワークとインターネットアイコン]")
                    }
                }
            }
        }
    }

    @Test
    @Order(20)
    fun measureTime() {

        scenario {
            case(1) {
                condition {
                    it.screenIs("[Android設定トップ画面]")
                }.action {
                    val sw = StopWatch("全画面")
                    it.findImage("[ネットワークとインターネットアイコン]")
                    s1 = "全画面:             ${sw.elapsedSeconds} sec"
                }
            }
            case(2) {
                action {
                    val sw = StopWatch("onUpperHalfRegion")
                    onUpperHalfRegion {
                        it.findImage("[ネットワークとインターネットアイコン]")
                    }
                    s2 = "onUpperHalfRegion: ${sw.elapsedSeconds} sec"
                }
            }
            case(3) {
                action {
                    val sw = StopWatch("onBottomRegion")
                    onBottomRegion {
                        it.findImage("[音とバイブレーションアイコン]")
                    }
                    s3 = "onBottomRegion:    ${sw.elapsedSeconds} sec"
                }
            }

            printInfo(s1)
            printInfo(s2)
            printInfo(s3)
        }
    }

}