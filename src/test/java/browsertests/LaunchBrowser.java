package browsertests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LaunchBrowser
{
    private WebDriver driver;

    @Test
    public void loadingSinglePageTest() throws Exception{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "4.4.4");
        capabilities.setCapability("deviceName", "sagarcell");
        capabilities.setCapability("browserName", "MobileBrowserType.BROWSER");
        capabilities.setCapability("app", "chrome");
        //capabilities.setCapability("browserName", "Chrome");

        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities) {
        };
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://www.comparethemarket.com.au/");
        driver.findElement(By.xpath("//span[text()='Compare Now']")).click();
        WebElement element =  driver.findElement(By.id("health_situation_healthCvr"));
        Select select = new Select(element);
        //select couple ..
        select.selectByVisibleText("Couple");
        driver.quit();
        //quit the browser
    }
}