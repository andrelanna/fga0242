import com.example.calculadora.Calculadora;

import static org.junit.Assert.*;

import com.example.calculadora.LimiteInferiorExtrapoladoException;
import com.example.calculadora.LimiteSuperiorExtrapoladoException;
import org.junit.Test;

public class TesteSoma {
    @Test
    public void SomaExtrapolaAcima() {
        assertThrows(LimiteSuperiorExtrapoladoException.class, ()-> new Calculadora(32767, 1).Soma());
        assertThrows(LimiteSuperiorExtrapoladoException.class, ()-> new Calculadora(32767, 2).Soma());
    }

    @Test
    public void SomaExtrapolaAbaixo() {
        assertThrows(LimiteInferiorExtrapoladoException.class, ()-> new Calculadora(-32768, -1).Soma());        assertThrows(LimiteInferiorExtrapoladoException.class, ()-> new Calculadora(-32768, -1).Soma());
        assertThrows(LimiteInferiorExtrapoladoException.class, ()-> new Calculadora(-32768, -2).Soma());
    }
}
