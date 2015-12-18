package arz.simugravit.application;

import arz.simugravit.application.exception.SimuApplicationException;

public class SimulationManager {

	private static SimulationManager _instance;

	private double _pasSpatial;

	private double _pasTemp;

	private double _maxX;

	private double _maxY;

	private double _g;

	private SimulationManager() {

		_pasSpatial = 100.0;
		_pasTemp = 60.0;

		_maxX = 10000000000.0;
		_maxY = 10000000000.0;
		
		_g = 6.67384E-11;

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

}
