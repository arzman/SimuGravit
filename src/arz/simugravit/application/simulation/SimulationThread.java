package arz.simugravit.application.simulation;

import arz.simugravit.application.exception.SimuApplicationException;
import arz.simugravit.presentation.controller.GraphFrameController;

public class SimulationThread extends Thread {
	
	
	
	
	@Override
	public void run() {
		
		
		
		try {
			SimulationManager.getInstance().nextStep();
		} catch (SimuApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GraphFrameController.getInstance().refreshGraphPanel();
		
		
	}

}
