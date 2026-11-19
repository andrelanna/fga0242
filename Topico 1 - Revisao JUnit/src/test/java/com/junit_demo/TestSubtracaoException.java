package com.junit_demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestSubtracaoException {
   
   @Test
   public void testLimiteInferior() throws LimiteInferiorExtrapoladoException {
      Calculator calc = new Calculator(-32768, 1);
      assertEquals(0, calc.subtrair());
   }
   @Test
   public void testLimiteSuperior() throws LimiteSuperiorExtrapoladoException {
      Calculator calc = new Calculator(1, -32768);
      assertEquals(0, calc.subtrair());
   }

}
