package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class FirstTestCase {

    WebDriver driver;
    ExtentReports extentReports;
    ExtentTest test;
    ExtentSparkReporter sparkReporter;

    @BeforeMethod
    public void setup() {
        // Set up ExtentReports
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/target/extentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        
        // Set up Chrome Driver
        System.setProperty("webdriver.chrome.driver", "/usr/lib/chromium-browser/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testWebsiteTitle() {
        // Create a test in ExtentReports
        test = extentReports.createTest("Selenium External Website Test", "Automating external website validation");

        // Perform actions
        driver.get("https://demo.opencart.com/");
        String title = driver.getTitle();
        
        // Test validation
        try {
            Assert.assertEquals(title, "Your Store");
            test.pass("Title matches 'Your Store'");
        } catch (AssertionError e) {
            test.fail("Title does not match 'Your Store'");
        }
    }

    @AfterMethod
    public void tearDown() {
        // Close the driver
        driver.quit();
        
        // Flush the report to generate the HTML file
        extentReports.flush();
    }
}
