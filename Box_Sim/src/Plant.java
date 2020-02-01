

public class Plant {
	//measurements are in cm and cm^2
	//*
    //*
	//*
	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	//depending on the simulation, these parameters vary, so make sure to change them accordingly and then run the program.
	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	//*
	//*
	//*
public static final double SPREAD = (double)45;
public static final double HEIGHT = 23;

public static final double VOLUME = (2*Math.PI*Math.pow(SPREAD/2, 2)*HEIGHT/3);
	//let's assume the plant is a half of the ellipsoid
public static final double BASESURFACE = Math.PI*Math.pow(SPREAD/2, 2);
}

