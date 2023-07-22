package Controller;

import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LightBulb extends Gate {//type of gate
	
	//contructor
	public LightBulb(String typeStr, boolean isOn) {
		
		//passes type to super class making light bulb gate
		super(typeStr);
		
		//checks if light is on
		input1 = isOn;
		
//		imgPoint = new Point(0,0);
		try {
			if (isOn == true) { //check if light bulb is on
				bi = ImageIO.read(new File("imagesSmall/lightBulbOn.png"));//turns light bulb on
			} 
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		//set second input to null since there's no need for input
		this.inputGate2 = null;
	}

	public void turnOnOff() {
		
		//make new input gate
		Gate inputGate1 = getInputGate1();
		
		//check if input gate for bulb is nul
		if(inputGate1 != null) {
			//get the value of the input gate
			input1 = inputGate1.getOutput();
			
			try {
				//if the input is true
				if (input1 == true) {
					bi = ImageIO.read(new File("imagesSmall/lightBulbOn.png"));//set image to on
				} else {
					bi = ImageIO.read(new File("imagesSmall/lightBulbOff.png"));//keep image to off
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

}