
import java.util.ArrayList;
import java.lang.Math;

public class Tube {
private static final double RADIUS = 1.5; 
private double height; 

public Tube(double h){
	height = h;
}
protected double getVolume(){
	return (Math.PI*Math.pow(RADIUS, 2)*height);
}
protected double getSurfaceArea(){
	System.out.println("The surface area this time is " + (Math.PI*RADIUS*2*height + 2*Math.PI*Math.pow(RADIUS, 2)));
	return (Math.PI*RADIUS*2*height + 2*Math.PI*Math.pow(RADIUS, 2));
}
protected static double getRadius(){
	return RADIUS;
}
protected double getHeight(){
	return height;
}
protected double getVolumeAroundTube(){
	return ((Math.pow(Plant.HEIGHT+RADIUS, 2)*(height+Plant.HEIGHT)*Math.PI)-getVolume());
}
protected int getMaxNumPlants(){
	int volumeMaxNum = (int)(getVolumeAroundTube()/Plant.VOLUME);
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
protected double getTotalVolume(){
	return (getVolume()+getVolumeAroundTube());
}


}

