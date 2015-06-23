package arz.simugravit.presentation.panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GraphPanel extends JPanel{

	
	public GraphPanel() {
		
		setBackground(Color.WHITE);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.setColor(Color.RED);
		g.fillOval(50, 50, 10, 10);
		
		
	}
	
	
	

	
}
