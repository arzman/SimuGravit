package arz.simugravit.application.simulation;

import arz.simugravit.application.ContextManager;
import arz.simugravit.application.exception.SimuApplicationException;
import arz.simugravit.presentation.controller.GraphFrameController;

public class SimulationManager {

	private static SimulationManager _instance;

	private double _pasSpatial;

	private double _pasTemp;

	private double _maxX;

	private double _maxY;

	private double _g;
	
	private SimulationThread _thread;

	private SimulationManager() {

		_pasSpatial = 100.0;
		_pasTemp = 60.0;

		_maxX = 10000000000.0;
		_maxY = 10000000000.0;
		
		_g = 6.67384E-11;
		
		_thread = new SimulationThread();

	}

	public static SimulationManager getInstance() {

		if (_instance == null) {

			_instance = new SimulationManager();

		}

		return _instance;
	}

	public double getPasSpatial() {
		return _pasSpatial;
	}

	public void setPasSpatial(double pasSpatial) {
		_pasSpatial = pasSpatial;
	}

	public double getPasTemp() {
		return _pasTemp;
	}

	public void setPasTemp(double pasTemp) {
		_pasTemp = pasTemp;
	}

	public double getMaxY() {
		return _maxY;
	}

	public void setMaxY(double maxY) {

		if (maxY > 0) {
			_maxY = maxY;
		}

	}

	public double getMaxX() {
		return _maxX;
	}

	public void setMaxX(double maxX) {

		if (maxX > 0) {
			_maxX = maxX;
		}

	}

	public void stopAndClearSimu() {
		// TODO RaZ de la simulation

	}

	public double getG() {
		
		return _g;
	}

	public int getXfor(int i) throws SimuApplicationException {
		
		int res = (int) (ContextManager.getInstance().getDoubleAttributeValue(i, ContextManager.POS_X)/_pasSpatial);
		
		return res;
	}
	
	public int getYfor(int i) throws SimuApplicationException {
		
		int res = (int) (ContextManager.getInstance().getDoubleAttributeValue(i, ContextManager.POS_Y)/_pasSpatial);
		
		return res;
	}

	public void launchSimu() {
		
		GraphFrameController.getInstance().openGraphFrameIfRequired();
		
		_thread.start();
		
		
	}

	public void nextStep() throws SimuApplicationException {
		
		for(int i=0;i<ContextManager.getInstance().getNbrObject();i++){
			
			
			double nextX = ContextManager.getInstance().getDoubleAttributeValue(i, ContextManager.POS_X) + 2;
			double nextY = ContextManager.getInstance().getDoubleAttributeValue(i, ContextManager.POS_Y) +2;
			
			ContextManager.getInstance().updateDoubleObject(i, ContextManager.POS_X, nextX);
			ContextManager.getInstance().updateDoubleObject(i, ContextManager.POS_Y, nextY);
			
			
		}
		
		
	}

}
