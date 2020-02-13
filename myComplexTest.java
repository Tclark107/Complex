//-------------------------------------------------------------------------------------------------------------------------
// myComplexTest.java
// I will use this to test my class Complex.
//-------------------------------------------------------------------------------------------------------------------------

import java.io.*;

class myComplexTest{
   
   public static void main(String[] args) throws IOException{
      Complex C = new Complex(9,-8);
      Complex A = new Complex("4.5 - 5.1i");

      System.out.println(C.toString());
      System.out.println(A.toString());
      A = A.conj();
      C = C.conj();
      System.out.println(A.toString());
      System.out.println(C.toString());
      //System.out.println(A.negate());
      //System.out.println(C.negate());
   }
}