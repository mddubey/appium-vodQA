import io.appium.java_client.MobileBy;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;

/**
 * Created by mritunjd on 06/01/18.
 */
public class TestClassTest {

    private AndroidDriver driver;
    private IOSDriver iosDriver;

    @Test
    public void basicAndroidCaps() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.APP,
                "/Users/mritunjd/Documents/my-workspace/practice/AppiumSample/VodQA.apk");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Test");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(3000);
    }

    @Test
    public void nativeAndroidCaps() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.settings");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.settings.Settings");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Test");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(3000);
    }

    @Test
    public void basicIOSCaps() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "11.0");
//        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.2");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        caps.setCapability(MobileCapabilityType.APP,
                "/Users/mritunjd/Documents/my-workspace/practice/AppiumSample/VodQA.zip");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        iosDriver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(3000);
    }

    @Test
    public void basicAndroidCapsLogin() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.APP,
                "/Users/mritunjd/Documents/my-workspace/practice/AppiumSample/VodQA.apk");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Test");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(3000);

        WebElement userName = driver.findElementByAccessibilityId("username");
        userName.clear();
        userName.sendKeys("admin");
        driver.hideKeyboard();
        Thread.sleep(1000);

        WebElement password = driver.findElementByAccessibilityId("password");
        password.clear();
        password.sendKeys("admin");
        driver.hideKeyboard();
        Thread.sleep(1000);

        driver.findElementByAccessibilityId("login").click();
        Thread.sleep(2000);
    }

    @Test
    public void iosCapabilitiesUsingID() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "11.0");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        caps.setCapability(MobileCapabilityType.APP,
                "/Users/mritunjd/Documents/my-workspace/practice/AppiumSample/VodQA.zip");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        iosDriver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(1000);

        WebElement userName = iosDriver.findElementByAccessibilityId("username");
        userName.clear();
        userName.sendKeys("admin");

        WebElement password = iosDriver.findElementByAccessibilityId("password");
        password.clear();
        password.sendKeys("admin");

        iosDriver.findElementByAccessibilityId("login").click();
        Thread.sleep(1000);
    }

    @Test
    public void iosCapabilitiesUsingPredicates() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "11.0");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        caps.setCapability(MobileCapabilityType.APP,
                "/Users/mritunjd/Documents/my-workspace/practice/AppiumSample/VodQA.zip");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        iosDriver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(1000);

        iosDriver.findElementByAccessibilityId("login").click();
        Thread.sleep(1000);
        iosDriver.findElement(MobileBy.iOSNsPredicateString("name BEGINSWITH 'slide'")).click();
        Thread.sleep(2000);
    }

    @Test
    public void iosCapabilitiesSliderMovement() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "11.0");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        caps.setCapability(MobileCapabilityType.APP,
                "/Users/mritunjd/Documents/my-workspace/practice/AppiumSample/VodQA.zip");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        iosDriver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(1000);

        iosDriver.findElementByAccessibilityId("login").click();
        Thread.sleep(1000);
        iosDriver.findElement(MobileBy.iOSNsPredicateString("name BEGINSWITH 'slide'")).click();
        Thread.sleep(2000);
    }

    @Test
    public void androidCapabilitiesSliderMovement() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.APP,
                "/Users/mritunjd/Documents/my-workspace/practice/AppiumSample/VodQA.apk");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Test");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(1000);

        driver.findElementByAccessibilityId("login").click();
        Thread.sleep(3000);
        driver.findElementByAccessibilityId("slider1").click();
        Thread.sleep(3000);
        WebElement slider = driver.findElementByAccessibilityId("slider1");
        Dimension d = slider.getSize();

        new TouchAction(driver)
                .press(ElementOption.element(slider).withCoordinates(0, d.getHeight() / 2))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(ElementOption.element(slider).withCoordinates(d.getWidth() / 2, d.getHeight() / 2))
                .release().perform();

        Thread.sleep(3000);
    }


    @Test
    public void androidCapabilitiesVerticalSwiping() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.APP,
                "/Users/mritunjd/Documents/my-workspace/practice/AppiumSample/VodQA.apk");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Test");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(1000);

        driver.findElementByAccessibilityId("login").click();
        Thread.sleep(3000);
        driver.findElementByAccessibilityId("verticalSwipe").click();
        Thread.sleep(3000);
        WebElement listview = driver.findElementByAccessibilityId("listview");
        Dimension d = listview.getSize();
        TouchAction touchAction = new TouchAction(driver);

        touchAction
                .press(ElementOption.element(listview).withCoordinates(d.getWidth() / 2, d.getHeight() / 2))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(ElementOption.element(listview).withCoordinates(d.getWidth() / 2, d.getHeight() / 4))
                .release().perform();

        Thread.sleep(3000);
    }

    @Test
    public void androidCapabilitiesDragAndDrop() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.APP,
                "/Users/mritunjd/Documents/my-workspace/practice/AppiumSample/VodQA.apk");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Test");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(1000);

        driver.findElementByAccessibilityId("login").click();
        Thread.sleep(3000);
        driver.findElementByAccessibilityId("dragAndDrop").click();
        Thread.sleep(3000);
        WebElement dragMe = driver.findElementByAccessibilityId("dragMe");
        Dimension dragMeSize = dragMe.getSize();
        WebElement dropzone = driver.findElementByAccessibilityId("dropzone");
        Dimension dropzoneSize = dropzone.getSize();

        TouchAction touchAction = new TouchAction(driver);

        touchAction
                .longPress(ElementOption.element(dragMe).withCoordinates(dragMeSize.getWidth() / 2, dragMeSize.getHeight() / 2))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(ElementOption.element(dropzone).withCoordinates(dropzoneSize.getWidth() / 2, dropzoneSize.getHeight() / 2))
                .release().perform();

        Thread.sleep(3000);

    }

    @Test
    public void androidCapabilitiesTwoSliderMovement() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.APP,
                "/Users/mritunjd/Documents/my-workspace/practice/AppiumSample/VodQA.apk");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Test");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        Thread.sleep(1000);

        driver.findElementByAccessibilityId("login").click();
        Thread.sleep(3000);
        driver.findElementByAccessibilityId("slider1").click();
        Thread.sleep(3000);

        WebElement slider = driver.findElementByAccessibilityId("slider");
        Dimension sliderSize = slider.getSize();

        WebElement slider1 = driver.findElementByAccessibilityId("slider1");
        Dimension slider1Size = slider1.getSize();

        TouchAction touchActionForSlider = new TouchAction(driver);
        touchActionForSlider
                .press(ElementOption.element(slider).withCoordinates(0, sliderSize.getHeight() / 2))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(ElementOption.element(slider).withCoordinates(sliderSize.getWidth()/2, slider1Size.getHeight() / 2));

        TouchAction touchActionForSlider1 = new TouchAction(driver);
        touchActionForSlider1
                .press(ElementOption.element(slider1).withCoordinates(0, slider1Size.getHeight() / 2))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(ElementOption.element(slider1).withCoordinates(slider1Size.getWidth(), slider1Size.getHeight() / 2));

        new MultiTouchAction(driver)
                .add(touchActionForSlider)
                .add(touchActionForSlider1)
                .perform();

        Thread.sleep(3000);
    }


    @AfterClass
    public void finish() {
        if (driver != null) {
            driver.quit();
        }
        if (iosDriver != null) {
            iosDriver.quit();
        }
    }
}
