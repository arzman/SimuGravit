package arz.simugravit.application;

public class SimulationManager {

	private static SimulationManager _instance;

	private double _pasSpatial;

	private double _pasTemp;

	private SimulationManager() {

		_pasSpatial = 100.0;

		_pasTemp = 60;

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

}
