package View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Sample extends JFrame {

	private JLabel img = new JLabel(new ImageIcon("imagesSmall/complexGatesResized.jpg"));
	private JPanel imgPanel = new JPanel();

	public Sample() {
		// create frame
		super("Sample"); // name frame
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // allow user to close frame
		this.setSize(1000, 500); // set frame size
		this.setLayout(null); // set layout to null(important)
		
		imgPanel.setBounds(0,0, 1000,500);
		
		imgPanel.add(img);
		this.add(imgPanel);
		
		this.setVisible(true);
	}
}
