//-----------------------------------------------------------------------------
// ComplexParserAndFormatter.java
// 
// This file includes two static functions, parseComplex() and formatComplex(),
// that will be helpful in writing your Complex class in pa6.
//
// Function parseComplex() can be used to write the from-String constructor in
// your Complex class. Either include it as a private static function, and call 
// it from within your from-String constructor, or copy its body into your from-
// String constructor.
//
// Function formatComplex() can be used to write the toString() function in
// your Complex class.  Again, either include it as a private static function,
// and call it from within your toString() function, or copy its body into your
// toString() function. 
//
// formatComplex() takes a pair of doubles, a and b, and returns a String of
// the form "a+bi" which is suitable as input to parseComplex(). In some sense
// the two functions are inverses.  parseComplex() takes a String and returns
// a pair of doubles, while formatComplex() takes a pair of doubles and returns
// a String.
//
// parseComplex() will accept input strings of the following types.
// "3.5+4.2i"
// "-4 - 7i"
// "8"
// "-9.3i"
// "1+i"
// "i"
//
// parseComplex() will reject input strings of the following types, throwing 
// a NumberFormatException.
// "3+4 i"
// "2i+1"
// "- 4-7i"
// "5+-6i"
//
//-----------------------------------------------------------------------------

class ComplexParserAndFormatter{

    public static void main(String[] args){
       String[] str =  {"3.5-4.2i", 
                        "3.5+4.2i", 
                        "3.4", "4.2i", 
                        "0", 
                        "0+0i", 
                        "i", 
                        "-i", 
                        "1.499999999+6i"};
       double[][] C = new double[str.length][];
 
       for(int k=0; k<str.length; k++){
          C[k] = parseComplex(str[k]);
       }
 
       for(int k=0; k<str.length; k++){
          System.out.printf("%-20s", str[k]);
          System.out.printf("%-20s", "("+C[k][0]+", "+C[k][1]+")");
          System.out.printf("%-20s\n", formatComplex(C[k][0], C[k][1]));
       }
    }
    
    // parseComplex()
    // Returns a double[] of length 2 containing (real, imaginary) parts
    // of a complex number represented by string argument str.  Throws a
    // NumberFormatException if str cannot be parsed as a complex number.
    static double[] parseComplex(String str){
       double[] part = new double[2];
       String s = str.trim();
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
       
       if( !s.matches(COMP) ){
          throw new NumberFormatException(
                    "Cannot parse input string \""+s+"\" as Complex");
       }
       s = s.replaceAll("\\s","");     
       if( s.matches(REAL) ){
          part[0] = Double.parseDouble(s);
          part[1] = 0;
       }else if( s.matches(SGN+I) ){
          part[0] = 0;
          part[1] = Double.parseDouble( s.replace( I, "1.0" ) );
       }else if( s.matches(IMAG) ){
          part[0] = 0;
          part[1] = Double.parseDouble( s.replace( I , "" ) );
       }else if( s.matches(REAL+OP+I) ){
          part[0] = Double.parseDouble( s.replaceAll( "("+REAL+")"+OP+".+" , "$1" ) );
          part[1] = Double.parseDouble( s.replaceAll( ".+("+OP+")"+I , "$1"+"1.0" ) );
       }else{   //  s.matches(REAL+OP+NUM+I) 
          part[0] = Double.parseDouble( s.replaceAll( "("+REAL+").+"  , "$1" ) );
          part[1] = Double.parseDouble( s.replaceAll( ".+("+OP+NUM+")"+I , "$1" ) );
       }
       return part;
    }
 
    // formatComplex()
    // Returns a String representation of the complex number a+bi, suitable 
    // for parsing by function parseComplex().
    static String formatComplex(double a, double b){
       String fmt   = "%.8f";
       String real  = Double.toString(Double.parseDouble(String.format(fmt, a)));
       String imag  = Double.toString(Double.parseDouble(String.format(fmt, b)));
       String reStr = (
                         a==0 && b==0?
                            "0"
                         :a==0?
                            ""
                         :
                            real
                      );
       String imStr = (
                         b==0?
                            ""
                         :b==1?
                            "i"
                         :b==-1?
                            "-i"
                         :b<0 || a==0?
                            imag+"i"
                         :
                            "+"+imag+"i"
                      );
       return reStr+imStr;
    }
    
 }