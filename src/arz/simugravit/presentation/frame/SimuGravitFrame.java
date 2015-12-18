package arz.simugravit.presentation.frame;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import arz.simugravit.application.exception.SimuApplicationException;
import arz.simugravit.presentation.panel.CreateObjetPanel;
import arz.simugravit.presentation.panel.SimuControlPanel;

public class SimuGravitFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1541249713035496861L;

	public SimuGravitFrame() {

		setTitle("Simu Gravit V1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0 };
		gridBagLayout.rowHeights = new int[] { 0 };
		gridBagLayout.columnWeights = new double[] { 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0 };
		getContentPane().setLayout(gridBagLayout);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Simulation Control", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		getContentPane().add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		SimuControlPanel simuControlPanel = new SimuControlPanel();
		GridBagConstraints gbc_simuControlPanel = new GridBagConstraints();
		gbc_simuControlPanel.anchor = GridBagConstraints.NORTH;
		gbc_simuControlPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_simuControlPanel.gridx = 0;
		gbc_simuControlPanel.gridy = 0;
		panel_2.add(simuControlPanel, gbc_simuControlPanel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Objects", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0,
				0)));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		CreateObjetPanel createObjetPanel;
		try {
			createObjetPanel = new CreateObjetPanel();
		
		GridBagConstraints gbc_createObjetPanel = new GridBagConstraints();
		gbc_createObjetPanel.fill = GridBagConstraints.BOTH;
		gbc_createObjetPanel.gridx = 0;
		gbc_createObjetPanel.gridy = 0;
		panel_1.add(createObjetPanel, gbc_createObjetPanel);
		} catch (SimuApplicationException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage(), "Impossible de créer la fenêtre", JOptionPane.ERROR_MESSAGE);
			
		}

		pack();

	}

}
