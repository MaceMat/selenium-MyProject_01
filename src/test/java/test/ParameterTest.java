package test;

import base.TestBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
@RunWith(Parameterized.class)
public class ParameterTest extends TestBase {
    int number;
    boolean expectedPrime;

    @Parameterized.Parameters
    public static List<Object[]> getData() {
        return Arrays.asList(new Object[][]{{1, true}, {2, true}, {482, false}});
    }

    public ParameterTest(int number, boolean expectedPrime) {
        this.number = number;
        this.expectedPrime = expectedPrime;
    }

    @Test
    public void testOptimusParameters() {
        getDriver().get(BASE_URL + "/primenumber.php");

        WebElement numberInput = getDriver().findElement(By.xpath("//input[@type='number']"));
        WebElement button = getDriver().findElement(By.cssSelector("button.btn"));

        numberInput.clear();
        numberInput.sendKeys(String.valueOf(number));
        button.click();

        check(expectedPrime);
    }

    private void check(boolean expectedPrime) {
        if (expectedPrime) {
            new WebDriverWait(getDriver(), 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Optimus approves']")));
        } else {
            new WebDriverWait(getDriver(), 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Optimus is sad']")));
        }
    }

}

