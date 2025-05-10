package testes;

import org.junit.runners.Suite.SuiteClasses;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;

@RunWith(Suite.class)

@SuiteClasses({ ExceptionTestSoma.class,
                ParameterizedTestSub.class,
                ExceptionTestSub.class,
                ParameterizedTestSoma.class
              })

public class AllTests {}