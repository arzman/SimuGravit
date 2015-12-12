package arz.simugravit.application;

public class SimulationManager {

	private static SimulationManager _instance;

	private double _pasSpatial;

	private double _pasTemp;
	
	private double _maxX;

	private double _maxY;

	private SimulationManager() {

		_pasSpatial = 100.0;
		_pasTemp = 60.0;
		
		
		setMaxX(10000000000.0);
		setMaxY(10000000000.0);

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
		_maxY = maxY;
	}

	public double getMaxX() {
		return _maxX;
	}

	public void setMaxX(double maxX) {
		_maxX = maxX;
	}

	public void stopAndClearSimu() {
		// TODO RaZ de la simulation
		
	}

}
