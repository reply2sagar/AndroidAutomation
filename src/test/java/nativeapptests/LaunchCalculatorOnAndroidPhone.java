package nativeapptests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LaunchCalculatorOnAndroidPhone
{
    private WebDriver driver;

    @Test
    public void loadingSinglePageTest() throws Exception{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "4.4.4");
        capabilities.setCapability("deviceName", "sagarcell");
        capabilities.setCapability("browser_Name", "Android");
       // capabilities.setCapability("app", "chrome");
        capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        capabilities.setCapability("appActivity","com.sec.android.app.popupcalculator.Calculator");
        //capabilities.setCapability("browserName", "Chrome");

        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities) {
        };
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.name("2")).click();

        driver.findElement(By.name("+")).click();

        driver.findElement(By.name("6")).click();

        driver.findElement(By.name("=")).click();
        WebElement txt= driver.findElement(By.className("android.widget.EditText"));

        String p = txt.getText();
        String replacement = p.replaceAll("\t|\n|\r", "");
        Assert.assertTrue("",replacement.equalsIgnoreCase("2+6=8"));
        driver.quit();
        //quit the browser
    }
}