

public class TubeFit {
	private static int maxPlantNum =0;
	private static int maxTubeNum=0;
	private static double maxHeight = 0;
	public static void run(){
			  
		for(double h=5; h < Cubicle.SIDE; h+=1){
			//checking from length 5 just because nothing is going to survive at tube with height 1 cm
				Tube t = new Tube(h);
				System.out.println("The height is " + h);
				int count =	t.getMaxNumPlants();
				if (count > maxPlantNum){
					maxHeight = h;
					maxPlantNum = count;
				}
		}
		maxTubeNum = getMaxNumTubes();
		System.out.println("The plant volume is " + Plant.VOLUME);
		System.out.println("The plant base that can potentially cover the surface is " + Plant.BASESURFACE);
		System.out.println("The maximum number of plants the tubular system can fit is::: " + maxPlantNum);
		System.out.println("The best tubular system has a number of platforms ::: " + maxTubeNum);
		System.out.println("Units used have a height::: " + maxHeight + " radius::: "+ Tube.getRadius());
		
	}
	
	private static int getMaxNumTubes(){
		Tube t = new Tube(maxHeight);
		return (int)(Cubicle.VOLUME/t.getTotalVolume());
	}
}
