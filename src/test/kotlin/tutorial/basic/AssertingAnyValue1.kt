package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.commandextension.*
import shirates.core.utility.toDate
import shirates.core.vision.driver.commandextension.detect
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.driver.isApp
import shirates.core.vision.testcode.VisionTest
import java.util.*

class AssertingAnyValue1 : VisionTest() {

    @Test
    @Order(10)
    fun anyAssertion() {

        scenario {
            case(1, "Int") {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    123.thisIs(123)
                    123.thisIsNot(456)
                }
            }
            case(2, "Date") {
                action {
                    d1 = "2025/1/1".toDate()
                    d2 = "2025/1/1".toDate()
                    d3 = "2025/1/2".toDate()
                }.expectation {
                    d1.thisIs(d1, "d1 is d1")
                    d1.thisIs(d2, "d1 is d2")
                    d1.thisIsNot(d3, "d1 is not d3")
                }
            }
            case(3, "VisionElement") {
                action {
                    v1 = detect("アプリ")
                    v2 = detect("アプリ")
                    v3 = detect("通知")
                }.expectation {
                    v1.thisIs(v1, "v1 is v1")   // OK
                    v1.thisIs(v2, "v1 is v2")   // OK
                    v1.thisIsNot(v3, "v1 is not v3") // OK
                    v2.thisIs(v3, "v2 is v3")   // NG
                }
            }
        }
    }

    @Test
    @Order(20)
    fun stringAssertion_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    "string1"
                        .thisIs("string1")
                        .thisIsNot("string2")

                        .thisStartsWith("s")
                        .thisStartsWithNot("t")

                        .thisContains("ring")
                        .thisContainsNot("square")

                        .thisEndsWith("ring1")
                        .thisEndsWithNot("ring2")

                        .thisMatches("^str.*")
                        .thisMatchesNot("^tex.*")
                }
            }

            case(2) {
                expectation {
                    "".thisIsEmpty()
                    "hoge".thisIsNotEmpty()

                    " ".thisIsBlank()
                    "hoge".thisIsNotBlank()
                }
            }

        }
    }

    @Test
    @Order(30)
    fun stringAssertion_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    "string1"
                        .thisContains("square")
                }
            }
        }
    }

    @Test
    @Order(40)
    fun booleanAssertion_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    true.thisIsTrue()
                    false.thisIsFalse()

                    true.thisIsTrue("The value is true")
                    false.thisIsFalse("The value is false")
                }
            }
            case(2) {
                expectation {
                    it.isApp("Settings")
                        .thisIsTrue("This app is <Settings>")
                    it.isApp("Chrome")
                        .thisIsFalse("This app is not <Chrome>")
                }
            }
        }
    }

    @Test
    @Order(50)
    fun booleanAssertion_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    false.thisIsTrue()
                }
            }
        }
    }

    @Test
    @Order(60)
    fun dateFormatAssertion_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    "2023/12/15".thisMatchesDateFormat("yyyy/MM/dd")
                }
            }
            case(2) {
                condition {
                    if (Locale.getDefault().toString() != "ja_JP") {
                        SKIP_CASE()
                    }
                }.expectation {
                    "2023/12/15(金)".thisMatchesDateFormat("yyyy/MM/dd(E)")
                }
            }
        }
    }

    @Test
    @Order(70)
    fun dateFormatAssertion_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android設定トップ画面]")
                }.expectation {
                    "2023/12/15".thisMatchesDateFormat("yyyy.MM.dd")
                }
            }
        }
    }

}