package AppiumTestSuite;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Hybrid extends EcomTest2{
    @Test
   public void hybridTest() throws InterruptedException {
       EcomAddProducts();
       Thread.sleep(10000);
       Set<String> contexthandles=driver.getContextHandles();
       for(String i:contexthandles){
           System.out.println(i);
       }
        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.name("q")).sendKeys("Krishna Rathod");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);

    }
}
