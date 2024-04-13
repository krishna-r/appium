package AppiumTestSuite;
import com.beust.ah.A;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class iOSUtilities{
    AppiumDriverLocalService service;
    public IOSDriver driver;
    @BeforeClass
    public void iOSStartup() throws URISyntaxException, MalformedURLException {
        String AppiumServerIP="0.0.0.0";
        int AppiumServerPort=4724;
        String AppiumServerURL="http://"+AppiumServerIP+":"+AppiumServerPort;
        String appiumNodeModule="//usr//local//lib//node_modules//appium//build//lib//main.js";
        service = new AppiumServiceBuilder().withAppiumJS(new File(appiumNodeModule))
                  .withIPAddress(AppiumServerIP).usingPort(AppiumServerPort).build();
        service.start();

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 15");
        options.setPlatformVersion("17.4");
        options.setApp("//Users//krishna//Desktop//Workstation//UIKitCatalog.app");
        options.setNoReset(true);
        options.setWdaLaunchTimeout(Duration.ofSeconds(10));
        options.setAutomationName("XCUITest");
        driver = new IOSDriver(new URI(AppiumServerURL).toURL(),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public void shutdownDriverAndAppiumServer() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
        service.stop();
    }
}
