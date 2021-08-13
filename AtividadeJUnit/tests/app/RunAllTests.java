package app;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;nano
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({SumTest.class, SubtractTest.class, UnderflowTest.class, OverflowTest.class})
public class RunAllTests {

}
