package hybridtests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by sagar on 13-12-2015.
 */
public class LaunchMathQ {
    //desired_caps['appPackage'] = 'com.google.android.youtube'
    private AndroidDriver driver;
@Test
public void test() throws Exception {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("platformVersion", "4.4.4");
    capabilities.setCapability("deviceName", "sagarcell");

    capabilities.setCapability("browser_Name", "Android");

    //capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");

    capabilities.setCapability("appPackage", "com.mindtricksdev.mathiq");
    capabilities.setCapability("appActivity","com.appgyver.runtime.standalone.chromium.MainActivity");

    //class - android.widget.FrameLayout

    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities) {
    };
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    //get contexts
    for (Object contextName : driver.getContextHandles()) {
        System.out.println(contextName);
        if (contextName.toString().contains("WEBVIEW")){
            driver.context(contextName.toString());
            System.out.println("Switched to " + contextName);
        }
    }
    //driver.switchTo().("http://www.softpost.org");
    driver.quit();
}
}
