package com.tsi.adam.ahmed.program;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class seleniumTest {

    public WebDriver driver;

    @Test
    public void chromeDriverTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.quit();
    }

    @Test
    public void chromeSessionTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\React\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.quit();
    }

    @Test
    public void checkWebsiteConnection(){
        System.setProperty("webdriver.chrome.driver", "C:\\React\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.quit();
    }
}
