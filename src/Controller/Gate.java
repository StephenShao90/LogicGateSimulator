package Controller;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Gate {
	
	//fields
	protected boolean selected = false; //check if selected
	public void setSelected(boolean sel) { //method to set value of selected
		selected = sel;
	}
	public boolean getSelected() { //give selected value
		return selected;
	}
	
	protected String type; //type of gate
	protected BufferedImage bi = null; //set image to null
	protected Point imgPoint = null; //set image point to null
	protected Gate inputGate1; //1st input
	protected Gate inputGate2; //second input
	boolean input1; //true input
	boolean input2; //true input
	boolean output; //true output
//	protected Gate outputGate; 
	
	//contructor
	public Gate(String typeStr) { 
		
		//set type of gate to user input
		type = typeStr;
		
		//set new img point
		imgPoint = new Point(0,0);
		try {
			//create gate image based on type of gate
			if (type.equalsIgnoreCase("OR")) {//or gate
				bi = ImageIO.read(new File("imagesSmall/orButton.png"));
			} else if (type.equalsIgnoreCase("NOR")) {//nor gate
				bi = ImageIO.read(new File("imagesSmall/norButton.png"));
			} else if (type.equalsIgnoreCase("AND")) {//and gate
				bi = ImageIO.read(new File("imagesSmall/andButton.png"));
			} else if (type.equalsIgnoreCase("NAND")) {//nand gate
				bi = ImageIO.read(new File("imagesSmall/nandButton.png"));
			} else if (type.equalsIgnoreCase("XOR")) {//xor gate
				bi = ImageIO.read(new File("imagesSmall/xorButton.png"));
			} else if (type.equalsIgnoreCase("XNOR")) {//xnor gate
				bi = ImageIO.read(new File("imagesSmall/xnorButton.png"));
			} else if (type.equalsIgnoreCase("NOT")) {//not gate
				this.inputGate2 = null;
				bi = ImageIO.read(new File("imagesSmall/notButton.png"));
			} else if (type.equalsIgnoreCase("SWITCH")) {//switch gate
				this.inputGate2 = null;
				bi = ImageIO.read(new File("imagesSmall/redButton.png"));
			}
			else if (type.equalsIgnoreCase("LIGHT")) {//light gate
				this.inputGate2 = null;
				bi = ImageIO.read(new File("imagesSmall/lightBulbOff.png"));
			}
		} catch (IOException ex) {//catch expection
			ex.printStackTrace();
		}
	}

	public BufferedImage getBi () {
		return bi;
	}
	public Point getImgPoint() {
		return imgPoint;
	}
	
	//create method get image bounds that returns a rectangle shape type
	public Rectangle getImageBounds() {
		Rectangle bounds = new Rectangle(0, 0, 0, 0);
		bounds.setLocation(imgPoint);
		bounds.setSize(bi.getWidth(), bi.getHeight());
		return bounds;
	}
	
	//getters and setters
	public Gate getInputGate1() {
		return inputGate1;
	}
	public void setInputGate1(Gate inputGate) {
		this.inputGate1 = inputGate;
	}
	public Gate getInputGate2() {
		return inputGate2;
	}
	public void setInputGate2(Gate inputGate2) {
		this.inputGate2 = inputGate2;
	}
	
	//method for the logic
	public boolean getOutput() {
		
		//base case
		if(type.equalsIgnoreCase("SWITCH")) {
			return output;
		}
		
		//create first input
		Gate inputGate1 = this.getInputGate1();
		
		//check if input null
		if(inputGate1 != null) {
			
			//get the output from the previous gate
			input1 = inputGate1.getOutput();
		}else {
			//if input is null make it false by default
			input1 = false;
		}
		
		//make second input
		Gate inputGate2 = this.getInputGate2();
		
		//check if input gate is null
		if(inputGate2 != null) {
			
			//get the output from previuos gate
			input2 = inputGate2.getOutput();
		}else {
			//if input is null make it false by default
			input2 = false;
		}
		
		//based on the gate type, make an output based on the input(s)
		if(type.equalsIgnoreCase("AND")) {
			output = input1 && input2;
		}else if(type.equalsIgnoreCase("OR")) {
			output = input1 || input2;
		}else if(type.equalsIgnoreCase("NOR")) {
			output = !(input1 || input2);
		}else if(type.equalsIgnoreCase("NAND")) {
			output = !(input1 && input2);
		}else if(type.equalsIgnoreCase("NOT")) {
			output = !input1;
		}else if(type.equalsIgnoreCase("XOR")) {
			if(input1 != input2) {
				output = true;
			}else {
				output = false;
			}
		}else if(type.equalsIgnoreCase("XNOR")) {
			if(input1 != input2) {
				output = false;
			}else {
				output = true;
			}
		}
		
		//return the output
		return output;
	}
	public String getType() {
		return type;
	}
}
