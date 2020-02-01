
import java.lang.Math;
import java.util.ArrayList;

public class Cone {
	
private double radius; 
private double height; 
public Cone(){
}
public Cone(double r, double h){
	radius = r; height = h;
}

public double getVolume(){
	return (Math.PI*Math.pow(radius, 2)*height/3);
}
public double getSurfaceArea(){
	System.out.println("The surface area this time is " + (Math.PI*radius*(radius + Math.sqrt(Math.pow(radius, 2)+Math.pow(height, 2)))));
	return (Math.PI*radius*(radius + Math.sqrt(Math.pow(radius, 2)+Math.pow(height, 2))));
	
}
public double getRadius(){
	return radius;
}
public double getHeight(){
	return height;
}
private double getVolumeAroundCone(){
	System.out.println("The volume of the cone this time is " + getVolume());
	//**************************
	//there are 4 situations in total:
	// 1: There is ENOUGH height and ENOUGH width for a full cone
	// 2: There is ENOUGH height, but NOT ENOUGH width for a full cone
	// 3: There is NOT ENOUGH height, but ENOUGH width for a full cone
	// 4: There is NOT ENOUGH height and NOT ENOUGH width for a full cone
	//**********************************
	//Situation 1
	if ((getHeight() + Plant.HEIGHT < Cubicle.SIDE)&& (getRadius() + Plant.HEIGHT < Cubicle.SIDE/2)){
			double h = getHeight() + Plant.HEIGHT;
			double r = getRadius() + Plant.HEIGHT; 
			System.out.println("The volume around the cone this time is " + ((h*Math.PI*Math.pow(r, 2)) - getVolume()));
			return ((h*Math.PI*Math.pow(r, 2)) - getVolume());
	}
	//Situation 2
	else if((getHeight() + Plant.HEIGHT < Cubicle.SIDE)&& !(getRadius() + Plant.HEIGHT < Cubicle.SIDE/2)){
	//when cut we can think of the resulting figure as a cylinder and a cone
	//find the bottom side of the piece that sticks out, and determine the height of that piece 
		double rsmall = getRadius() + Plant.HEIGHT - Cubicle.SIDE/2;
	// we end up with two similar triangles
	double hCylinder = (getHeight() + Plant.HEIGHT)*rsmall/(getRadius() + Plant.HEIGHT);
	double hCone = getHeight() + Plant.HEIGHT - hCylinder;
	double r = Cubicle.SIDE/2;
	double volumeCyl = Math.PI*Math.pow(r, 2)*hCylinder;
	double volumeCon = Math.PI*Math.pow(r, 2)*hCone/3;
	 System.out.println("The volume around the cone this time is " + (volumeCyl+volumeCon - getVolume()));
	return (volumeCyl+volumeCon - getVolume());
	}
	//Situation 3
	else if(!(getHeight() + Plant.HEIGHT < Cubicle.SIDE)&& (getRadius() + Plant.HEIGHT < Cubicle.SIDE/2)){
    // we can think of the resulting figure as a cut cone.
	// we can find the big cone and the small cone 
	//and then subtract the small volume from the big one
		double hsmall = getHeight() + Plant.HEIGHT - Cubicle.SIDE;
	    double hbig = getHeight() + Plant.HEIGHT; 
	    double rbig = getRadius() + Plant.HEIGHT; 
	    double rsmall = rbig*hsmall/hbig;
	    double bigvolume = Math.PI*Math.pow(rbig, 2)*hbig/3;
	    double smallvolume = Math.PI*Math.pow(rsmall, 2)*hsmall/3;
	    System.out.println("The volume around the cone this time is " + (bigvolume- smallvolume - getVolume()));
	    return (bigvolume- smallvolume - getVolume());
	}
	//Situation 4
	else if (!(getHeight() + Plant.HEIGHT < Cubicle.SIDE)&& !(getRadius() + Plant.HEIGHT < Cubicle.SIDE/2)){
		//we end up with a cylinder and a cut cone
	//calculating the volume of the cylinder first 
		double rsmall0 = getRadius() + Plant.HEIGHT - Cubicle.SIDE/2;
		// we end up with two similar triangles
		double hCylinder = (getHeight() + Plant.HEIGHT)*rsmall0/(getRadius() + Plant.HEIGHT);
		double r = Cubicle.SIDE/2;
		double volumeCyl = Math.PI*Math.pow(r, 2)*hCylinder;
		//now let's find the volume of the cut cone
		double hsmall = getHeight() + Plant.HEIGHT - Cubicle.SIDE;
	    double hbig = getHeight() + Plant.HEIGHT; 
	    double rbig = getRadius() + Plant.HEIGHT; 
	    double rsmall = rbig*hsmall/hbig;
	    double bigvolume = Math.PI*Math.pow(r, 2)*(hbig- hCylinder)/3;
	    double smallvolume = Math.PI*Math.pow(rsmall, 2)*hsmall/3;
	    double volumecutcone = bigvolume - smallvolume;
	    System.out.println("The volume around the cone this time is " + (volumecutcone + volumeCyl));
	    return (volumecutcone + volumeCyl);
		
	}
	System.out.println("Error in the getVolumeAroundCone() function");
	return -1;
}


public int getMaxNumPlants(){
	int volumeMaxNum = (int)(getVolumeAroundCone()/Plant.VOLUME);
	int areaMaxNum = (int)(getSurfaceArea()/Plant.BASESURFACE);
	
	if (volumeMaxNum <= areaMaxNum){
		System.out.println("The volume is the limiting factor");
		System.out.println("The number of plants this time is " + volumeMaxNum);
		System.out.println("__________________________________________________");
		System.out.println();
		System.out.println();
		return volumeMaxNum;
	}
	
	else{
		System.out.println("The area is the limiting factor");
		System.out.println("The number of plants this time is " + areaMaxNum);
		System.out.println("__________________________________________________");
		System.out.println();
		System.out.println();
		return areaMaxNum;
	}
}



 
	
	
}

