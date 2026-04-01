package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({SumTest.class, SubtractionTest.class, ExceptionTest.class})
public class SuitTest {
}