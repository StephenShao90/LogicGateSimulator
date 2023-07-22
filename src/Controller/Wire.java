package Controller;

import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Wire {
	
	//point fields for wire
	Point startP, endP = null;

	//contructor
	public Wire(Point startPoint, Point endPoint) {
		//declare start and end point for wire based on parameters
		startP = startPoint;
		endP = endPoint;
	}
	
	//getters and setters
	public void setStartPoint(Point sP) {
		startP = sP;
	}
	public void setEndPoint(Point eP) {
		endP = eP;
	}
	public Point getStartPoint( ) {
		return startP;
	}
	public Point getEndPoint() {
		return endP;
	}
}
