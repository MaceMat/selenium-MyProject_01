package test;

import base.TestBase;
import categories.FullclassTest;
import categories.ReleaseTest;
import categories.SmokeTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
@Category(FullclassTest.class)
public class DummyTest extends TestBase {


    @Category(SmokeTest.class)
    @Test
    public void testA(){
        getDriver().get(BASE_URL);

        System.out.println("Vitaj");
        System.out.println("Welcome");
    }

    @Category({SmokeTest.class, ReleaseTest.class})
    @Test
    public void testB(){
        getDriver().get(BASE_URL);
        System.out.println("U nas");
        System.out.println("in Slovakia");
    }

    @Category(ReleaseTest.class)
    @Test
    public void testC(){
        getDriver().get(BASE_URL);
        System.out.println("Ako to ide");
        System.out.println("How it going");
    }

}
