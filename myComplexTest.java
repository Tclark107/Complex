//-------------------------------------------------------------------------------------------------------------------------
// myComplexTest.java
// I will use this to test my class Complex.
//-------------------------------------------------------------------------------------------------------------------------

import java.io.*;

class myComplexTest{
   
   public static void main(String[] args) throws IOException{
        Complex C = new Complex("14.1+1.8i");
        Complex A = new Complex(9,-8);
        
        C = C.sub(A);
        System.out.println(C.toString());

   }
}