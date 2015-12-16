package arz.simugravit.presentation.panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GraphPanel extends JPanel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8794067148313114285L;
	
	private int _width;
	
	private int _height;

	public GraphPanel(int width, int height) {
		
		_width = width;
		_height = height;
		
		setSize(_width, _height);
		setPreferredSize(getSize());
		setBackground(Color.BLACK);
		
		
		
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, _width, _height);
		
		g.setColor(Color.RED);
		g.fillOval(50, 50, 10, 10);
		
		
		g.setColor(Color.RED);
		g.fillOval(500, 500, 10, 10);
		
		
	}
	
	
	

	
}
