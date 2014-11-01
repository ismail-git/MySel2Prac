package SelTesting;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by ismailosmanjan on 9/5/14.
 */
public class webTesting {

    public WebDriver driver = new FirefoxDriver();

    @BeforeTest

    public void setUp() throws Exception {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().to("http://yahoo.com");
    }

    @Test
    public void Test() {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    }


    @AfterTest
    public void tearDown() throws Exception {
        driver.close();
    }
}
