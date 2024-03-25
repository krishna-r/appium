package AppiumTestSuite;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeAction extends Utilities{
    @Test
    public void SwipeLeftAction(){
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Photos']")).click();
        String focus=driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable");
        WebElement FirstImg=driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));

        Assert.assertEquals("true",focus);
        swipeAction(FirstImg,"left");
        swipeAction(FirstImg,"left");
        swipeAction(FirstImg,"left");
        swipeAction(FirstImg,"right");
        swipeAction(FirstImg,"right");




    }
}
