public class HyperbolicConeFit {
	private static int maxNumber = 0;
	private static double maxRadius = 0;
	private static double maxHeight = 0;
	private static double maxCoefficient = 0;

	public static void run() {
		double coefficient = 0.0;
		System.out.println("The plant volume is " + Plant.VOLUME);
		System.out.println("The plant base that can potentially cover the surface is " + Plant.BASESURFACE);
		for (double i = 0; i < 11; i++) {
			// up to which negative power of two the geometric sequence goes
			coefficient = Math.pow(2, -i);
			// coefficient is 1 maximum, and is never zero

			for (double r = 2; r < Cubicle.SIDE * Math.pow(2, 0.5)/4; r += 5) {
				// incrementing the radius of the cone by one cm each time
				for (double h = 5; h < Cubicle.SIDE * Math.pow(2, 0.5); h += 10) {
					// checking from length 5 just because nothing is going to
					// survive at cone with radius 1 cm
					System.out.println("The equation is : y = cosh(x)*" + coefficient + " - " + coefficient);
					System.out.println("The radius is " + r);
					System.out.println("The height is " + h);

					HyperbolicCone c = new HyperbolicCone(coefficient, r, h);
					int count = c.getMaxNumPlants();
					if (count > maxNumber) {
						maxRadius = r;
						maxHeight = h;
						maxCoefficient = coefficient;
						maxNumber = count;
					}
				}
			}
		}

		System.out.println("The maximum number of plants the hyperbolic cone can fit is::: " + maxNumber);
        System.out.println("The best hyperbolic cone has a radius::: " + maxRadius + " a height::: " + maxHeight
			+ " and the equation : y = cosh(x)/" + maxCoefficient + " - " + maxCoefficient);

	}

}
