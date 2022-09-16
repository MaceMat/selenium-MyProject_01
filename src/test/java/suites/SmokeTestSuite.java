package suites;


import categories.SmokeTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.DummyTest;
import test.WaitForItTest;

@RunWith(Categories.class)
@Categories.IncludeCategory(SmokeTest.class)
@Suite.SuiteClasses({
        DummyTest.class,
        WaitForItTest.class
})
public class SmokeTestSuite {
}