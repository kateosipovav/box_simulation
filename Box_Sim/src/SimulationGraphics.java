//https://issuu.com/riccardoricci/docs/29653339-programming-finite-elements-in-java-janua
//read this to visualize the mesh
/*
import java.awt.*;
//import java.awt.Graphics;
import java.awt.event.*;
//import java.awt.event.MouseEvent;
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Canvas;
 
 
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.awt.Canvas;
import javax.media.j3d.BoundingBox;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.ImageComponent;
import javax.media.j3d.ImageComponent2D;
import javax.media.j3d.LinearFog;
import javax.media.j3d.Node;
import javax.media.j3d.PhysicalBody;
import javax.media.j3d.PhysicalEnvironment;
import javax.media.j3d.Screen3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.View;
import javax.media.j3d.ViewPlatform;
import javax.vecmath.Matrix4d;
import javax.vecmath.Point3d;
 
import com.sun.j3d.utils.picking.PickCanvas;
import com.sun.j3d.utils.picking.PickResult;
import com.sun.j3d.utils.picking.PickTool;
import com.vzome.core.render.RenderedManifestation;
import com.vzome.core.render.RenderingChanges;
import com.vzome.desktop.controller.RenderingViewer;
 
 
public class SimulationGraphics extends Frame {
 
  // Instantiates an Example01 object.
 
     public static void main(String args[]) {
       new SimulationGraphics();
    }
  
    //* The Example01 constructor sets the frame's size, adds the
  //* visual components, and then makes them visible to the user.
      //*
     // * We place a Canvas3D object into the Frame so that Java 3D
    // * has the heavyweight component it needs to render 3D
 //    * graphics into.  We then call methods to construct the
   // * View and Content branches of our scene graph.
   //
   public SimulationGraphics() {
      //Title our frame and set its size.
   super("Java 3D Example01");
   setSize(400,300);
 
  //Here is our first Java 3D-specific code.  We add a
  //Canvas3D to our Frame so that we can render our 3D
  //graphics.  Java 3D requires a heavyweight component
       //Canvas3D into which to render.
       Canvas3D myCanvas3D = new Canvas3D(null);
    add("Center",myCanvas3D);
     //Turn on the visibility of our frame.
     setVisible(true);
  
     //We want to be sure we properly dispose of resources
      //this frame is using when the window is closed.  We use
      //an anonymous inner class adapter for this.
  addWindowListener(new WindowAdapter()
   {public void windowClosing(WindowEvent e)
           {dispose(); System.exit(0);} 
        }
   );
 
      //Now that we have our Frame and Canvas3D, we are ready
    //to start building our scene graph.  We need to construct
    //both a view branch and a content branch.  In order to
//actually use our view branch, we also need to construct
      //a View and connect it to our view branch's ViewPlatform.
      View myView = constructView(myCanvas3D);
   Locale myLocale = constructViewBranch(myView);
     constructContentBranch(myLocale);
    }
 
    
 // 060    * constructView() takes a Canvas3D reference and constructs
 // 061    * a View to display in that Canvas3D.  It uses the default
 // 062    * PhysicalBody and PhysicalEnvironment (both required to be
 // 063    * set or else the 3D runtime will throw exceptions).  The
 // 064    * returned View is used by constructViewBranch() to attach
 // 065    * the scene graph's ViewPlatform to a Canvas3D for rendering.
 // 066    *
 // 067    * @see constructViewBranch(View)
 // 068   
     private View constructView(Canvas3D myCanvas3D) {
    View myView = new View();
      myView.addCanvas3D(myCanvas3D);
      myView.setPhysicalBody(new PhysicalBody());
   myView.setPhysicalEnvironment(new PhysicalEnvironment());
 return(myView);
    }
   
 // 079    * constructViewBranch() takes as input a View which we
 // 080    * attached to our Canvas3D in constructView().  It constructs
  //081    * a default view branch for the scene graph, attaches
 // 082    * the View to the ViewPlatform, and returns a reference to
//  083    * our Locale for use by constructContentBranch()
  //084    * in creating content for our scene graph.
  //085    *
//  086    * @see constructView(Canvas3D)
 // 087    * @see constructContentBranch(Locale)
//  088   
    private Locale constructViewBranch(View myView) {
       //First, we create the necessary coordinate systems
      //(VirtualUniverse, Locale), container nodes
      //(BranchGroup, TransformGroup), and platform which
      VirtualUniverse myUniverse = new VirtualUniverse();
     Locale myLocale = new Locale(myUniverse);
      BranchGroup myBranchGroup = new BranchGroup();
       TransformGroup myTransformGroup = new TransformGroup();
      ViewPlatform myViewPlatform = new ViewPlatform();
      Next, we insert the platform into the transform group,
      //the transform group into the branch group, and the branch
     //group into the locale's branch graph portion of the
      //scene graph0.
  
     myTransformGroup.addChild(myViewPlatform);
     myBranchGroup.addChild(myTransformGroup);
     myLocale.addBranchGraph(myBranchGroup);
      // Finally, we attach our view to the view platform and we
       //return a reference to our new universe.  We are ready to     render 3D content!
  
      myView.attachViewPlatform(myViewPlatform);
      return(myLocale);
    }
     /*
 // 117    * constructContentBranch() is where we specify the 3D graphics
 // 118    * content to be rendered into the Locale referenced
 /// 119    * in the passed parameter.  Nothing is currently specified, so we
  //120    * render an empty universe.
 // 121    *
  //122    * @see constructViewBranch(View)
 // 123   
    private void constructContentBranch(Locale myLocale) {
 	
//Insert content to be rendered here.
 
Shape3D myShape3D = new Shape3D(myText3D, new Appearance());  
 	 BranchGroup contentBranchGroup = new BranchGroup();
 	  Transform3D myTransform3D = new Transform3D();
 	   myTransform3D.setTranslation(new Vector3f(-1.0f,0.0f,-4.0f));
 	   myTransform3D.setScale(0.1);
 	   Transform3D tempTransform3D = new Transform3D();
 	    tempTransform3D.rotY(Math.PI/4.0d);
 	    myTransform3D.mul(tempTransform3D);
 	    TransformGroup contentTransformGroup = new TransformGroup(myTransform3D);
 	
 	    //We add our child nodes and insert the branch group into
 	   //the live scene graph.  This results in Java 3D rendering
 	    //the content.
 	    contentTransformGroup.addChild(myShape3D);
 	     contentBranchGroup.addChild(contentTransformGroup);
 	  myLocale.addBranchGraph(contentBranchGroup);
    }
   }
 
  
 
 

*/