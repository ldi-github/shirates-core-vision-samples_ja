package demo.vision.gallery

import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.dontExist
import shirates.core.vision.driver.commandextension.exist
import shirates.core.vision.driver.commandextension.shell
import shirates.core.vision.testcode.VisionTest

class TextRecognitionTest : VisionTest() {

    @Test
    fun roadGuide() {

        scenario {
            case(1) {
                condition {
                    it.shell(
                        "adb",
                        "shell",
                        "am",
                        "start",
                        "-a",
                        "android.intent.action.VIEW",
                        "-d",
                        "https://upload.wikimedia.org/wikipedia/commons/e/ef/%E5%9B%BD%E9%81%93480%E5%8F%B7%E3%83%BB%E6%97%A7%E5%A6%B9%E8%83%8C%E6%A9%8B%E4%BB%98%E8%BF%91%E3%81%AE%E6%A1%88%E5%86%85%E6%A8%99%E8%AD%98.JPG",
                    )
                }.expectation {
                    it.exist("国道480号")
                        .exist("ROUTE 480")
                        .exist("高野山")
                        .exist("28km")
                        .exist("Koyasan")
                        .exist("橋本")
                        .exist("Hashimoto")
                        .exist("和歌山")
                        .exist("Wakayama")
                        .dontExist("東京")
                }
            }
        }
    }
}