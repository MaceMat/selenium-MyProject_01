package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class WebDriverSingleton {

    private static WebDriver driver;

    private static void initialize() {
        initializeFireFox();
    }

    public static WebDriver getWebdriverInstance() {
        if (driver == null) {
            initialize();
        }
        return driver;
    }

    private static void initializeGoogleChrome() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver_105.exe");
        driver = new ChromeDriver();
    }

    private static void initializePhantomJS(){
        System.setProperty("phantomjs.binary.path","src/test/resources/drivers/phantomjs.exe");
        driver = new PhantomJSDriver();
    }

    private static void initializeFireFox(){
        driver = new FirefoxDriver();
    }

}
