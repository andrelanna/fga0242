import com.example.calculadora.Calculadora;
import com.example.calculadora.LimiteInferiorExtrapoladoException;
import com.example.calculadora.LimiteSuperiorExtrapoladoException;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class TesteSubtracao {
    @Test
    public void SubtracaoExtrapolaAcima() {
        assertThrows(LimiteSuperiorExtrapoladoException.class, ()-> new Calculadora(1, -32768).Subtracao());
    }

    @Test
    public void SubtracaoExtrapolaAbaixo() {
        assertThrows(LimiteInferiorExtrapoladoException.class, ()-> new Calculadora(-32768, 1).Subtracao());
    }
}
