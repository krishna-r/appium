package AppiumTestSuite;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragDropAction extends Utilities{
    @Test
   public void drag(){
       driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();
       driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
       WebElement source=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
       int endX= 706;
       int endY= 649;
       dragAndDropAction(source,endX,endY);

   }
}
