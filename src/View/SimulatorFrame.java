package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.FunctionPanel;
import Model.MotherBoardPanel;


public class SimulatorFrame extends JFrame implements ActionListener{
	
	//create new panels(top and bottom)
	private MotherBoardPanel motherBoardPanel = new MotherBoardPanel();
	private FunctionPanel functionPanel = new FunctionPanel(motherBoardPanel);
	
	//set the dimension of the screen to the screen
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	//constructor
	public SimulatorFrame() {
		//set title
		super("Logic Gate Simulator");
		
		//get the height and width and store in variable
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		
		//set screen properties
		this.setSize(screenSize);		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // allow user to close frame
		this.setLayout(null); // set layout to null(important)
		
		//create top panel
		JPanel topPanel = new JPanel();
	    topPanel.setLayout( new BorderLayout() );
	    getContentPane().add( topPanel );
	    
//		motherBoardPanel.setBounds(0, 0, width, (height*84/100));
//		functionPanel.setBounds(0, (height*84/100), width, (height*3/20));
	    
	    //set the bounds for mother board and function panel
		motherBoardPanel.setBounds(0, 0, width, (height*4/5));
        functionPanel.setBounds(0, (height*4/5), width, (height*3/20));
		
        //add panels
		this.add(motherBoardPanel);
		this.add(functionPanel);
		
		//make frame visible
		this.setVisible(true);
		
	}

	//get screen size
	public static Dimension getScreenSize() {
		return screenSize;
	}

	//get screen size
	public void setScreenSize(Dimension screenSize) {
		this.screenSize = screenSize;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}

