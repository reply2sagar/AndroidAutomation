package browsertests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sagar on 06-12-2015.
 */
public class MobileEmulationOnChrome {
    @Test
            public void launchChrome() {
        Map<String, String> mobileEmulation = new HashMap<String, String>();
       // mobileEmulation.put("deviceName", "Google Nexus 5");
        mobileEmulation.put("deviceName", "Apple iPhone 5");
        //mobileEmulation.put("deviceName", "Apple iPad");
        Map<String, Object> chromeOptions = new HashMap<String, Object>();
        chromeOptions.put("mobileEmulation", mobileEmulation);

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        System.setProperty("webdriver.chrome.driver","G:\\softwares\\selenium\\chromedriver2.2.exe");

        WebDriver driver = new ChromeDriver(capabilities);
        driver.get("http://softpost.org");
        driver.quit();
    }
}
