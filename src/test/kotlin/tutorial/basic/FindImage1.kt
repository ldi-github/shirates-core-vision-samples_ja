package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.commandextension.thisIsTrue
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class FindImage1 : VisionTest() {

    @Test
    @Order(10)
    fun findImage() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    withScrollDown {
                        v1 = it.findImage("[ネットワークとインターネットアイコン]")
                        v2 = it.findImage("[ディスプレイアイコン]")
                    }
                }.expectation {
                    v1.isFound.thisIsTrue("[ネットワークとインターネットアイコン] is found.")
                    v2.isFound.thisIsTrue("[ディスプレイアイコン] is found.")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun findImageWithScrollDown_findImageWithScrollUp() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.action {
                    v1 = findImageWithScrollDown("[位置情報アイコン]", threshold = 0.5)
                }.expectation {
                    v1.imageIs("[位置情報アイコン]")
                }
            }
            case(2) {
                action {
                    v1 = findImageWithScrollUp("[接続設定アイコン]")
                }.expectation {
                    v1.imageIs("[接続設定アイコン]")
                }
            }
        }
    }

    @Test
    @Order(30)
    fun findImageWithScrollRight_findImageWithScrollLeft() {

        scenario {
            case(1) {
                condition {
                    it.macro("[ファイルトップ画面]")
                }.action {
                    it.onLineOf("画像") {
                        v1 = findImageWithScrollRight("[今週ボタン]")
                    }
                }.expectation {
                    v1.imageIs("[今週ボタン]")
                }
            }
            case(2) {
                action {
                    v1.onLine {
                        v2 = findImageWithScrollLeft("[音声ボタン]")
                    }
                }.expectation {
                    v2.imageIs("[音声ボタン]")
                }
            }
        }
    }

}