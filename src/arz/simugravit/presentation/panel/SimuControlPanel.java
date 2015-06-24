package arz.simugravit.presentation.panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import arz.simugravit.application.SimulationManager;

public class SimuControlPanel extends JPanel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1541249713035496861L;
	
	private JTextField _pasSpaFld;
	
	private JTextField _pasTempFld;
	
	
	public SimuControlPanel() {

		GridBagLayout gbl__simuGroup = new GridBagLayout();
		gbl__simuGroup.columnWidths = new int[] { 1, 0 };
		gbl__simuGroup.rowHeights = new int[] { 1, 0, 0, 0 };
		gbl__simuGroup.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl__simuGroup.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gbl__simuGroup);

		JPanel _buttonPanel = new JPanel();
		GridBagConstraints gbc__buttonPanel = new GridBagConstraints();
		gbc__buttonPanel.insets = new Insets(0, 0, 5, 0);
		gbc__buttonPanel.fill = GridBagConstraints.BOTH;
		gbc__buttonPanel.gridx = 0;
		gbc__buttonPanel.gridy = 0;
		add(_buttonPanel, gbc__buttonPanel);
		GridBagLayout gbl__buttonPanel = new GridBagLayout();
		gbl__buttonPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl__buttonPanel.rowHeights = new int[] { 0 };
		gbl__buttonPanel.columnWeights = new double[] { 1.0, 1.0, 1.0 };
		gbl__buttonPanel.rowWeights = new double[] { 0.0 };
		_buttonPanel.setLayout(gbl__buttonPanel);

		JButton _goBtn = new JButton("Go !!!");
		GridBagConstraints gbc__goBtn = new GridBagConstraints();
		gbc__goBtn.fill = GridBagConstraints.BOTH;
		gbc__goBtn.gridx = 1;
		gbc__goBtn.gridy = 0;
		_buttonPanel.add(_goBtn, gbc__goBtn);

		JButton _stopBtn = new JButton("Stop");
		GridBagConstraints gbc__stopBtn = new GridBagConstraints();
		gbc__stopBtn.fill = GridBagConstraints.BOTH;
		gbc__stopBtn.gridx = 2;
		gbc__stopBtn.gridy = 0;
		_buttonPanel.add(_stopBtn, gbc__stopBtn);

		JButton _clearBtn = new JButton("Reset");
		GridBagConstraints gbc__clearBtn = new GridBagConstraints();
		gbc__clearBtn.fill = GridBagConstraints.BOTH;
		gbc__clearBtn.gridx = 0;
		gbc__clearBtn.gridy = 0;
		_buttonPanel.add(_clearBtn, gbc__clearBtn);

		JPanel _spatialResPanel = new JPanel();
		GridBagConstraints gbc__spatialResPanel = new GridBagConstraints();
		gbc__spatialResPanel.insets = new Insets(0, 0, 5, 0);
		gbc__spatialResPanel.fill = GridBagConstraints.BOTH;
		gbc__spatialResPanel.gridx = 0;
		gbc__spatialResPanel.gridy = 1;
		
		add(_spatialResPanel, gbc__spatialResPanel);
		GridBagLayout gbl__spatialResPanel = new GridBagLayout();
		gbl__spatialResPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl__spatialResPanel.rowHeights = new int[] { 0 };
		gbl__spatialResPanel.columnWeights = new double[] { 0.0, 0.0, 0.0 };
		gbl__spatialResPanel.rowWeights = new double[] { 0.0 };
		_spatialResPanel.setLayout(gbl__spatialResPanel);

		JLabel pasSpaLbl = new JLabel("Pas Spatial :");
		GridBagConstraints gbc_pasSpaLbl = new GridBagConstraints();
		gbc_pasSpaLbl.fill = GridBagConstraints.HORIZONTAL;
		gbc_pasSpaLbl.gridx = 0;
		gbc_pasSpaLbl.gridy = 0;
		_spatialResPanel.add(pasSpaLbl, gbc_pasSpaLbl);

		_pasSpaFld = new JTextField();
		GridBagConstraints gbc__pasSpaFld = new GridBagConstraints();
		gbc__pasSpaFld.insets = new Insets(0, 2, 0, 2);
		gbc__pasSpaFld.fill = GridBagConstraints.HORIZONTAL;
		gbc__pasSpaFld.gridx = 1;
		gbc__pasSpaFld.gridy = 0;
		_spatialResPanel.add(_pasSpaFld, gbc__pasSpaFld);
		_pasSpaFld.setColumns(10);
		_pasSpaFld.setText(String.valueOf(SimulationManager.getInstance().getPasSpatial()));

		JLabel spatiaUnitLbl = new JLabel("M\u00E8tres");
		GridBagConstraints gbc_spatiaUnitLbl = new GridBagConstraints();
		gbc_spatiaUnitLbl.gridx = 2;
		gbc_spatiaUnitLbl.gridy = 0;
		_spatialResPanel.add(spatiaUnitLbl, gbc_spatiaUnitLbl);

		JPanel _tempResPanel = new JPanel();
		GridBagConstraints gbc__tempResPanel = new GridBagConstraints();
		gbc__tempResPanel.fill = GridBagConstraints.BOTH;
		gbc__tempResPanel.gridx = 0;
		gbc__tempResPanel.gridy = 2;
		add(_tempResPanel, gbc__tempResPanel);
		GridBagLayout gbl__tempResPanel = new GridBagLayout();
		gbl__tempResPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl__tempResPanel.rowHeights = new int[] { 0 };
		gbl__tempResPanel.columnWeights = new double[] { 0.0, 0.0, 0.0 };
		gbl__tempResPanel.rowWeights = new double[] { 0.0 };
		_tempResPanel.setLayout(gbl__tempResPanel);

		JLabel lblPasTemporel = new JLabel("Pas Temporel :");
		GridBagConstraints gbc_lblPasTemporel = new GridBagConstraints();
		gbc_lblPasTemporel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPasTemporel.insets = new Insets(0, 0, 5, 5);
		gbc_lblPasTemporel.gridx = 0;
		gbc_lblPasTemporel.gridy = 0;
		_tempResPanel.add(lblPasTemporel, gbc_lblPasTemporel);

		_pasTempFld = new JTextField();
		_pasTempFld.setColumns(10);
		_pasTempFld.setText(String.valueOf(SimulationManager.getInstance().getPasTemp()));
		GridBagConstraints gbc__pasTempFld = new GridBagConstraints();
		gbc__pasTempFld.fill = GridBagConstraints.HORIZONTAL;
		gbc__pasTempFld.insets = new Insets(0, 2, 5, 5);
		gbc__pasTempFld.gridx = 1;
		gbc__pasTempFld.gridy = 0;
		_tempResPanel.add(_pasTempFld, gbc__pasTempFld);

		JLabel tempUnitLbl = new JLabel("Sec");
		GridBagConstraints gbc_tempUnitLbl = new GridBagConstraints();
		gbc_tempUnitLbl.insets = new Insets(0, 0, 5, 0);
		gbc_tempUnitLbl.gridx = 2;
		gbc_tempUnitLbl.gridy = 0;
		_tempResPanel.add(tempUnitLbl, gbc_tempUnitLbl);
		
	}

}
