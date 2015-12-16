package arz.simugravit.presentation.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import arz.simugravit.presentation.panel.GraphPanel;

public class GraphMouseListener implements MouseListener {

	private GraphPanel _graph;

	private int _lastX;

	private int _lastY;

	public GraphMouseListener(GraphPanel graph) {

		_graph = graph;
		_graph.addMouseListener(this);

		_lastX = 0;
		_lastY = 0;
	}

	public int getLastX() {
		return _lastX;
	}

	public int getLastY() {
		return _lastY;
	}

	public void dispose() {

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

		_lastX = e.getX();
		_lastY = e.getY();

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
