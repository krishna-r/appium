package AppiumTestSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class MobileBrowserUtility {
    public AndroidDriver driver;
    AppiumDriverLocalService service;
    @BeforeClass
    public void mobileStartup() throws URISyntaxException, MalformedURLException {
        String AppiumServerIP="127.0.0.1";
        int AppiumServerPort=4723;
        String AppiumServerURL="http://"+AppiumServerIP+":"+AppiumServerPort;
        String AndroidDeviceName="Pixel";
      //  String AndroidAppName="E:\\appium\\AppiumAutomation\\src\\test\\java\\resources\\General-Store.apk";
        String appiumNodeModule="C:\\Users\\krishna\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";

        service = new AppiumServiceBuilder().withAppiumJS(new File(appiumNodeModule)).withIPAddress(AppiumServerIP).usingPort(AppiumServerPort).build();
        service.start();
        UiAutomator2Options options=new UiAutomator2Options();
        options.setDeviceName(AndroidDeviceName);
       // options.setApp(AndroidAppName);
        options.setChromedriverExecutable("C:\\Users\\krishna\\Downloads\\chromedriver.exe");
        options.setCapability("browserName","Chrome");
        driver=new AndroidDriver(new URI(AppiumServerURL).toURL(),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public void shutdownDriverAndAppiumServer() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
        service.stop();
    }
}
