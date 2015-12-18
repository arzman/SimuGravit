package arz.simugravit.presentation.frame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import arz.simugravit.presentation.listener.GraphMouseListener;
import arz.simugravit.presentation.panel.GraphPanel;

public class GraphFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4860487305301432907L;

	private GraphPanel _graphPanel;

	private GraphMouseListener _zeGraphML;

	public GraphFrame(int width, int height) {

		_graphPanel = new GraphPanel(width, height);

		JScrollPane scroll = new JScrollPane(_graphPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		GridBagLayout layout = new GridBagLayout();
		layout.columnWidths = new int[] { width };
		layout.rowHeights = new int[] { height };

		getContentPane().setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;

		getContentPane().add(scroll, gbc);
		
		setSize(width+10, height+10);

		_zeGraphML = new GraphMouseListener(_graphPanel);
	}

	public GraphPanel getGraphPanel() {

		return _graphPanel;
	}

	/**
	 * Retourne la derniere coordonnée en X (en pixel) à laquelle un clic a été
	 * fait dans le panel
	 * 
	 * @return
	 */
	public int getLastX() {

		int res = 0;

		if (_zeGraphML != null) {
			res = _zeGraphML.getLastX();
		}

		return res;
	}

	/**
	 * Retourne la derniere coordonnée en Y (en pixel)à laquelle un clic a été
	 * fait dans le panel
	 * 
	 * @return
	 */
	public int getLastY() {

		int res = 0;

		if (_zeGraphML != null) {
			res = _zeGraphML.getLastY();
		}

		return res;
	}

	public void refreshGraphPanel() {
		
		
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				
				@Override
				public void run() {
					_graphPanel.repaint();
					
				}
			});
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
