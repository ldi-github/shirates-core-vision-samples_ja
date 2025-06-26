package demo.vision

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import shirates.core.testcode.ios
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

@ios
class iOSSettingsVisionDemo : VisionTest() {

    @Test
    @DisplayName("<次回起動時にローカルデータをリセット>が[デベロッパ画面]に存在すること")
    fun s10() {

        scenario {
            case(1) {
                condition {
                    it.screenIs("[iOS設定トップ画面]")
                }.action {
                    it.tapWithScrollDown("デベロッパ")
                }.expectation {
                    it.screenIs("[デベロッパ画面]")
                }
            }
            case(2) {
                expectation {
                    it.existWithScrollDown("次回起動時にローカルデータを*")
                }
            }

        }
    }

    @Test
    @DisplayName("[情報画面]のiOSバージョンと機種名を検証する")
    fun s20() {

        scenario {
            case(1) {
                condition {
                    it.screenIs("[iOS設定トップ画面]")
                }.expectation {
                    it.exist("一般")
                }
            }
            case(2) {
                action {
                    it.tap("一般")
                }.expectation {
                    it.screenIs("[一般画面]")
                        .exist("情報")
                }
            }
            case(3) {
                action {
                    it.tap("情報")
                }.expectation {
                    it.screenIs("[情報画面]")
                        .detect("iOSバージョン").rightTextIs("18.0*")
                        .detect("機種名").rightTextIs("iPhone 16", message = "[機種名]は'iPhone 16'です")
                }
            }
        }
    }

}