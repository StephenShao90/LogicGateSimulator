package Application;

import javax.swing.UIManager;

import View.SimulatorFrame;

//Name: Stephen Shao
//Course Code: ICS4U1-03
//Title: Logic Gate Simulator
//Date: 6/13/2023
//Description: This program will allow a user to see how a signal passes through as many logic
//			   gates as they like.
//Features: The images are a drag and drop, the wire is a drag and drop as well but the dragging
// 			and dropping is only to create start and end points for wire, there's a help button,
//			the buttons are meant to be clicked
//Major Skills: Recursion(Gate class), Inheritance(LightBulb and Switch extend from Gate), UI,
//			   Graphics, 2d Graphics, Buffered image, Data Structures, Array List, List, Pop
// 			   up frames, Dimension class, Mouse pressed-clicked-adapter-dragged-released,
//			   Clearing images, panel boundries, Pop up images, Imports(images, files)
//Areas of concern: There's a small bug that doesn't effect the end product but just the 
//					visual aspect for the wire. Basically the new wire will be created before
// 					the mouse is released, but won't actually appear unless the mouse gets 
// 					released for real. Very small bug but I don't know where in the code it's
//					coming from. Everything else works as intended.
public class Application {

	public static void main(String[] args) {
		try {
			//get UI-Friend helped me find this UI
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	    } catch (Exception evt) {}
		//make main frame
		SimulatorFrame mainFrame = new SimulatorFrame();
	}
}
