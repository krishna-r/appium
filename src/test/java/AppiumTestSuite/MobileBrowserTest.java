package AppiumTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class MobileBrowserTest extends MobileBrowserUtility{
    @Test
    public void browserTest() throws InterruptedException {
        driver.get("https://m.facebook.com/");
        driver.findElement(By.id("signup-button")).click();
        Thread.sleep(2000);

    }
}
