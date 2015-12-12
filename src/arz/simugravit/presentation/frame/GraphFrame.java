package arz.simugravit.presentation.frame;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import arz.simugravit.presentation.panel.GraphPanel;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class GraphFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4860487305301432907L;

	public GraphFrame(int width, int height) {

		GraphPanel graphPanel = new GraphPanel(width, height);

		 JScrollPane scroll = new JScrollPane(graphPanel,
		 JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		 JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		 
		 GridBagLayout layout = new GridBagLayout();
		 layout.columnWidths = new int [ ]{width};
		 layout.rowHeights = new int [ ]{height};
		 
		 getContentPane().setLayout(new GridBagLayout());
		
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;


		getContentPane().add(scroll, gbc);
	}
}
