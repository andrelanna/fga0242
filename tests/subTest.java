import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class subTest extends TestCase {

    private short first;
    private short second;
    private short res;

    public subTest(short first, short second, short res) {
        this.first = first;
        this.second = second;
        this.res = res;
    }

    @Parameters
    public static Iterable getParameters() {
        Short[][] data = new Short[][]{
                {3, 2, 1},
                {2, 3, -1},
                {-3, -2, -1},
                {-2, -3, 1},
                {3, 0, 3},
                {0, 3, -3},
                {-3, 0, -3},
                {0, 3, -3},
                {0, 0, 0},
                {-32768, 0, -32768},
                {-32768, -1, -32767},
                {-1, -32768, 32767},
                {-32768, -2, -32766},
                {-2, -32768, 32766},
                {32767, 1, 32766},
                {-1, 32767, -32768},
                {32767, 0, 32767},
                {0, 32767, -32767},
                {32767, 1, 32766},
                {1, 32767, -32768},
                {32767, 2, 32765},
                {2, 32767, -32765}

        };
        return Arrays.asList(data);
    }

    @Test
    public void testSub() throws LimiteInferiorException, LimiteSuperiorException {

        short result = new Calc(first, second).sub();
        assertEquals(res, result);
    }

    @Test(expected = LimiteInferiorException.class)
    public void testSubFail() throws LimiteInferiorException, LimiteSuperiorException {
        short resultInf1 = new Calc((short) -32768,(short) 1).sub();
        assertEquals(LimiteInferiorException.class, resultInf1);

        short resultSup1 = new Calc((short) 1,(short) -32768).sub();
        assertEquals(LimiteSuperiorException.class, resultSup1);
    }
}