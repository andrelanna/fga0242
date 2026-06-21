package com.junit_demo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSum {
   private Calculator calc;

   @Test
   public void sum2PositiveIntegers(){
      calc = new Calculator(3, 2);
      assertEquals(5, calc.sum());
   }
}
