package com.training.selenium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class TestBase {
    public static final String BASE_DIRECTORY = System.getProperty("user.dir");
    public static WebDriver driver;


    @BeforeSuite
    public void Initialize() {
        try {

           // Set Chrome Driver Property
           System.setProperty("webdriver.chrome.driver", BASE_DIRECTORY + "/src/main/driver/chrome/chromedriver.exe");

           ChromeOptions chromeOptions = new ChromeOptions();
           chromeOptions.addArguments("disable-infobars");

           // Create Chrome driver instance
            driver = new ChromeDriver(chromeOptions);

            // Maximize browser
            driver.manage().window().maximize();

            // Open Website
            driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");



        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @AfterSuite
    public void TearDown() {
        try {

            driver.quit();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
