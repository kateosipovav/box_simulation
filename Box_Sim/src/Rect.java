

public class Rect {
	// one StraightRect is ONLY one wall
	private static final double WIDTH = 3;
	private static final double LENGTH = 50;
	private static final double HEIGHT = 50;

	protected static double getVolume() {
		return WIDTH * HEIGHT * LENGTH;
	}

	protected static double getSurfaceArea() {
		return (2 * (WIDTH * HEIGHT + WIDTH * LENGTH + LENGTH * HEIGHT));
	}

	protected static double getWidth() {
		return WIDTH;
	}

	protected static double getHeight() {
		return HEIGHT;
	}

	protected static double getLength() {
		return LENGTH;
	}

	protected static double getVolumeAroundStraightRect() {
		return (Plant.HEIGHT * Cubicle.SIDE * Cubicle.SIDE);
	}

	protected static double getTotalVolume() {
		return (getVolume() + getVolumeAroundStraightRect());
	}

	protected static int getMaxNumPlants() {
		int maxVolNum = (int) (getVolumeAroundStraightRect() / Plant.VOLUME);
		int maxSurfNum = (int) (getSurfaceArea() / Plant.BASESURFACE);
		if (maxVolNum <= maxSurfNum) {
			System.out.print("The volume is a limiting factor");
			return maxVolNum;
		} else {
			System.out.print("The surface area is a limiting factor");
			return maxSurfNum;
		}
	}
}
