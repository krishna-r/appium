package AppiumTestSuite;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class iOSBaseTest extends iOSUtilities {
    @Test
    public void baseTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
        //driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Text Entry']")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label =='Text Entry'`]")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("chess master");
        driver.findElement(AppiumBy.accessibilityId("OK")).click();
        driver.findElement(AppiumBy.iOSNsPredicateString("type='XCUIElementTypeStaticText' AND value='Confirm / Cancel'")).click();
        String logger=driver.findElement(AppiumBy.iOSNsPredicateString("name BEGINSWITH 'A message'")).getText();
        driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Confirm'")).click();
        System.out.println("=====>"+logger);

    }
}
