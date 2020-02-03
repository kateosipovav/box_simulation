
public class Plant {
	// measurements are in cm and cm^2
	// *
	// *
	// *
	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// depending on the simulation, these parameters vary, so make sure to
	// change them accordingly and then run the program.
	// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// *
	// *
	// *
	public static double SPREAD = 18;
	public static double HEIGHT = 22;

	public static double VOLUME = 2 * Math.PI * Math.pow(SPREAD / 2, 2) * HEIGHT / 3;
	// let's assume the plant is a half of the ellipsoid
	public static double BASESURFACE = Math.PI * Math.pow(SPREAD / 2, 2);

}
