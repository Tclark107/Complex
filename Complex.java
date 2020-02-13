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
       s = s.trim();
       String NUM = "(\\d+\\.\\d*|\\.?\\d+)";
       String SGN = "[+-]?";
       String OP =  "\\s*[+-]\\s*";
       String I =   "i";
       String OR =  "|";
       String REAL = SGN+NUM;
       String IMAG = SGN+NUM+"?"+I;
       String COMP = REAL+OR+
                     IMAG+OR+
                     REAL+OP+NUM+"?"+I;
      
      System.out.println(s);
       
       if( !s.matches(COMP) ){
          throw new NumberFormatException(
                    "Cannot parse input string \""+s+"\" as Complex");
       }
       s = s.replaceAll("\\s","");     
       if( s.matches(REAL) ){
          System.out.println("S matches REAL");
          this.re = Double.parseDouble(s);
          this.im = 0;
       }else if( s.matches(SGN+I) ){
         System.out.println("S matches sgn+i");
          this.re = 0;
          this.im = Double.parseDouble( s.replace( I, "1.0" ) );
       }else if( s.matches(IMAG) ){
         System.out.println("S matches imag");
          this.re = 0;
          this.im = Double.parseDouble( s.replace( I , "" ) );
       }else if( s.matches(REAL+OP+I) ){
         System.out.println("S matches REAL+op+i");
          this.re = Double.parseDouble( s.replaceAll( "("+REAL+")"+OP+".+" , "$1" ) );
          this.im = Double.parseDouble( s.replaceAll( ".+("+OP+")"+I , "$1"+"1.0" ) );
       }else{   //  s.matches(REAL+OP+NUM+I) 
         System.out.println("S matches real+op+num+i");
          this.re = Double.parseDouble( s.replaceAll( "("+REAL+").+"  , "$1" ) );
          this.im = Double.parseDouble( s.replaceAll( ".+("+OP+NUM+")"+I , "$1" ) );
       }
    }
 
    //---------------------------------------------------------------------------
    // Public methods 
    //---------------------------------------------------------------------------
 
    // Complex arithmetic -------------------------------------------------------
 
    // copy()
    // Return a new Complex equal to this Complex
    Complex copy(){
       return(new Complex(this.re, this.im));
    }
    
    // add()
    // Return a new Complex representing the sum this plus z.
    Complex add(Complex z){
      double real = this.re + z.re;
      double imag = this.im + z.im;
      return (new Complex(real,imag));
    }
    
    // negate()
    // Return a new Complex representing the negative of this.
    Complex negate(){
       return (new Complex(-this.re,-this.im));
    }
 
    // sub()
    // Return a new Complex representing the difference this minus z.
    Complex sub(Complex z){
       double real = re - z.re;
       double imag = im - z.im;
       return (new Complex (real,imag));
    }
 
    // mult()
    // Return a new Complex representing the product this times z.
    Complex mult(Complex z){
       double real = (re * z.re) - (im * z.im);
       double imag = (re * z.im) + (z.re * im);
       return (new Complex(real,imag));
    }
 
    // recip()
    // Return a new Complex representing the reciprocal of this.
    // Throw an ArithmeticException with appropriate message if 
    // this.equals(Complex.ZERO).
    Complex recip(){
       Complex r = (this.mult(conj()).div(conj()));
       return r;
    }
 
    // div()
    // Return a new Complex representing the quotient of this by z.
    // Throw an ArithmeticException with appropriate message if 
    // z.equals(Complex.ZERO).
    Complex div(Complex z){
       double real = ((re*z.re) + (im*z.im))/((re*re) + (im*im));
       double imag = ((re*z.im) - (z.re*im))/((re*re) + (im*im));
       return(new Complex(real, imag));
    }
 
    // conj()
    // Return a new Complex representing the conjugate of this Complex.
    Complex conj(){
       return (new Complex(re, -im));
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
       return Math.sqrt((im*im)+(re*re));
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
      String fmt   = "%.8f";
      String real  = Double.toString(Double.parseDouble(String.format(fmt, this.re)));
      String imag  = Double.toString(Double.parseDouble(String.format(fmt, this.im)));
      String reStr = (
                        this.re==0 && this.im==0?
                           "0"
                        :this.re==0?
                           ""
                        :
                           real
                     );
      String imStr = (
                        this.im==0?
                           ""
                        :this.im==1?
                           "i"
                        :this.im==-1?
                           "-i"
                        :this.im<0 || this.re==0?
                           imag+"i"
                        :
                           "+"+imag+"i"
                     );
      return reStr+imStr;
   }
 
    // equals()
    // Return true iff this and obj have the same real and imaginary parts.
    public boolean equals(Object x){
      boolean eq = false;
      Complex r;

      if( x instanceof Complex ){
         r = (Complex) x;
         eq = ( this.re==r.re && this.im==r.im );
      }
      return eq;
    }
 
    // valueOf()
    // Return a new Complex with real part a and imaginary part b.
    static Complex valueOf(double a, double b){
       return( new Complex(a,b) );
    }
 
    // valueOf()
    // Return a new Complex with real part a and imaginary part 0.
    static Complex valueOf(double a){
      return( new Complex(a) );
    }
 
    // valueOf()
    // Return a new Complex constructed from s.
    static Complex valueOf(String s){
      return (new Complex(s));
    }
 
 }