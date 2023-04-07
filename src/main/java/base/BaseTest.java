package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    public static Properties prop = new Properties();
    public static Properties loc = new Properties();
    public static FileReader fr;
    public static FileReader fr_locators;

    @BeforeMethod
    public void setup() throws IOException {
        if(driver == null){
            System.out.println("The file path is" + System.getProperty("user.dir")); // this will give you directory of this project

             fr = new FileReader(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\config.properties");
             fr_locators = new FileReader(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\locators.properties");

            prop.load(fr);
            loc.load(fr_locators);
        }

        if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup(); // setup secript sp we can move to base classes
             driver = new ChromeDriver(); // object of webdriver
            driver.get(prop.getProperty("testURL"));

        }else if(prop.getProperty("browser").equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
             driver = new FirefoxDriver();
            driver.get(prop.getProperty("testURL"));
        }
    }

    @AfterMethod
    public void teardown(){
        driver.close();

    }
}
