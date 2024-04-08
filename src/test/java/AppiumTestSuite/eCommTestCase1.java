package AppiumTestSuite;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class eCommTestCase1 extends Utilities {
    @Test
    public void fillForm(){
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Krishna R");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/text1\' and @text=\'Argentina\']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
       // String ToastMsg=driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        //Assert.assertEquals(ToastMsg,"Please enter your namegf");
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
        driver.findElement(By.xpath("(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[1]")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));



    }
}
