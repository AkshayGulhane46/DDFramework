package base;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MyFirstTest extends BaseTest {
    @Test(dataProvider = "testdata")
    public static void Logintest(String username , String password){
       //river.get("https://www.bigin.com/"); // this can go to properties file

        System.out.println(loc.getProperty("sign_in_link"));

        driver.findElement(By.linkText(loc.getProperty("sign_in_link"))).click();
        driver.findElement(By.id(loc.getProperty("Email_field"))).sendKeys(username);
        driver.findElement(By.id(loc.getProperty("next_btn"))).click();
        driver.findElement(By.id(loc.getProperty("password_field"))).sendKeys(password);
        driver.findElement(By.id(loc.getProperty("login_btn"))).click();

    }

    @DataProvider(name="testdata")
    public Object[][] tdata(){
        return new Object[][]{
                {
                    "akshaytest345@sdfdsdaf.com" , "123asdfsdafasdASd!@#"

                },{
                "akshaytest345@gmail.com" , "123ASd!@#"
                }
        };
    }
}
