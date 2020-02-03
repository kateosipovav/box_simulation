import java.lang.Math;

public class HyperbolicCone {
	// for calculating volume, use 1, for calculating surface area, use 2.
	private final double topradius = 1;
	private double bottomradius;
	private double coefficient;
	private double height;
	private double b;
	private double a;
	private double bs;
	private double as;
	private double rotaxis;
	// the shift is needed to calculate the volume of the plant shell.
	private double shift = Plant.HEIGHT;

	public HyperbolicCone(double c, double br, double h) {
		coefficient = c;
		bottomradius = br;
		height = h;
		calcRotAxis();
		calcB();
		calcA();
		calcBShifted();
		calcAShifted();
	}

	private void calcRotAxis() {
		rotaxis = Integrate.asinh((-height * coefficient) / (2 * Math.sinh((topradius - bottomradius) / 2)))
				+ (topradius + bottomradius) / 2;
	}

	private void calcB() {
		b = rotaxis - topradius;
	}

	private void calcA() {
		a = rotaxis - bottomradius;
	}

	private void calcBShifted() {
		bs = rotaxis - shift;
	}

	private void calcAShifted() {
		as = a - shift;
	}

	public double getVolume() {
		// calculate volume inside (a cylinder; f(b)*pi*r^2
		double sVol = Integrate.f(b, coefficient, 3, rotaxis, b) * Math.PI * Math.pow(topradius, 2);
		// calculating volume using cylindrical shells; 2*pi*(integral from a to
		// b of (rotaxis-x)*f(x)*dx
		// for calculating volume, use 1, for calculating surface area, use 2,
		// to just get the integral, use 3.
		double bVol = Integrate.Trapezoid(a, b, coefficient, 1, rotaxis);
		System.out.println("total volume of the cone" + sVol + bVol);
		return (sVol + bVol);
	}

	public double getVolumeAroundCone() {
		// calculate volume inside (a cylinder; f(b)*pi*r^2
		double sVol = Integrate.f(bs, coefficient, 4, rotaxis, b) * Math.PI * Math.pow(shift, 2);
		// calculating volume using cylindrical shells; 2*pi*(integral from a to
		// b of (rotaxis-x)*f(x)*dx
		// for calculating volume, use 1, for calculating surface area, use 2,
		// to just get the integral, use 3.
		double bVol = Integrate.Trapezoid(as, bs, coefficient, 5, rotaxis);
		System.out.println("volume of the plant shell" + sVol + bVol);
		return (sVol + bVol - getVolume());
	}

	public double getSurfaceArea() {
		// calculate the small surface area as the top circle with radius
		// rotaxis - b
		double sArea = Math.pow((rotaxis - b), 2) * Math.PI;
		double bArea = Integrate.Trapezoid(-b, 0, coefficient, 2, rotaxis);
		System.out.println("total surface area of the cone" + sArea + bArea);
		return (sArea + bArea);
	}

	public int getMaxNumPlants() {
		int volumeMaxNum = (int) (getVolumeAroundCone() / Plant.VOLUME);
		int areaMaxNum = (int) (getSurfaceArea() / Plant.BASESURFACE);
		 System.out.println("the volumeMaxNum is " + volumeMaxNum);
		 System.out.println("the areaMaxNum is " + areaMaxNum);

		if (volumeMaxNum <= areaMaxNum) {
			System.out.println("The volume is the limiting factor");
			System.out.println("The number of plants this time is " + volumeMaxNum);
			System.out.println("__________________________________________________");
			System.out.println();
			System.out.println();
			return volumeMaxNum;
		}

		else {
			System.out.println("The area is the limiting factor");
			System.out.println("The number of plants this time is " + areaMaxNum);
			System.out.println("__________________________________________________");
			System.out.println();
			System.out.println();
			return areaMaxNum;
		}
	}
}
