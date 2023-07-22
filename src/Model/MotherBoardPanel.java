package Model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controller.Gate;
import Controller.LightBulb;
import Controller.SwitchButton;
import Controller.Wire;
import View.HelpFrame;
import View.Sample;

public class MotherBoardPanel extends JPanel {

	// create help button
	private JButton helpButton = new JButton("Help");

	// create sample gate simulator
	private JButton sample = new JButton("Sample");

	// get screen size
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	// create a list of gates
	private List<Gate> gates = null;

	// create wire
	private Wire wire = null;

	// make the default line drawing false
	private boolean drawingLine = false;

	// adding a gate method
	public void addGate(String type) {
		// use graphics to create a temp
		Graphics g = this.getGraphics();

		// create new gate object new gate
		Gate newGate = new Gate(type);

		// add the new gate to the gate class
		gates.add(newGate);

		// make sure the new gate is not null
		if (newGate != null) {
			Point ip = newGate.getImgPoint(); // get the points from the gates
			Graphics2D g2d = (Graphics2D) g.create(); // create the 2d graphic
			g2d.drawImage(newGate.getBi(), ip.x, ip.y, this); // draw the image/gate with coord
			g2d.dispose();// dispose g2d
		}
	}

	// add switch method
	public void addSwitch(boolean isOn) {
		Graphics g = this.getGraphics(); // create temp g graphic
		SwitchButton sw = new SwitchButton("SWITCH", isOn); // create new switch button
		gates.add(sw);// add switch to gate list

		// check if switch is null
		if (sw != null) {
			Point ip = sw.getImgPoint();// get the point coord for switch
			Graphics2D g2d = (Graphics2D) g.create();// create a new switch when moving
			g2d.drawImage(sw.getBi(), ip.x, ip.y, this); // draw new switch
			g2d.dispose();// dispose of g2d
		}
	}

	// add lightbulb method
	public void addLightBulb(boolean isOn) {
		Graphics g = this.getGraphics();// create temp g graphic
		LightBulb sw = new LightBulb("LIGHT", isOn);// create new switch button light
		gates.add(sw);// add switch light to gate list

		// check if switch is null
		if (sw != null) {
			Point ip = sw.getImgPoint();// get point coord for img
			Graphics2D g2d = (Graphics2D) g.create();// create new 2d graphic
			g2d.drawImage(sw.getBi(), ip.x, ip.y, this);// redraw the 2d graphic
			g2d.dispose();// dispose of original g2d
		}
	}

	// make adding a wire true
	public void addWire() {
		drawingLine = true;
	}

	// clear all elements on mother board
	public void clearAll() {
		// checks if list is empty and size > 0
		if (gates != null && gates.size() > 0) {
			// removes every element in gate list
			int size = gates.size();
			for (int i = size - 1; i >= 0; i--) {
				gates.remove(i);
			}
			// redraw frame with empty list
			repaint();
		}
	}

