package com.junit_demo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDivisao {
   
   @Test
   public void test1() throws DivisaoPorZeroException{
      Calculator calculadora = new Calculator(4, 2);
      assertEquals(2, calculadora.dividir());
   }
   
   @Test
   public void test2() throws DivisaoPorZeroException{
      Calculator calculadora = new Calculator(2, 4);
      assertEquals(0, calculadora.dividir());
   }

   @Test(expected = ArithmeticException.class)
   public void test3() throws DivisaoPorZeroException{
      Calculator calculadora = new Calculator(30, 0);
      assertEquals(0, calculadora.dividir());
   }

}
