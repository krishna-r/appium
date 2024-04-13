package AppiumTestSuite;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class iOSLongPress extends iOSUtilities{
    @Test
    public void longPress(){
        driver.findElement(AppiumBy.accessibilityId("Steppers")).click();
       WebElement WebEle=driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'Increment'`][3]"));
       Map<String,Object> params=new HashMap<>();
       params.put("element",((RemoteWebElement)WebEle).getId());
       params.put("duration",5);
       driver.executeScript("mobile:touchAndHold",params);

    }
}
