import java.lang.Math;
//import java.text.DecimalFormat;

public class Integrate {
	
    //number of rectangles by defailt is 30
	private final static int n = 30; 
	// source code http://cs.roanoke.edu/Spring2012/CPSC402A/Integrate.java


	 // ====================================================================
    // Compute the numerical approximation of the integral of the given
    // function (determined by the parameter fcnNum) on the interval
    // [a,b] using the composite Trapezoid rule with n subdivisions of 
    // [a,b]; return the result.
    // ==================================================================== 
    public static double Trapezoid (double a, double b, double coefficient, int condition, double rotaxis )
    {
	double h = (b - a)/n;
	double x = a;
	double sum = 0;

	for (int i = 1; i < n; i++)
	    {
		x = a + i * h;
		sum += f(x, coefficient, condition, rotaxis, b);
	    }

	sum = 2 * sum + (f(a, coefficient, condition, rotaxis, b) + f(b,coefficient, condition, rotaxis, b));

	return sum * h / 2;
    }

	// ==================================================================
	// Compute and return f(x) for a given x and a function f determined
	// by the parameter fcnNum.
	// ==================================================================
	public static double f(double x, double coefficient, int condition, double rotaxis, double b) {
		// the coefficient changes the slope of the function as well as it
		// shifts the function to the origin
		// precondition - the coefficient is <= 1.

		// calculating volume using cylindrical shells; 2*pi*(integral from a to
		// b of (rotaxis-x)*f(x)*dx
		// for calculating volume, use 1, for calculating surface area, use 2,
		// just integral is 3.
		double value = 0; // f(x)
		double shift = Plant.HEIGHT;
		switch (condition) {
		case 1:
			// calculating the volume
			value = 2 * Math.PI * (Math.cosh(x) * coefficient - coefficient) * (rotaxis - x);
			break;
		case 2:
			// calculating surface area
			value = 2 * Math.PI * x * Math.pow(Math.pow((Math.sinh(x + b) * coefficient), 2) + 1, 0.5);
			break;
		case 3:
			// the actual function
			value = Math.cosh(x) * coefficient - coefficient;
			break;
		case 4:
			// the actual function for the outer shell of the cone (the one
			// taken up by plants)
			value = Math.cosh(x + shift) * coefficient - coefficient;
			break;
		case 5:
			// calculate the volume of the plant shell, using shells
			value = 2 * Math.PI * (Math.cosh(x + shift) * coefficient - coefficient) * (rotaxis - x);
			break;

		}

		return value;
	}

	public static double asinh(double x) {
		return Math.log(x + Math.sqrt(x * x + 1.0));
	}

}
