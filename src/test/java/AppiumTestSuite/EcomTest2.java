package AppiumTestSuite;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class EcomTest2 extends Utilities{
    @Test
    public void EcomAddProducts() throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Krishna R");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/text1\' and @text=\'Argentina\']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        driver.findElements(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])")).get(0).click();
        driver.findElements(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])")).get(0).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));

        //int productPrices=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
        List<WebElement> productPrices=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        int count=productPrices.size();
        double sum=0;
        for(int i=0;i<count;i++){
            String amtStr=productPrices.get(i).getText();
            double price =Double.parseDouble(amtStr.substring(1));
            sum=price+sum;
        }
       double cartValue= Double.parseDouble(driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(1));
        Assert.assertEquals(sum,cartValue);
        WebElement tnc=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        longPressAction(tnc);
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(5000);

    }

}
