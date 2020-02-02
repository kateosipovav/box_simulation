


public class RectFit extends Rect{
	
	private static int maxPlantNum = 0;
	private static int maxRectNum = 0;
	
public static void run(){  
	maxPlantNum = getMaxNumPlants();
	maxRectNum = getMaxNumRects();

	System.out.println("The plant volume is " + Plant.VOLUME);
	System.out.println("The plant base that can potentially cover the surface is " + Plant.BASESURFACE);
	System.out.println("The volume of one rectangle " + Rect.getVolume());
	System.out.println("The maximum number of plants the straight rectangular system can fit is::: " + maxPlantNum);
	System.out.println("The best straight rectangular system has a number of platforms ::: " + maxRectNum);
	System.out.println("Rects used have a height::: " + Rect.getHeight() + " width::: "+ Rect.getWidth() + " length::: " + Rect.getLength());
	
}

private static int getMaxNumRects(){
	return (int)(Cubicle.VOLUME/Rect.getTotalVolume());
}
}