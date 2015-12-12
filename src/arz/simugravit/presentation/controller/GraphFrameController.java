package arz.simugravit.presentation.controller;

import java.awt.event.MouseListener;

import arz.simugravit.application.SimulationManager;
import arz.simugravit.presentation.frame.GraphFrame;

public class GraphFrameController {
	
	
	private static GraphFrameController _instance;
	
	
	private GraphFrame _zeFrame;
	
	
	private MouseListener _zeGraphML;
	
	
	private GraphFrameController(){
		
		
		//_zeGraphML = new 
		
	}
	

	public static GraphFrameController getInstance() {
		
		
		if(_instance ==null){
			
			_instance = new GraphFrameController();
			
		}
		
		return _instance;
	}


	public void openGraphFrame() {
		
		
		
		if(_zeFrame == null){
			
			
			int width = (int) (SimulationManager.getInstance().getMaxX() / SimulationManager.getInstance().getPasSpatial());
			int height = (int) (SimulationManager.getInstance().getMaxY() / SimulationManager.getInstance().getPasSpatial());
			
			_zeFrame = new GraphFrame(width, height);
			_zeFrame.setVisible(true);
			
		}else{
			
			
			_zeFrame.dispose();
			
			int width = (int) (SimulationManager.getInstance().getMaxX() / SimulationManager.getInstance().getPasSpatial());
			int height = (int) (SimulationManager.getInstance().getMaxY() / SimulationManager.getInstance().getPasSpatial());
			
			_zeFrame = new GraphFrame(width, height);
			_zeFrame.setVisible(true);
			
		}
		
		
	}

}
