package com.junit_demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestAdicaoException {
   
   @Test
   public void testLimiteInferior() throws LimiteInferiorExtrapoladoException {
      Calculator calc = new Calculator(-32768, -1);
      assertEquals(0, calc.sum());
   }
   
   @Test
   public void testLimiteInferior2() throws LimiteInferiorExtrapoladoException {
      Calculator calc = new Calculator(-32768, -2);
      assertEquals(0, calc.sum());
   }

   @Test
   public void testLimiteSuperior() throws LimiteSuperiorExtrapoladoException {
      Calculator calc = new Calculator(32767, 1);
      assertEquals(0, calc.sum());
   }

   @Test
   public void testLimiteSuperior2() throws LimiteSuperiorExtrapoladoException {
      Calculator calc = new Calculator(32767, 2);
      assertEquals(0, calc.sum());
   }
   
}
