package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class HelpFrame extends JFrame{

	private JPanel topPanelInfo = new JPanel();
	private JPanel bottomPanelInfo = new JPanel();
	private JLabel bottomInfoTitle = new JLabel("Bottom Panel Info");
	private JLabel topInfoTitle = new JLabel("Top Panel Info");
	private final JTextArea bottomInfo = new JTextArea("The bottom panel contains buttons to select which item you"
			+ " would like to manipulate on the mother board(top panel). \n\n\t - The clear button will remove all"
			+ " items from the \n\t mother board. \n\n\t - Selecting one of the brown gates will cause the gate to \t appear"
			+ " on the mother board, where you can move it \n\t around to your liking. \n\n\t - Selecting the red button"
			+ " will allow you to place the \n\t button anywhere on the mother board. \n\n\t - Click wire and select a start gate and and end gate. \n\t You must "
			+ " click on Wire again to draw a new wire\n\n\t - The light bulb button will make a light bulb appear \n\t for you to move"
			+ " around on the mother board. \n\n");
	private final JTextArea topInfo = new JTextArea("The top panel will contain your moveable and toggalable elements. Press"
			+ " buttons, move wires, toggle light bulbs etc. \n\n\t - Clicking a button will turn it green(on) until you"
			+ " \n\t press it again to turn it off. Having a button on will \n\t send a true signal to it's respective wire "
			+ " connected to a \n\t gate. \n\n\t -  Drag the logic gate or button and connected the wire \n\t will move with them \n\n\t - Drag the logic gate and light"
			+ " bulb in a position where \n\t they can receive signals from wires and buttons. The \n\t bulb will turn on if a true signal"
			+ " reaches it from a logic \n\t gate or button. \n\n\n\n\n");
	
	String text = "some really long string that might need to"+
            "be wrapped if the window is not wide enough";

JTextArea multi = new JTextArea(text);


	public HelpFrame() {

		// create frame
		super("Help screen"); // name frame
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // allow user to close frame
		this.setSize(1000, 500); // set frame size
		this.setLayout(null); // set layout to null(important)
		
		topPanelInfo.setBounds(0, 0, 500, 500);
		topPanelInfo.setBackground(Color.orange);
		
		bottomPanelInfo.setBounds(500, 0, 500, 500);
		bottomPanelInfo.setBackground(Color.pink);
		
		topInfoTitle.setFont(new Font("Serif", Font.BOLD, 20));
		bottomInfoTitle.setFont(new Font("Serif", Font.BOLD, 20));
		
		topInfo.setFont(new Font("Serif", Font.PLAIN, 15));
		bottomInfo.setFont(new Font("Serif", Font.PLAIN, 15));
		
		bottomInfo.setBounds(510,100, 450, 400);
		topInfo.setBounds(10,100, 450, 400);
		
		
		bottomInfo.setWrapStyleWord(true);
		bottomInfo.setLineWrap(true);
		bottomInfo.setEditable(false);
		
		topInfo.setWrapStyleWord(true);
		topInfo.setLineWrap(true);
		topInfo.setEditable(false);
		
		bottomPanelInfo.add(bottomInfoTitle, BorderLayout.SOUTH);
		topPanelInfo.add(topInfoTitle, BorderLayout.SOUTH);
		topPanelInfo.add(topInfo);
		bottomPanelInfo.add(bottomInfo);
		
		this.add(topPanelInfo);
		this.add(bottomPanelInfo);
		this.setVisible(true);
		
		
	}
	
}
