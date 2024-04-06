package AppiumTestSuite;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
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
import java.time.Duration;

public class Utilities {
    public AndroidDriver driver;
    AppiumDriverLocalService service;
    @BeforeClass
    public void Startup() throws URISyntaxException, MalformedURLException {
        String AppiumServerIP="127.0.0.1";
        int AppiumServerPort=4764;
        String AppiumServerURL="http://"+AppiumServerIP+":"+AppiumServerPort;
        String AndroidDeviceName="Pixel";
        String AndroidAppName="E:\\appium\\AppiumAutomation\\src\\test\\java\\resources\\General-Store.apk";
        String appiumNodeModule="C:\\Users\\krishna\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";

        service = new AppiumServiceBuilder().withAppiumJS(new File(appiumNodeModule)).withIPAddress(AppiumServerIP).usingPort(AppiumServerPort).build();
        service.start();
        UiAutomator2Options options=new UiAutomator2Options();
        options.setDeviceName(AndroidDeviceName);
        options.setApp(AndroidAppName);
        driver=new AndroidDriver(new URI(AppiumServerURL).toURL(),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // global wait
    }
    @AfterClass
    public void shutdown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
        service.stop();
    }

    public void longPressAction(WebElement ele) {
        ( (JavascriptExecutor)driver).executeScript("mobile:longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));

    }
    public void scrollToEndAction(){
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 10.0
            ));
        }while(canScrollMore);
    }
    public void scrollToFind(){
        //when we know what to find
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
    }
    public void swipeAction(WebElement ele,String direction){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)ele).getId(),
                "direction", direction,
                "percent", 0.01
        ));
    }
    public void dragAndDropAction( WebElement source, int endX, int endY){

        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) source).getId(),
                "endX", endX,
                "endY", endY
        ));
        String DragStatus=driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(DragStatus,"Dropped!");

    }
    public void rotateRHS90(String orientation){
        switch (orientation){
            case "clokwise":
                DeviceRotation landScape=new DeviceRotation(0,0,90);
                driver.rotate(landScape);
                break;
            case "antiClokWise":
                DeviceRotation landScape1=new DeviceRotation(0,0,270);
                driver.rotate(landScape1);
                break;
            case "upsideDown":
                DeviceRotation landScape2=new DeviceRotation(0,0,180);
                driver.rotate(landScape2);
                break;
        }

    }
    public void setTextToClipBoard(String ClipText){
        driver.setClipboardText(ClipText);

    }
    public void GoToActivity(String appAndActivityID){
        ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
                "intent",appAndActivityID
        ));
    }

}
