import  java. lang. Math;
//import java.text.DecimalFormat;
 
 
public class Integrate
{
    private static final int TOLERANCE = 50;
   //tolerance by default is 50
  
 // source code http://cs.roanoke.edu/Spring2012/CPSC402A/Integrate.java
   
 
   // =========================================================
   // Perform numerical integration using Adaptive Simpson.
   // The endpoints of the interval and the tolerance are read
   // in. The recursive method AdaptSimpson is called to
   // recursively evaluate the integral.
   // =========================================================
   public static double integrateAdapt ( double a, double b, double coefficient,  int condition, double rotaxis)
   {
  System.out.println ("\nAdaptive Simpson: " + AdaptSimp(a,b,(TOLERANCE/2), coefficient, condition, rotaxis));
  return AdaptSimp(a,b,(TOLERANCE/2), coefficient,  condition, rotaxis);
  
   }
   // ====================================================================
   // Compute the numerical approximation of the integral of the given
   // function (determined by the parameter fcnNum) on the interval
   // [a,b] using the composite Simpson rule with n subdivisions of
   // [a,b]; return the result.
   // ====================================================================
   private static double Simpson (double a, double b, int n, double coefficient,  int condition, double rotaxis)
   {
  double h = (b - a)/n;
  double x = a;
  double mid = x + h/2;
  double sum = f(x, coefficient,   condition, rotaxis, b);
  int i = 0;
 
  while (i < n - 1)
      {
    i++;
    x = a + i * h;
    sum = sum + 4 * f(mid, coefficient,  condition, rotaxis, b) + 2 * f(x, coefficient,  condition, rotaxis, b);
    mid = x + h/2;
      }
 
  sum = sum + 4 * f(mid, coefficient,   condition, rotaxis, b) + f(b, coefficient,  condition, rotaxis, b);
  return sum * h / 6;
   }
 
   // ========================================================
   // Recursive algorithm for the Adaptive Simpson method.
   // ========================================================
   private static double AdaptSimp (double a, double b, double tol, double coefficient,  int condition, double rotaxis)
   {
  double S1, S2;
  double approx;
  double mid;
 
  System.out.println ("Points " + a + "  " + b);
  S1 = Simpson (a, b, 1, coefficient,   condition, rotaxis);
  S2 = Simpson (a, b, 2, coefficient,   condition, rotaxis);
 
  if (Math.abs (S1 - S2) < 15 * tol)
      approx = S2;
  else
      {
    mid = (a + b)/2;
    double ans1 = AdaptSimp (a, mid, tol/2, coefficient,  condition, rotaxis);
    double ans2 = AdaptSimp (mid, b, tol/2, coefficient,   condition, rotaxis);
    approx = ans1 + ans2;
      }
 
  return (approx);
   }
  
 
   // ==================================================================
   // Compute and return f(x) for a given x and a function f determined
   // by the parameter fcnNum.
   // ==================================================================
   public static double f(double x, double coefficient, int condition, double rotaxis, double b)
   {
     //the coefficient changes the slope of the function as well as it shifts the function to the origin
     //precondition - the coefficient is <= 1.
     
     //calculating volume using cylindrical shells; 2*pi*(integral from a to b of (rotaxis-x)*f(x)*dx
    //for calculating volume, use 1, for calculating surface area, use 2, just integral is 3.
  double value =0;     // f(x)
 double shift = Plant.HEIGHT;
    switch(condition) {
   case 1:
     //calculating the volume
      value = 2*Math.PI*(Math.cosh(x)*coefficient - coefficient)*(rotaxis - x);
       break;
     case 2:
       // calculating surface area
       value = 2*Math.PI*x*Math.pow(Math.pow((Math.sinh(x+b)*coefficient), 2) +1, 0.5);
      break;
     case 3:
       // the actual function
       value = Math.cosh(x)*coefficient - coefficient;
       break;
       case 4:
       //the actual function for the outer shell of the cone (the one taken up by plants)
       value = Math.cosh(x+shift)*coefficient - coefficient;
       break;
       case 5:
       //calculate the volume of the plant shell, using shells
        value = 2*Math.PI*(Math.cosh(x+shift)*coefficient - coefficient)*(rotaxis - x);
        break;
  
 
    }
  
  return value;
   }
   public static double asinh(double x)
   {
   return Math.log(x + Math.sqrt(x*x + 1.0));
   }
 
 
}
