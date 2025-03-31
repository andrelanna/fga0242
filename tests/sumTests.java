import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class sumTests extends TestCase {

    private short first;
    private short second;
    private short res;

    public sumTests(short first, short second, short res) {
        this.first = first;
        this.second = second;
        this.res = res;
    }

    @Parameters
    public static Iterable getParameters() {
        Short[][] data = new Short[][]{
                {3, 2, 5},
                {-3, -2, -5},
                {3, 0, 3},
                {-3, 0, -3},
                {0, 0, 0},
                {-32768, 0, -32768},
                {-32768, 1, -32767},
                {32767, -1, 32766},
                {32767, 0, 32767},

        };
        return Arrays.asList(data);
    }



    @Test
    public void testSum() throws LimiteInferiorException, LimiteSuperiorException {

        short result = new Calc(first, second).sum();
        assertEquals(res, result);
    }

    @Test(expected = LimiteInferiorException.class)
    public void testSumFail() throws LimiteInferiorException, LimiteSuperiorException {
        short resultInf1 = new Calc((short) -32768,(short) -1).sum();
        assertEquals(LimiteInferiorException.class, resultInf1);

        short resultInf2 = new Calc((short) -32768,(short) -2).sum();
        assertEquals(LimiteInferiorException.class, resultInf2);

        short resultSup1 = new Calc((short) 32767,(short) 1).sum();
        assertEquals(LimiteSuperiorException.class, resultSup1);

        short resultSup2 = new Calc((short) 32767,(short) 2).sum();
        assertEquals(LimiteSuperiorException.class, resultSup2);
    }

}