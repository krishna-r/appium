package AppiumTestSuite;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AutomateInbuiltApp extends iOSUtilitiesDefaultApps{
    @Test
    public void AutomateInbuiltApp() throws InterruptedException {
    Map<String,String> params=new HashMap<String,String>();
    params.put("bundleId","com.apple.mobileslideshow");
    driver.executeScript("mobile:launchApp",params);
    driver.findElement(AppiumBy.accessibilityId("rectangle.stack.fill")).click();
    driver.findElement(AppiumBy.iOSNsPredicateString("label == 'All Photos'")).click();
    int photos=driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).size();
    System.out.println("Total no of photos----->"+photos);
    driver.findElement(AppiumBy.xpath("//XCUIElementTypeCell[1]")).click();

    Map<String, Object> obj=new HashMap<String,Object>();
    obj.put("direction","left");
        int p=photos;
        String photoName;
    for (int i=0;i<photos;i++){
        driver.executeScript("mobile:swipe", obj);
        photoName=driver.findElement(AppiumBy.xpath("//XCUIElementTypeNavigationBar")).getAttribute("name");
        System.out.println(photoName);
        p--;
        Thread.sleep(1000);
    }
    driver.navigate().back();

}
}
