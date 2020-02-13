//-------------------------------------------------------------------------------------------------------------------------
// myComplexTest.java
// I will use this to test my class Complex.
//-------------------------------------------------------------------------------------------------------------------------

import java.io.*;

class myComplexTest{
   
   public static void main(String[] args) throws IOException{
        Complex C = new Complex("1 + 3i");
        Complex A = new Complex(3);
        Complex B = new Complex(4, -5);
        Complex D;
        Complex F = new Complex("1 +3i");

        System.out.println(C.toString());
        System.out.println(C);
        System.out.println(A);
        System.out.println(B);
        System.out.println(Complex.valueOf("12+3i"));
        System.out.println(Complex.valueOf(1.322));
        System.out.println(Complex.valueOf(1.322, -3));

        D = C;

        System.out.println(D.equals(C));
        System.out.println(C.equals(D));
        System.out.println(D.equals(B));
        System.out.println(F.equals(C));
        System.out.println(D.equals(F));



   }
}