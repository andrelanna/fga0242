package tests;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.Calculadora;
import app.LimiteInferiorExtrapoladoException;
import app.LimiteSuperiorExtrapoladoException;

@RunWith(Parameterized.class)
public class TesteSubtracao {
    private short op1;
    private short op2;
    private short ans;
    
    public TesteSubtracao(short op1, short op2, short ans){
        this.op1 = op1;
        this.op2 = op2;
        this.ans = ans;
    }
    
    @Parameters
    public static Iterable getParameters(){
        Object[][] data = new Object[][]{
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
            {-32767, -1, -32766},
            {-1, 32767, -32768},
            {32767, 0, 32767},
            {0, 32767, -32767},
            {32767, 1, 32766},
            {1, 32767, -32766},
            {32767, 2, 32765},
            {2, 32767, -32765}
        }; 
        return Arrays.asList(data);
    }

    @Test(expectedExceptions={ LimiteInferiorExtrapoladoException.class, LimiteSuperiorExtrapoladoException.class })
    public void test(){
        short res = new Calculadora(this.op1, this.op2).subtracao();
        assertEquals(this.ans, res);   
    }
    
}

