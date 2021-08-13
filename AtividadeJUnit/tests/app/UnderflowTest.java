package app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnderflowTest {
    @Test(expected = UnderflowException.class)
    public void test1() {
        assertEquals(32768, new Calculator(-32768, -1).sum());
    }
    @Test(expected = UnderflowException.class)
    public void test2() {
        assertEquals(32769, new Calculator(-32768, -2).sum());
    }
    @Test(expected = UnderflowException.class)
    public void test3() {
        assertEquals(32769, new Calculator(-32768, 1).subtract());
    }
}
