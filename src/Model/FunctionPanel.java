package Model;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class FunctionPanel extends JPanel{

	private JButton clear = new JButton("clear");
	
	//only if there is time
	
	private JButton or = new JButton(new ImageIcon("imagesSmall/orButton.png"));
	private JButton xor = new JButton(new ImageIcon("imagesSmall/xorButton.png"));
	private JButton nor = new JButton(new ImageIcon("imagesSmall/norButton.png"));
	private JButton xnor = new JButton(new ImageIcon("imagesSmall/xnorButton.png"));
	private JButton and = new JButton(new ImageIcon("imagesSmall/andButton.png"));
	private JButton not = new JButton(new ImageIcon("imagesSmall/notButton.png"));
	private JButton nand = new JButton(new ImageIcon("imagesSmall/nandButton.png"));
	private JButton redButton = new JButton(new ImageIcon("imagesSmall/redButton.png"));
	private JButton wire = new JButton(new ImageIcon("imagesSmall/wire.png"));
	private JButton lightBulbOff = new JButton(new ImageIcon("imagesSmall/lightBulbOff.png"));
	
	public FunctionPanel(MotherBoardPanel mb) {
		
		this.setBackground(Color.white);
		this.setLayout(new FlowLayout());
		
		//create buttons to add components to mother board
		
		clear.setBackground(Color.red);
		clear.setFont(new Font("Serif", Font.BOLD, 20));
		clear.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	//clear mother board
		    	mb.clearAll();
		    }
		});

		or.setBackground(Color.white);
		or.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	//add to mother board
		    	mb.addGate("OR");
		    }
		});
		nor.setBackground(Color.white);
		nor.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	//add to mother board
		    	mb.addGate("NOR");
		    }
		});
		
		and.setBackground(Color.white);
		and.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	//add to mother board
		    	mb.addGate("AND");
		    }
		});
		nand.setBackground(Color.white);
		nand.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	//add to mother board
		    	mb.addGate("NAND");
		    }
		});
		wire.setBackground(Color.white);
		wire.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	//add to mother board
		    	mb.addWire();
		    }
		});
		
		xor.setBackground(Color.white);
		xor.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	//add to mother board
		    	mb.addGate("XOR");
		    }
		});
		xnor.setBackground(Color.white);
		xnor.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	//add to mother board
		    	mb.addGate("XNOR");
		    }
		});
		
		not.setBackground(Color.white);
		not.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	//add to mother board
		    	mb.addGate("NOT");
		    }
		});
		
		redButton.setBackground(Color.white);
		redButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	//add to mother board
		    	mb.addSwitch(false);
		    }
		});
		
		lightBulbOff.setBackground(Color.white);
		lightBulbOff.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	//add to mother board
		    	mb.addLightBulb(false);
		    }
		});
			
		//add buttons
		this.add(clear);
		this.add(wire);
		this.add(or);
		this.add(nor);
		this.add(and);
		this.add(nand);
		this.add(xor);
		this.add(xnor);
		this.add(not);
		this.add(not);
		this.add(redButton);
		this.add(lightBulbOff);
	}
}
