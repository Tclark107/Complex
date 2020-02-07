//-----------------------------------------------------------------------------
// Complex.java
// Represents complex numbers as a pair of doubles
//
// pa6
// Fill in the function definitions below. See class notes, or the project 
// description for the definitions of the complex arithmetic operations.
//-----------------------------------------------------------------------------

class Complex{

    //--------------------------------------------------------------------------
    // Private Data Fields 
    //--------------------------------------------------------------------------
    private double re;
    private double im;
    
    //--------------------------------------------------------------------------
    // Public Constant Fields 
    //--------------------------------------------------------------------------
    public static final Complex ONE = Complex.valueOf(1,0);
    public static final Complex ZERO = Complex.valueOf(0,0);
    public static final Complex I = Complex.valueOf(0,1);
 
    //--------------------------------------------------------------------------
    // Constructors 
    //--------------------------------------------------------------------------
    Complex(double a, double b){
       this.re = a;
       this.im = b;
    }
 
    Complex(double a){
       this.re = a;
       this.im = 0;
    }
 
    Complex(String s){
       // Fill in this constructor.
       // It should accept expressions like "-2+3i", "2-3i", "3", "5i", etc..
       // Throw a NumberFormatException if s cannot be parsed as Complex.
    }
 
    //---------------------------------------------------------------------------
    // Public methods 
    //---------------------------------------------------------------------------
 
    // Complex arithmetic -------------------------------------------------------
 
    // copy()
    // Return a new Complex equal to this Complex
    Complex copy(){
       // Fill in
    }
    
    // add()
    // Return a new Complex representing the sum this plus z.
    Complex add(Complex z){
       // Fill in
    }
    
    // negate()
    // Return a new Complex representing the negative of this.
    Complex negate(){
       // Fill in
    }
 
    // sub()
    // Return a new Complex representing the difference this minus z.
    Complex sub(Complex z){
       // Fill in
    }
 
    // mult()
    // Return a new Complex representing the product this times z.
    Complex mult(Complex z){
       // Fill in
    }
 
    // recip()
    // Return a new Complex representing the reciprocal of this.
    // Throw an ArithmeticException with appropriate message if 
    // this.equals(Complex.ZERO).
    Complex recip(){
       // Fill in
    }
 
    // div()
    // Return a new Complex representing the quotient of this by z.
    // Throw an ArithmeticException with appropriate message if 
    // z.equals(Complex.ZERO).
    Complex div(Complex z){
       // Fill in
    }
 
    // conj()
    // Return a new Complex representing the conjugate of this Complex.
    Complex conj(){
       // Fill in
    }
    
    // Re()
    // Return the real part of this.
    double Re(){
       return re;
    }
 
    // Im()
    // Return the imaginary part of this.
    double Im(){
       return im;
    }
 
    // abs()
    // Return the modulus of this Complex, i.e. the distance between 
    // points (0, 0) and (re, im).
    double abs(){
       // Fill in
    }
 
    // arg()
    // Return the argument of this Complex, i.e. the angle this Complex
    // makes with positive real axis.
    double arg(){
       return Math.atan2(im, re);
    }
 
    // Other functions ---------------------------------------------------------
    
    // toString()
    // Return a String representation of this Complex. The real and imaginary
    // parts will be rounded to 8 decimal places, and trailing zeros will be
    // truncated from the two parts. The String returned will be readable by 
    // the constructor Complex(String s)
    public String toString(){
       // Fill in
    }
 
    // equals()
    // Return true iff this and obj have the same real and imaginary parts.
    public boolean equals(Object obj){
       // Fill in
    }
 
    // valueOf()
    // Return a new Complex with real part a and imaginary part b.
    static Complex valueOf(double a, double b){
       // Fill in
    }
 
    // valueOf()
    // Return a new Complex with real part a and imaginary part 0.
    static Complex valueOf(double a){
       // Fill in
    }
 
    // valueOf()
    // Return a new Complex constructed from s.
    static Complex valueOf(String s){
       // Fill in
    }
 
 }