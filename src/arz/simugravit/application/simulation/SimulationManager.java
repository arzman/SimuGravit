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

		_maxX = 10000000.0;
		_maxY = 10000000.0;

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

		int res = (int) (ContextManager.getInstance().getDoubleAttributeValue(i, ContextManager.POS_X) / _pasSpatial);

		return res;
	}

	public int getYfor(int i) throws SimuApplicationException {

		int res = (int) (ContextManager.getInstance().getDoubleAttributeValue(i, ContextManager.POS_Y) / _pasSpatial);

		return res;
	}

	public void launchSimu() {

		GraphFrameController.getInstance().openGraphFrameIfRequired();

		if (_thread == null) {
			_thread = new SimulationThread();
		}

		if (!_thread.isAlive()) {

			_thread.start();
		}

	}

	public void nextStep() throws SimuApplicationException {

		double[][] tmpArray = new double[3][6];

		for (int i = 0; i < ContextManager.getInstance().getNbrObject(); i++) {

			if (ContextManager.getInstance().getBooleanAttributeValue(i, ContextManager.IS_MOBILE)) {

				// position de l'objet i
				double Xi = ContextManager.getInstance().getDoubleAttributeValue(i, ContextManager.POS_X);
				double Yi = ContextManager.getInstance().getDoubleAttributeValue(i, ContextManager.POS_Y);

				// calcul de la variation de l'accélération
				double axi = 0.0;
				double ayi = 0.0;

				for (int j = 0; j < ContextManager.getInstance().getNbrObject(); j++) {

					if (j != i) {

						// récupération de la position de l'objet j
						double Xj = ContextManager.getInstance().getDoubleAttributeValue(j, ContextManager.POS_X);
						double Yj = ContextManager.getInstance().getDoubleAttributeValue(j, ContextManager.POS_Y);

						// norme de la force
						double dist = Math.sqrt((Xj - Xi) * (Xj - Xi) + (Yj - Yi) * (Yj - Yi));
						double mj = _g * ContextManager.getInstance().getDoubleAttributeValue(j, ContextManager.MASSE);
						double normF = mj / (dist * dist);

						// projection de la force sur les axes
						double daxi = ((Xj - Xi) / dist) * normF;
						double dayi = ((Yj - Yi) / dist) * normF;

						// System.out.println(" Force "+j+" : "+daxi+" ,
						// "+dayi);

						// variation de l'accélération
						axi = axi + daxi;
						ayi = ayi - dayi;

					}

				}
				// System.out.println(" accélération "+axi+" , "+ayi);

				// récupération et variation de la vitesse
				double vx = ContextManager.getInstance().getDoubleAttributeValue(i, ContextManager.VIT_X) + axi * _pasTemp;
				double vy = ContextManager.getInstance().getDoubleAttributeValue(i, ContextManager.VIT_Y) + ayi * _pasTemp;
				// System.out.println(" vitesse "+vx+" , "+vy);

				// récupération et variation de la position
				double nextX = Xi + vx * _pasTemp;
				double nextY = Yi - vy * _pasTemp;
				// System.out.println("position " +nextX+" , "+nextY);

				// mise en cache des nouvelles valeurs
				tmpArray[i][0] = nextX;
				tmpArray[i][1] = nextY;

				tmpArray[i][2] = vx;
				tmpArray[i][3] = vy;

				tmpArray[i][4] = axi;
				tmpArray[i][5] = ayi;

			}

		}

		// maj des positions
		for (int i = 0; i < ContextManager.getInstance().getNbrObject(); i++) {

			if (ContextManager.getInstance().getBooleanAttributeValue(i, ContextManager.IS_MOBILE)) {
				if (tmpArray[i] != null) {

					ContextManager.getInstance().updateDoubleObject(i, ContextManager.POS_X, tmpArray[i][0]);
					ContextManager.getInstance().updateDoubleObject(i, ContextManager.POS_Y, tmpArray[i][1]);
					ContextManager.getInstance().updateDoubleObject(i, ContextManager.VIT_X, tmpArray[i][2]);
					ContextManager.getInstance().updateDoubleObject(i, ContextManager.VIT_Y, tmpArray[i][3]);
					ContextManager.getInstance().updateDoubleObject(i, ContextManager.ACC_X, tmpArray[i][4]);
					ContextManager.getInstance().updateDoubleObject(i, ContextManager.ACC_Y, tmpArray[i][5]);

				}
			}

		}

	}

	public void stopSimu() {

		if (_thread != null) {

			_thread.pleaseStop();
			_thread = null;
		}

	}

}
