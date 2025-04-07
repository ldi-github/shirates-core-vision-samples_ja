package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class AssertingText1 : VisionTest() {

    @Test
    @Order(10)
    fun belowTextIs_aboveTextIs() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    it.detect("ネットワークとインターネット")
                }.expectation {
                    it.textIs("ネットワークとインターネット")
                        .belowTextIs("モバイル、Wi-Fi、アクセスポイント")
                        .aboveTextIs("ネットワークとインターネット")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun rightTextIs_leftTextIs() {

        scenario {
            case(1) {
                condition {
                    it.pressHome()
                        .screenIs("[Androidホーム画面]")
                }.action {
                    it.detect("Play ストア")
                }.expectation {
                    it.textIs("Play ストア")
                        .rightTextIs("Gmail")
                        .leftTextIs("Play ストア")
                }
            }
        }
    }

    @Test
    @Order(30)
    fun textIs_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    it.detect("ネットワークとインターネット")
                }.expectation {
                    it.textIs("接続設定")
                }
            }
        }
    }

}