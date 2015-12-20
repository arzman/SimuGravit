package arz.simugravit.presentation.panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import arz.simugravit.application.ContextManager;
import arz.simugravit.application.exception.SimuApplicationException;
import arz.simugravit.application.simulation.SimulationManager;

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

		
		
		for(int i=0;i<ContextManager.getInstance().getNbrObject();i++){
			g.setColor(Color.RED);
			try {
				//System.out.println("Draw "+i+" at "+SimulationManager.getInstance().getXfor(i)+" , "+SimulationManager.getInstance().getYfor(i));
				int x=SimulationManager.getInstance().getXfor(i);
				int y=SimulationManager.getInstance().getYfor(i);
				
				double vx = ContextManager.getInstance().getDoubleAttributeValue(i, ContextManager.VIT_X);
				double vy = ContextManager.getInstance().getDoubleAttributeValue(i, ContextManager.VIT_Y);
				
				double n = Math.sqrt( vx*vx + vy*vy);
				int dx= (int) (20*vx/n);
				int dy= (int) (20*vy/n);
				
				g.fillOval(x-5, y-5, 10, 10);
				g.setColor(Color.BLUE);
				g.drawLine(x, y, x+dx, y-dy);
				
				double ax = ContextManager.getInstance().getDoubleAttributeValue(i, ContextManager.ACC_X);
				double ay = ContextManager.getInstance().getDoubleAttributeValue(i, ContextManager.ACC_Y);
				
				double na = Math.sqrt( ax*ax + ay*ay);
				int adx= (int) (20*ax/na);
				int ady= (int) (20*ay/na);
				
				g.setColor(Color.GREEN);
				g.drawLine(x, y, x+adx, y-ady);
				
			} catch (SimuApplicationException e) {
				// Allo Houston !!!
				//TODO stopper la simu et logguer un machin
			}
			
			
		}
		
		
	}

	
	
	

	
}
