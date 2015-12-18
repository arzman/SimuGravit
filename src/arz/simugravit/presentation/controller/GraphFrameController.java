package arz.simugravit.presentation.controller;

import arz.simugravit.application.simulation.SimulationManager;
import arz.simugravit.presentation.frame.GraphFrame;

public class GraphFrameController {

	private static GraphFrameController _instance;

	private GraphFrame _zeFrame;

	private GraphFrameController() {

	}

	public static GraphFrameController getInstance() {

		if (_instance == null) {

			_instance = new GraphFrameController();

		}

		return _instance;
	}

	public void openGraphFrame() {

		if (_zeFrame != null) {

			_zeFrame.dispose();
		}

		int width = (int) (SimulationManager.getInstance().getMaxX() / SimulationManager.getInstance().getPasSpatial());
		int height = (int) (SimulationManager.getInstance().getMaxY() / SimulationManager.getInstance().getPasSpatial());

		_zeFrame = new GraphFrame(width, height);
		_zeFrame.setVisible(true);

	}

	/**
	 * Retourne la derniere coordonnée en X (en mètre) à laquelle un clic a été
	 * fait dans la fenetre de simulation
	 * 
	 * @return
	 */
	public double getLastX() {

		if (_zeFrame == null) {
			openGraphFrame();
		}

		return _zeFrame.getLastX() * SimulationManager.getInstance().getPasSpatial();

	}

	/**
	 *  Retourne la derniere coordonnée en Y (en mètre) à laquelle un clic a été
	 * fait dans la fenetre de simulation
	 * @return
	 */
	public double getLastY() {

		if (_zeFrame == null) {
			openGraphFrame();
		}

		return _zeFrame.getLastY() * SimulationManager.getInstance().getPasSpatial();

	}

	public void openGraphFrameIfRequired() {
		
		if (_zeFrame == null) {

			int width = (int) (SimulationManager.getInstance().getMaxX() / SimulationManager.getInstance().getPasSpatial());
			int height = (int) (SimulationManager.getInstance().getMaxY() / SimulationManager.getInstance().getPasSpatial());

			_zeFrame = new GraphFrame(width, height);
			_zeFrame.setVisible(true);
		}
		
		_zeFrame.refreshGraphPanel();

		
		
		
	}

	public void refreshGraphPanel() {
		
		_zeFrame.refreshGraphPanel();
		
	}

	/**
	 * Centre la zone graphique sur les coordonnées saisies.
	 * @param xPixel
	 * @param yPixel
	 */
	public void centerOn(int xPixel, int yPixel) {
		
		_zeFrame.centerOn(xPixel,yPixel);
		
	}

}
