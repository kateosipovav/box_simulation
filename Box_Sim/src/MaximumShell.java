import java.lang.Math;
public class MaximumShell{
 
 public static double getPlantVolume(){
   //volume of the cubicle minus the volume of the
   //inner cube
   double bVol = Math.pow(Cubicle.SIDE, 3);
   double sVol = Math.pow(Plant.HEIGHT, 3);
   return (bVol-sVol);
 }
public static double getSurfaceArea(){
   return 6*Math.pow(Cubicle.SIDE, 2);
 }
public static double getMaxPlantNum(){
int volumeMaxNum = (int) (getPlantVolume() / Plant.VOLUME);
    int areaMaxNum = (int) (getSurfaceArea() / Plant.BASESURFACE);
 
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
 public static void run(){
	 
 }
 }


