package AppiumTestSuite;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class ScrollAction extends Utilities {
    @Test
           public void scrollAction(){
               driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();
              scrollToEndAction(); // not working
               scrollToFind();



    }

}
