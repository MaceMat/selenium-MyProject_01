package pages;

import base.WebDriverSingleton;
import models.sin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static base.TestBase.BASE_URL;

public class SpartaPage {

    private final WebDriver driver;

    private static final String PAGE_URL = "/sparta.php";

    public SpartaPage() {
        driver = WebDriverSingleton.getWebdriverInstance();
        PageFactory.initElements(driver, this);
    }

    public void openpage(){
        driver.get(BASE_URL + PAGE_URL);
    }

    public WebElement getMainSinElement(sin sin){
        return driver.findElement(By.xpath("//article[p[text()='"+ sin.getMessage() + "']]"));

    }

    public void forgiveSin(sin evaspieva) {
        //1.najist article a button
        WebElement article = getMainSinElement(evaspieva);
        //2.kliknut na button
        article.findElement(By.cssSelector("button")).click();
        //3.potvrdit modal
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.id("confirm")));
        driver.findElement(By.id("confirm")).click();
        evaspieva.setForgiven(true);
    }
}
