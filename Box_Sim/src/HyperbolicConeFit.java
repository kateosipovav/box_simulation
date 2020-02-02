
public class HyperbolicConeFit{
	private static int maxNumber = 0;
    private static double maxRadius = 0;
	private static double maxHeight = 0;
 
public static void run(){

	System.out.println("The plant volume is " + Plant.VOLUME);
	System.out.println("The plant base that can potentially cover the surface is " + Plant.BASESURFACE);
	for (double coefficient = 1; coefficient > 0; coefficient-=0.1){
		//coefficient is 1 maximum, and is never zero
	for (double r =2; r < Cubicle.SIDE*Math.pow(2,0.5); r+=1){
	//incrementing the radius of the cone by one cm each time
	for(double h=5; h < Cubicle.SIDE*Math.pow(2,0.5); h+=1){
	//checking from length 5 just because nothing is going to survive at cone with radius 1 cm
		System.out.println("The equation is : y = cosh(x)/" + coefficient + " - " + coefficient);
		System.out.println("The radius is " + r);
		System.out.println("The height is " + h);
		
		HyperbolicCone c = new HyperbolicCone(coefficient, r, h);
		int count =	c.getMaxNumPlants();
		if (count > maxNumber){
			maxRadius = r;
			maxHeight = h;
			maxNumber = count;
		}
	 }
	}
	}
	System.out.println("The maximum number of plants the cone can fit is::: " + maxNumber);
	System.out.println("The best cone has a radius::: " + maxRadius + " a height::: " + maxHeight);

}
	


}
