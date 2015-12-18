package arz.simugravit.application.simulation;

import arz.simugravit.application.exception.SimuApplicationException;
import arz.simugravit.presentation.controller.GraphFrameController;

public class SimulationThread extends Thread {

	
	private boolean _run;
	
	public SimulationThread() {
		
		_run = true;
		
	}
		
	
	@Override
	public void run() {

		while (_run) {

			try {
				Thread.sleep(200);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				SimulationManager.getInstance().nextStep();
			} catch (SimuApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			GraphFrameController.getInstance().refreshGraphPanel();

		}

	}

	public void pleaseStop() {
		
		_run = false;
		
	}

}
