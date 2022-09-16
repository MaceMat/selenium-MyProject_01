package test;

import base.TestBase;
import helpers.ExcelReader;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class PrimeTest extends TestBase {
    private static final String TEST_DATA_PATH = "src/test/resources/data.xlsx";
    private static final String SHEET = "prime";


    @Test
    public void testPrime() throws IOException {
        getDriver().get(BASE_URL + "/primenumber.php");
        WebElement numberInput = getDriver().findElement(By.xpath("//input[@type='number']"));
        WebElement button = getDriver().findElement(By.cssSelector("button.btn"));
        ExcelReader primeExcelReader = new ExcelReader(TEST_DATA_PATH);
        Sheet sheet = primeExcelReader.getSheetByName(SHEET);
        for (Row cells : sheet) {
            if (cells.getRowNum() == 0) {
                continue;
            }
            int number = (int)cells.getCell(0).getNumericCellValue();
            boolean expectedPrime = cells.getCell(1).getBooleanCellValue();

            numberInput.clear();
            numberInput.sendKeys(String.valueOf(number));
            button.click();

            check(expectedPrime);
        }

    }

    private void check(boolean expectedPrime) {
        if (expectedPrime){
            new WebDriverWait(getDriver(), 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Optimus approves']")));
        } else {
            new WebDriverWait(getDriver(), 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Optimus is sad']")));
        }
    }

}
