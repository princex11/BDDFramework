package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseDemoBlaze {

   public static WebDriver driver;


   public void initSetUp(){
      System.setProperty("web-driver.chrome.driver", "chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().window().maximize();
   }

   public void closeBrowser(){
      driver.quit();
   }

}
