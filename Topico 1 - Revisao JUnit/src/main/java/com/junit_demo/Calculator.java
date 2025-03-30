package com.junit_demo;

public class Calculator {
   private short num1;
   private short num2;

   public Calculator(int num1, int num2){
      this.num1 = (short) num1;
      this.num2 = (short) num2;
   }

   public short sum(){
      return (short) (num1 + num2);
   }

   public short subtrair() {
      return (short) (num1 - num2);
   }

   public short dividir() throws DivisaoPorZeroException {
      if(num2 == 0){
         throw new DivisaoPorZeroException(); 
      }
      return (short) (num1/num2);
   }
}