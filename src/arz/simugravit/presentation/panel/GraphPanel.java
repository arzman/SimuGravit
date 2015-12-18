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

		
		g.setColor(Color.RED);
		for(int i=0;i<ContextManager.getInstance().getNbrObject();i++){
					
			try {
				//System.out.println("Draw "+i+" at "+SimulationManager.getInstance().getXfor(i)+" , "+SimulationManager.getInstance().getYfor(i));
				g.fillOval(SimulationManager.getInstance().getXfor(i), SimulationManager.getInstance().getYfor(i), 10, 10);
			} catch (SimuApplicationException e) {
				// Allo Houston !!!
				//TODO stopper la simu et logguer un machin
			}
			
			
		}
		
		
	}
	
	
	

	
}
