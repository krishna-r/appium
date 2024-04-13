package AppiumTestSuite;

import com.beust.ah.A;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class iOSScrollTest extends iOSUtilities{
    @Test
    public void scrollTest(){
        WebElement ele=driver.findElement(AppiumBy.accessibilityId("Web View"));
        Map<String,Object> parms=new HashMap<>();
        parms.put("direction","down");
        parms.put("element",((RemoteWebElement)ele).getId());
        driver.executeScript("mobile:scroll",parms);
        driver.findElement(AppiumBy.accessibilityId("Web View")).click();
        driver.findElement(By.className("XCUIElementTypeButton")).click();
        driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
        driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("30");
        driver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("220");
        driver.findElement(AppiumBy.accessibilityId("Blue color component value")).sendKeys("105");
        Assert.assertEquals( driver.findElement(AppiumBy.accessibilityId("Blue color component value")).getText(),"105");


    }
}
