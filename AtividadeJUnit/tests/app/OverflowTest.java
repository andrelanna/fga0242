package app;

import app.Calculator;
import app.OverflowException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OverflowTest {
    @Test(expected = OverflowException.class)
    public void test1() {
        assertEquals(32768, new Calculator(32767, 1).sum());
    }
    @Test(expected = OverflowException.class)
    public void test2() {
        assertEquals(32769, new Calculator(32767, 2).sum());
    }
    @Test(expected = OverflowException.class)
    public void test3() {
        assertEquals(32769, new Calculator(1, -32767).subtract());
    }
}
