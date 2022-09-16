package base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

    public static final String BASE_URL = "http://localhost";


    @Before
    public void setUp(){

    }

    @After
    public void tearDown(){
        WebDriverSingleton.getWebdriverInstance().quit();
    }

    public WebDriver getDriver() {
        return WebDriverSingleton.getWebdriverInstance();
    }


}
