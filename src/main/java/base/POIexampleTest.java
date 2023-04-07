package base;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ReadExcelData;

public class POIexampleTest extends BaseTest{

    @Test(dataProviderClass = ReadExcelData.class , dataProvider = "bvtData") // this will provide the data
    public static void Logintest(String username , String password){
        //river.get("https://www.bigin.com/"); // this can go to properties file

        System.out.println(loc.getProperty("sign_in_link"));
        driver.findElement(By.linkText(loc.getProperty("sign_in_link"))).click();
        driver.findElement(By.id(loc.getProperty("Email_field"))).sendKeys(username);
        driver.findElement(By.id(loc.getProperty("next_btn"))).click();
        driver.findElement(By.id(loc.getProperty("password_field"))).sendKeys(password);
        driver.findElement(By.id(loc.getProperty("login_btn"))).click();

    }

}
