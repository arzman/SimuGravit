package arz.simugravit.presentation.listener;

import java.awt.GradientPaint;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import arz.simugravit.application.SimulationManager;
import arz.simugravit.presentation.panel.GraphPanel;

public class GraphMouseListener implements MouseListener{
	
	
	
	
	private GraphPanel _graph;
	
	
	private double _lastX;
	
	private double _lastY;
	
	
	
	public GraphMouseListener(GraphPanel graph) {
		
		_graph = graph;
		_graph.addMouseListener(this);
		
		_lastX = 0.0;
		_lastY = 0.0;
	}

	
	public double getLastX() {
		return _lastX;
	}



	public double getLastY() {
		return _lastY;
	}
	
	
	public void dispose(){
		
		_graph.removeMouseListener(this);
		
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
	
		
		_lastX = e.getX() * SimulationManager.getInstance().getPasSpatial();
		_lastY = e.getY() * SimulationManager.getInstance().getPasSpatial();
		
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	

}
