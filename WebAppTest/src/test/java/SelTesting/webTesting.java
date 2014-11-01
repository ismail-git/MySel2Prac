package SelTesting;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by ismailosmanjan on 9/5/14.
 */
public class webTesting {

    public WebDriver driver = new FirefoxDriver();

    @BeforeTest
    @Parameters({"useSauceLabs", "userName", "access_Key", "os", "browser", "browserVersion", "url"})
    public void setUp(boolean useSauceLabs, String userName, String access_Key, String os, String browser, String browserVersion, String url) throws Exception {
        try {
            if (useSauceLabs == true) {
                SauceLabSetUp(os, browser, browserVersion, userName, access_Key);
            } else {
                if (browser.equalsIgnoreCase("firefox")) {
                    driver = new FirefoxDriver();
                }
            }

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.navigate().to(url);

        } catch (Exception e) {
            throw (e);
        }
    }

    @Test
    public void Test() {
        driver.manage().window().maximize();

    }


    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }

    public void SauceLabSetUp(String os, String browser, String browserVersion, String userName, String access_Key)
            throws Exception {
        try {
            // Choose the browser, version, and platform to test
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browser);
            capabilities.setCapability("version", browserVersion);
            capabilities.setCapability("platform", os);

            // Create the connection to SauceLabs to run the tests
            this.driver = new RemoteWebDriver(
                    new URL("http://" + userName + ":" + access_Key + "@ondemand.saucelabs.com:80/wd/hub"),
                    capabilities);
        } catch (Exception e) {
            throw (e);
        }
    }
}

