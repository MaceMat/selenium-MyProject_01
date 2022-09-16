package pages;

import base.WebDriverSingleton;
import enumerators.SinType;
import models.sin;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static base.TestBase.BASE_URL;

public class SinCityPage {
    private final WebDriver driver;
    private static final String PAGE_URL = "/sincity.php";

    @FindBy(name = "title")
    private WebElement titleInput;

    @FindBy(name = "author")
    private WebElement authorInput;

    @FindBy(name = "message")
    private WebElement messageInput;

    @FindBy(xpath = "//button[@type= 'submit']")
    private WebElement confessButton;

    @FindBy(xpath = "//div/article")
    private WebElement sinDetailArticle;

    public SinCityPage() {
        driver = WebDriverSingleton.getWebdriverInstance();
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get(BASE_URL + PAGE_URL);

    }

    public void fillSinInformation(sin Sin) {
        titleInput.sendKeys(Sin.getTitle());
        authorInput.sendKeys(Sin.getAuthor());
        messageInput.sendKeys(Sin.getMessage());
    }

    public void markTag(List<SinType> tags) {
        for (SinType tag : tags) {
            driver.findElement(By.xpath("//input[@value='" + tag.getXpathValue() + "']")).click();

        }
    }

    public void confessSin() {
        confessButton.click();
    }

    public void checkSinStatus(sin flySin) {
        //1.chcem najst element hriechu
        WebElement actualsin = getWebElement(flySin);
        //2.chcem z neho vytiahnut text
        String actualText = actualsin.findElement(By.cssSelector("p")).getText().trim();
        //3.porovnat ocakavane a skutocne
        if (flySin.isForgiven()) {
            Assert.assertEquals("nevie porovnat", "forgiven", actualText);
        } else {
            Assert.assertEquals("pending", actualText);
        }

    }

    private WebElement getWebElement(sin flySin) {
        WebElement listOfSins = driver.findElement(By.cssSelector("ul.list-of-sins"));
        WebElement actualsin = listOfSins.findElement(By.xpath("./li[contains(text(),'" + flySin.getTitle() + "')]"));
        return actualsin;

    }

    public void openSinDetail(sin flySin) {
        getWebElement(flySin).click();
    }

    public void checkSinDetail(sin flySin) {
        //1.najst element detailu
        WebElement sinDetail = driver.findElement(By.cssSelector("div.detail"));
        //2.pockat na hriech
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBePresentInElement(sinDetail
                        .findElement(By.cssSelector("p")),flySin.getMessage()));
        //3.overit message,author, title
        String actualTitle = sinDetail.findElement(By.cssSelector("h4")).getText();
        Assert.assertTrue(actualTitle.contains(flySin.getTitle()));
        Assert.assertTrue(actualTitle.contains(flySin.getAuthor()));


    }
}
