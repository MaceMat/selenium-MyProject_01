package test;

import base.TestBase;
import categories.SmokeTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;

public class WaitForItTest extends TestBase {

    @Category(SmokeTest.class)
    @Test
    public void checkTitle() {
        getDriver().get(BASE_URL + "/waitforit.php");
        Assert.assertEquals("WAIT FOR IT !", getDriver().findElement(By.xpath("//h1")).getText());

    }

}
