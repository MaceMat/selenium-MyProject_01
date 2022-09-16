package suites;


import categories.ReleaseTest;
import categories.SmokeTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.DummyTest;
import test.WaitForItTest;

@RunWith(Categories.class)
@Categories.IncludeCategory(ReleaseTest.class)
@Categories.ExcludeCategory(SmokeTest.class)
@Suite.SuiteClasses({
        DummyTest.class,
        WaitForItTest.class
})
public class ReleaseTestSuite {
}
