package com.simbirsoft.qaa.course;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
/**
 * Created by artem on 15.11.2018.
 */
public class FirstTest {

        private static WebDriver driver;
        @BeforeMethod
        public void beforeMethod() {
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("http://www.clipboardjs.com");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        @Test
        public void Test() throws Exception {
            CopyPaste copyPaste = new CopyPaste();
            WebElement input = driver.findElement(By.id("foo"));
            WebElement btn = driver.findElement(By.xpath("//*[@id=\"example-target\"]//button"));
            btn.click();
            String data = copyPaste.get();
            Assert.assertEquals(data, input.getAttribute("value"), "Строки не равны");
        }

        @AfterMethod
        public void after() {
            driver.quit();
        }
}

