package AppiumTestSuite;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class iOSslider extends iOSUtilities{
    @Test
    public void slider(){
        driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Sliders'")).click();
        WebElement slider=driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`value == '42%'`]"));
        slider.sendKeys("0.1%");
        //Assert.assertEquals("10%",slider.getAttribute("value"));
    }
}
