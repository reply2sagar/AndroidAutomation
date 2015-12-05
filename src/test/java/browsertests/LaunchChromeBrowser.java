package browsertests;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class LaunchChromeBrowser
{
    private WebDriver driver;

    @Test
    public void loadingSinglePageTest() throws Exception{
        DesiredCapabilities  capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Sagarcell");
        capabilities.setCapability("app", "Chrome");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability(CapabilityType.VERSION, "4.4.4");
        capabilities.setCapability(CapabilityType.PLATFORM, "Android");
        WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.get("http://www.yahoo.com");
    }
}