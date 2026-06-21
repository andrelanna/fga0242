package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ParameterizedTestSum.class, ParameterizedTestSub.class, ExceptionTestSum.class, ExceptionTestSub.class })
public class AllTests {

}