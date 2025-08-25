package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ParameterizedSubtractionTestFailure.class, ParameterizedSubtractionTestSuccess.class,
		ParameterizedSumTestFailure.class, ParameterizedSumTestSuccess.class })
public class AllTests {

}
