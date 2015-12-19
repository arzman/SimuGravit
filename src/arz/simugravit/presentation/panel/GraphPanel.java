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
	
	private final double deg_to_rad = Math.PI/180;

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
		for(int i=0;i<ContextManager.getInstance().getNbrObject();i++){
					
			try {
				//System.out.println("Draw "+i+" at "+SimulationManager.getInstance().getXfor(i)+" , "+SimulationManager.getInstance().getYfor(i));
				int x=SimulationManager.getInstance().getXfor(i);
				int y=SimulationManager.getInstance().getYfor(i);
				
				double ang = ContextManager.getInstance().getDoubleAttributeValue(i, ContextManager.ORIEN_VIT);
				
				int dx=(int) (20*Math.cos(ang*deg_to_rad));
				int dy=(int) (20*Math.sin(ang*deg_to_rad));
				
				g.fillOval(x-5, y-5, 10, 10);
				g.drawLine(x, y, x+dx, y-dy);
			} catch (SimuApplicationException e) {
				// Allo Houston !!!
				//TODO stopper la simu et logguer un machin
			}
			
			
		}
		
		
	}

	
	
	

	
}
