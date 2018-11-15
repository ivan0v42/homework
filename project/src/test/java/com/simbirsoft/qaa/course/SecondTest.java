package com.simbirsoft.qaa.course;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;



public class SecondTest {
    final String str="google";
    private static WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void searchTest() throws Exception {
        CopyPaste copyPaste = new CopyPaste();
        WebElement searchInputElement = driver.findElement(By.id("lst-ib"));
        copyPaste.copy(str);
        searchInputElement.sendKeys(Keys.CONTROL+ "v");
        Assert.assertEquals(copyPaste.get(), searchInputElement.getAttribute("value"), "Строки не равны");
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
