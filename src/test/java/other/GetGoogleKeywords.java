package other;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetGoogleKeywords {


    public static void main(String[] args) throws Exception {

        WebDriver driver = null;

        System.setProperty("webdriver.chrome.driver", "F:\\selenium\\chromedriver2.2\\chromedriver.exe");
        System.out.println(System.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();

        // driver = new ChromeDriver(DesiredCapabilities.chrome());      driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        try {

            driver.get("https://www.google.co.in/preferences?hl=en-IN&fg=1");
            driver.findElement(By.xpath("//div[text()='Never show Instant results.']")).click();
            driver.findElement(By.xpath("//div[text()='Save']")).click();

            driver.get("https://www.google.co.in");

//String x = driver.switchTo().frame(0).switchTo().frame(0).findElement(By.tagName("h3")).getText();//String x = driver.switchTo().frame(1).findElement(By.tagName("h3")).getText();//String x = driver.switchTo().frame("view").switchTo().frame(0).getPageSource();//System.out.println(x);
            String str = "firefox";
            str = str.toLowerCase();
            String sub = "How to";
            String d = "";

            for (int i = 1; i <= 26; i++)

            {
                char x = (char) (64 + i);

//                driver.findElement(By.cssSelector("input[name=q]")).sendKeys(str + x);
//                List<WebElement> tr = driver.findElements(By.xpath("//table[@class='gssb_m']//tr"));
//
//                for (int co = 0; co < tr.size(); co = co + 2) {
//
//                    d = d + tr.get(co).getText() + "\r\n";
//                }

                driver.findElement(By.cssSelector("input[name=q]")).sendKeys(str + " " + sub + " " + x);
                List<WebElement> li = driver.findElements(By.xpath("//ul[@role='listbox']//li"));

                for (int co = 0; co < li.size(); co++) {
                    d = d + li.get(co).getText().replace(str,"").replace("how","How").trim() + " in " + str  + "\r\n";
                }


                driver.findElement(By.id("lst-ib")).clear();

            }

            System.out.println(d);
            String filePath = "f:\\videos\\" + str + ".txt";

            if ((new File(filePath)).exists())
                (new File(filePath)).delete();


            File temp = new File(filePath);
            FileWriter fw = new FileWriter(temp, true);
            fw.append(d);
            fw.close();


            Thread.sleep(4000);
            //driver.navigate();//driver.navigate("http://www.google.com");      }catch(Exception e){

            //System.out.println(e.getLocalizedMessage());                  e.printStackTrace(new PrintStream(System.out));

        } finally {
            driver.close();
            driver.quit();
        }


    }


}
