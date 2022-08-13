package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(String browser) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (browser.toUpperCase())
        {
            case "CHROME":
                capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
                break;

            case "FIREFOX":
                capabilities.setCapability(CapabilityType.BROWSER_NAME, "firefox");
                break;

            case "EDGE":
                capabilities.setCapability(CapabilityType.BROWSER_NAME, "MicrosoftEdge");
                break;
        }

        driver = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
        driver.get("https://www.amazon.in/");

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
