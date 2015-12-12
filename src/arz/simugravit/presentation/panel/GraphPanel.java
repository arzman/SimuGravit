package arz.simugravit.presentation.panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GraphPanel extends JPanel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8794067148313114285L;

	public GraphPanel(int width, int height) {
		
		setSize(width, height);
		setPreferredSize(getSize());
		setBackground(Color.WHITE);
		
		
		
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.setColor(Color.RED);
		g.fillOval(50, 50, 10, 10);
		
		
		g.setColor(Color.RED);
		g.fillOval(500, 500, 10, 10);
		
		
	}
	
	
	

	
}
