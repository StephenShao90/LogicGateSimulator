package Controller;

import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SwitchButton extends Gate {//type of gate
	
	//contructor
	public SwitchButton(String typeStr, boolean isOn) {
		super(typeStr);//make this gate a switch button gate
		output = isOn;//only has output
		
//		imgPoint = new Point(0,0);
		try {
			if (isOn == true) {//check if switch is on
				bi = ImageIO.read(new File("imagesSmall/greenButton.png"));//make it green button
			} 
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		//no input gates so make them null
		this.inputGate1 = null;
		this.inputGate2 = null;
	}

	//method to turn on off switch
	public void turnOnOff() {
		try {
			//if switch is on, turn off
			if (output == true) {
				output = false;
				bi = ImageIO.read(new File("imagesSmall/redButton.png"));
				
			//if switch is off, turn on
			} else {
				output = true;
				bi = ImageIO.read(new File("imagesSmall/greenButton.png"));
			}
		} catch (IOException ex) {
			
			ex.printStackTrace();
		}
	}

}
