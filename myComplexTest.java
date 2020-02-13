//-------------------------------------------------------------------------------------------------------------------------
// myComplexTest.java
// I will use this to test my class Complex.
//-------------------------------------------------------------------------------------------------------------------------

import java.io.*;

class myComplexTest{
   
   public static void main(String[] args) throws IOException{
      Complex C = new Complex(2,-3);
      Complex A = new Complex("-10");
      Complex B;
      double abs;

      System.out.println(C.toString());
      System.out.println(A.toString());
      B = C.div(A);
      abs = A.abs();
      System.out.println(B.toString());
      System.out.println(abs);

      //System.out.println(A.negate());
      //System.out.println(C.negate());
   }
}