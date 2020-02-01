
import javax.swing.JOptionPane;

public class Simulation {

	public static void main(String[] args) {
		
	
 String answer = JOptionPane.showInputDialog("What simulation do you want to run? ::: cone, rect, tube");
  if (answer.equals("cone")){
	   ConeFit.run();
  }
   if (answer.equals("rect")){
	   RectFit.run();
   }
   if (answer.equals("tube")){
	   TubeFit.run();
	   }
	}



}