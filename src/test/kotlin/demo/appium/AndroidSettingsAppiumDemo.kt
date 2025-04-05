package demo.appium

import io.appium.java_client.android.AndroidDriver
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.OutputType
import org.openqa.selenium.remote.DesiredCapabilities
import shirates.core.testcode.android
import shirates.core.utility.format
import java.io.File
import java.net.URI
import java.util.*

@android
class AndroidSettingsAppiumDemo {

    private fun getDriver(): AndroidDriver {

        val caps = DesiredCapabilities()
        with(caps) {
            setCapability("appium:automationName", "UiAutomator2")
            setCapability("platformName", "Android")
            setCapability("appium:platformVersion", "14")
            setCapability("appium:language", "ja")
            setCapability("appium:locale", "JP")
            setCapability("appium:appPackage", "com.android.settings")
            setCapability("appium:appActivity", "com.android.settings.Settings")
        }
        val driver = AndroidDriver(URI("http://127.0.0.1:4723/").toURL(), caps)
        driver.setSetting("enforceXPath1", true)

        return driver
    }

    private fun AndroidDriver.screenshot() {

        val d = this
        val sc = d.getScreenshotAs(OutputType.FILE)
        val path = System.getProperty("user.home") + "/Downloads/${Date().format("yyyyMMddHHmmssSSS")}.png"
        sc.copyTo(File(path))
    }

    @Test
    fun airplaneModeSwitch() {

        val d = getDriver()

        // case(1)
        var e = d.findElement(By.ByXPath("//*[@text='ネットワークとインターネット']"))
        println("'ネットワークとインターネット'が表示されました。")
        d.screenshot()

        println("'ネットワークとインターネット'をタップします。")
        e.click()
        Thread.sleep(2000)
        e = d.findElement(By.ById("android:id/switch_widget"))
        println("ネットワークとインターネット画面が表示されました。")
        d.screenshot()

        // case(2)
        if (e.getAttribute("checked") == "false") {
            println("機内モードのスイッチはOFFです。")
        } else {
            throw IllegalStateException("機内モードのスイッチがOFFではありません。")
        }

        println("機内モードのスイッチをタップします。")
        e.click()
        Thread.sleep(2000)
        e = d.findElement(By.ById("android:id/switch_widget"))
        d.screenshot()
        if (e.getAttribute("checked") == "true") {
            println("機内モードのスイッチはONです。")
        } else {
            throw IllegalStateException("機内モードのスイッチがONになりませんでした。")
        }

        // case(3)
        println("機内モードのスイッチをタップします。")
        e = d.findElement(By.ById("android:id/switch_widget"))
        e.click()
        Thread.sleep(2000)
        e = d.findElement(By.ById("android:id/switch_widget"))
        d.screenshot()
        if (e.getAttribute("checked") == "false") {
            println("機内モードのスイッチはOFFです。")
        } else {
            throw IllegalStateException("機内モードのスイッチがOFFになりませんでした。")
        }
    }

}