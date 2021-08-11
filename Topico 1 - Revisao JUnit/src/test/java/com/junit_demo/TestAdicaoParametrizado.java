package com.junit_demo;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestAdicaoParametrizado {
   
   @Parameters
   public static Iterable getParameters(){
      Object[][] dados = new Object[][]{
         {3, 2, 5},
         {-3, -2, -5},
         {3, 0, 3},
         {-3, 0, -3},
         {0, 0, 0},
         {-32768, 0, -32768},
         {-32768, 1, -32767},
         {32767, -1, 32766},
         {32767, 0, 32767}
      };

      return Arrays.asList(dados);
   }

   private int op1;
   private int op2;
   private int resultadoEsperado;

   public TestAdicaoParametrizado(int op1, int op2, int resultado){
      this.op1                = op1;
      this.op2                = op2;
      this.resultadoEsperado  = resultado;
   }

   @Test
   public void test(){
      int resultado = new Calculator(op1, op2).sum();
      assertEquals(resultadoEsperado, resultado);
   }
}
