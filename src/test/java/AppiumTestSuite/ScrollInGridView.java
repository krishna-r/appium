package AppiumTestSuite;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ScrollInGridView extends Utilities{
    String formatter="\n==========================>";

    public void LoginPage(){
        System.out.println("Doing login"+formatter);
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Krishna R");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\'android:id/text1\' and @text=\'Argentina\']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        System.out.println("Log in successful"+formatter);

    }
    @Test
    public void ScrollAndAddToCart(){
           LoginPage();
        System.out.println("Searching Jordan 6 Rings by scrolling"+formatter);
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
        int productsNos=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        List<WebElement> p=driver.findElements(By.id("com.androidsample.generalstore:id/productName"));

        ArrayList<String> ProductNames=new ArrayList<>();

        System.out.println("Number of Products: "+productsNos+""+formatter);
        for (int i = 0; i < productsNos; i++) {

            String product=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            //System.out.println("Adding: "+product);
            ProductNames.add(product);

        }
        for (int i = 0; i < ProductNames.size(); i++) {
            String pr="Jordan 6 Rings";
            //System.out.println(ProductNames.get(i).toString());
            if(pr.equals( (ProductNames.get(i))) ){
                System.out.println("Adding "+ProductNames.get(i)+" in cart");
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Going to Cart Page"+formatter);
       driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
       WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
       wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));



    }
}