	// constructor
	public MotherBoardPanel() {

//		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		// Make Panel
		this.setBackground(new Color(17, 93, 51));
		this.setLayout(null);

		// get height and width
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();

		// create help button
		helpButton.setBounds(width - width / 10, 0, width / 10, height / 10);
		helpButton.setFont(new Font("Serif", Font.PLAIN, 25));
		helpButton.setBackground(Color.white);
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (helpButton.isEnabled()) {
					// open new help frame

					HelpFrame helpFrame = new HelpFrame();
				}
			}
		});

		// create help button
		sample.setBounds(width - (width / 10) - (width/10), 0, width / 10, height / 10);
		sample.setFont(new Font("Serif", Font.PLAIN, 25));
		sample.setBackground(Color.white);
		sample.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sample.isEnabled()) {
					// open new help frame

					Sample sample = new Sample();
				}
			}
		});

		// add help button
		this.add(helpButton);
		this.add(sample);

		// make the gates list into an array list
		gates = new ArrayList<Gate>();

		// make new mouse adapter
		MouseAdapter ma = new MouseAdapter() {

			// make offset point field
			private Point offset;

			@Override
			// make mouse pressed method
			public void mousePressed(MouseEvent e) {

				// get mouse point
				Point mp = e.getPoint();

				// check if user is drawing line
				if (drawingLine == true) {
//					Wire newWire = new Wire(mp, mp);

					// create new wire with mouse point
					wire = new Wire(mp, mp);

//					wires.add(newWire);
				} else

					// go through entire gate array
					for (Gate gate : gates) {
						// get bounds of image
						Rectangle bounds = gate.getImageBounds();

						// check if mouse is on the bounds of rectangle
						if (bounds.contains(mp)) {
							// make that gate selected true
							gate.setSelected(true);
							// make the offset a new point
							offset = new Point();

							// give offset coords
							offset.x = mp.x - bounds.x;
							offset.y = mp.y - bounds.y;
							return;
						}
					}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// remove every stored variable
				offset = null;
				drawingLine = false;
				wire = null;

				// deselect gate
				for (Gate gate : gates) {
					gate.setSelected(false);
				}
				// redraw everything
				repaint();
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// get mouse point
				Point mp = e.getPoint();

				// make sure offset is not null
				if (offset != null) {

					// look through all gates
					for (Gate gate : gates) {
						if (gate.getSelected()) {
							// make gate img points
							gate.getImgPoint().x = mp.x - offset.x;
							gate.getImgPoint().y = mp.y - offset.y;
						}
					}
					// redraw frame
					repaint();
				}
				// check if user is drawing a line
				if (drawingLine == true) {
					// set the end point of the wire to the mouse point
					wire.setEndPoint(mp);

					// make input and output gates
					Gate inputGate = null;
					Gate outputGate = null;

					// look through all gates
					for (Gate gate : gates) {

						// get the bounds of the rectangle
						Rectangle bounds = gate.getImageBounds();
						// make sure wire is moved
						if (wire.getStartPoint() != wire.getEndPoint()) {
							// declare input gate based on start of wire
							if (bounds.contains(wire.getStartPoint())) {
								inputGate = gate;
								continue;
							}
							// declare output gate based on end of wire
							if (bounds.contains(wire.getEndPoint())) {
								outputGate = gate;
								continue;
							}
						}
					}
					// input new connected gates
					if (inputGate != null && outputGate != null && inputGate != outputGate) {
						connectGates(inputGate, outputGate);
					}
					// redraw
					repaint();
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// get mouse point
				Point mp = e.getPoint();

				// look through all gates in gate list
				for (Gate gate : gates) {

					// get img bounds
					Rectangle bounds = gate.getImageBounds();

					// check if mouse is on image
					if (bounds.contains(mp)) {
						String type = gate.getType();

						// check if on switch gate
						if (type != null && type.equals("SWITCH")) {
							// turn off switch
							((SwitchButton) gate).turnOnOff();
						}
						// make offset
						offset = new Point();
						offset.x = mp.x - bounds.x;
						offset.y = mp.y - bounds.y;
						return;
					}
				}
			}

		};
		// add mouse effects
		addMouseListener(ma);
		addMouseMotionListener(ma);
	}

	// connected gate method
	public void connectGates(Gate inputGate, Gate targetGate) {
		// check for whats input gate
		if (inputGate == targetGate.getInputGate1() || inputGate == targetGate.getInputGate2()) {
			return;
		}
		// check if input gate 1 is null
		if (targetGate.getInputGate1() == null) {
			targetGate.setInputGate1(inputGate);
//			inputGate.setOutputGate(targetGate);
			return;

			// check if input gate 2 is null and not "NOT" and not "LIGHT"
		} else if (targetGate.getInputGate2() == null && !targetGate.getType().equals("NOT")
				&& !targetGate.getType().equals("LIGHT")) {
			targetGate.setInputGate2(inputGate);
			return;
		}

		return;

	}

	@Override
	// paint components
	protected void paintComponent(Graphics g) {
		// paint g
		super.paintComponent(g);

		// go through every gate
		for (Gate gate : gates) {
			// get img point
			Point ip = gate.getImgPoint();
			// make new 2d graphic
			Graphics2D g2d = (Graphics2D) g.create();
			// make gate based on coord
			g2d.drawImage(gate.getBi(), ip.x, ip.y, this);

			// cast to gate variable
			Gate inputGate1 = (Gate) gate.getInputGate1();

			// make sure 1st input gate is not null
			if (inputGate1 != null) {
				// draw the gate
				g2d.drawLine(inputGate1.getImgPoint().x + inputGate1.getImageBounds().width,
						inputGate1.getImgPoint().y + inputGate1.getImageBounds().height / 2, gate.getImgPoint().x,
						gate.getImgPoint().y + gate.getImageBounds().height / 8);
				if (gate.getType().equalsIgnoreCase("LIGHT")) {
					((LightBulb) gate).turnOnOff();
				}

			}

			// cast to gate variable
			Gate inputGate2 = (Gate) gate.getInputGate2();
			// make sure 2nd gate isnt null
			if (inputGate2 != null) {
				// draw gate
				g2d.drawLine(inputGate2.getImgPoint().x + inputGate2.getImageBounds().width,
						inputGate2.getImgPoint().y + inputGate2.getImageBounds().height / 2, gate.getImgPoint().x,
						gate.getImgPoint().y + gate.getImageBounds().height * 7 / 8);

			}
			repaint();// mandatory
			// dispose of temp
			g2d.dispose();
		}

		// check if user drawing line
		if (drawingLine == true) {
			// make temp 2d graphic
			Graphics2D g2d = (Graphics2D) g.create();
			// set properties
			g2d.setColor(Color.blue);
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setStroke(new BasicStroke(8, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));

			if (wire != null) {
				// set start and end points
				Point startP = wire.getStartPoint();
				Point endP = wire.getEndPoint();

				// draw line
				g.drawLine(startP.x, startP.y, endP.x, endP.y);
			}
		}
	}

}
