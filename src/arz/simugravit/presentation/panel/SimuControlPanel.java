package arz.simugravit.presentation.panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import arz.simugravit.application.simulation.SimulationManager;
import arz.simugravit.presentation.controller.GraphFrameController;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimuControlPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1541249713035496861L;

	private JTextField _pasSpaFld;

	private JTextField _pasTempFld;

	private JTextField _hautFld;

	private JTextField _largFld;

	private JButton _goBtn;

	private JButton _clearBtn;
	private JTextField _gTxtFld;

	public SimuControlPanel() {

		GridBagLayout gbl__simuGroup = new GridBagLayout();
		gbl__simuGroup.columnWidths = new int[] { 1, 0, 0 };
		gbl__simuGroup.rowHeights = new int[] { 1, 0, 0, 0 };
		gbl__simuGroup.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl__simuGroup.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gbl__simuGroup);

		JPanel _buttonPanel = new JPanel();
		GridBagConstraints gbc__buttonPanel = new GridBagConstraints();
		gbc__buttonPanel.gridwidth = 2;
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

		_goBtn = new JButton("Go !!!");
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

		_clearBtn = new JButton("Reset");
		GridBagConstraints gbc__clearBtn = new GridBagConstraints();
		gbc__clearBtn.fill = GridBagConstraints.BOTH;
		gbc__clearBtn.gridx = 0;
		gbc__clearBtn.gridy = 0;
		_buttonPanel.add(_clearBtn, gbc__clearBtn);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Pas de simulation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 1, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JPanel _spatialResPanel = new JPanel();
		GridBagConstraints gbc__spatialResPanel = new GridBagConstraints();
		gbc__spatialResPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc__spatialResPanel.insets = new Insets(0, 0, 5, 0);
		gbc__spatialResPanel.gridx = 0;
		gbc__spatialResPanel.gridy = 0;
		panel.add(_spatialResPanel, gbc__spatialResPanel);
		GridBagLayout gbl__spatialResPanel = new GridBagLayout();
		gbl__spatialResPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl__spatialResPanel.rowHeights = new int[] { 0 };
		gbl__spatialResPanel.columnWeights = new double[] { 0.0, 1.0, 0.0 };
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
		gbc__tempResPanel.gridy = 1;
		panel.add(_tempResPanel, gbc__tempResPanel);
		GridBagLayout gbl__tempResPanel = new GridBagLayout();
		gbl__tempResPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl__tempResPanel.rowHeights = new int[] { 0 };
		gbl__tempResPanel.columnWeights = new double[] { 0.0, 1.0, 0.0 };
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

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Taille de simulation", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 1, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JLabel hauteurLbl = new JLabel("Hauteur :");
		GridBagConstraints gbc_hauteurLbl = new GridBagConstraints();
		gbc_hauteurLbl.fill = GridBagConstraints.HORIZONTAL;
		gbc_hauteurLbl.insets = new Insets(0, 0, 0, 5);
		gbc_hauteurLbl.gridx = 0;
		gbc_hauteurLbl.gridy = 0;
		panel_2.add(hauteurLbl, gbc_hauteurLbl);

		_hautFld = new JTextField();
		_hautFld.setText(String.valueOf(SimulationManager.getInstance().getMaxY()));
		_hautFld.setColumns(10);
		GridBagConstraints gbc_hautFld = new GridBagConstraints();
		gbc_hautFld.fill = GridBagConstraints.HORIZONTAL;
		gbc_hautFld.insets = new Insets(0, 2, 0, 5);
		gbc_hautFld.gridx = 1;
		gbc_hautFld.gridy = 0;
		panel_2.add(_hautFld, gbc_hautFld);

		JLabel label_1 = new JLabel("M\u00E8tres");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 0;
		panel_2.add(label_1, gbc_label_1);

		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		panel_1.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		JLabel lblLargeur = new JLabel("Largeur :");
		GridBagConstraints gbc_lblLargeur = new GridBagConstraints();
		gbc_lblLargeur.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblLargeur.insets = new Insets(0, 0, 0, 5);
		gbc_lblLargeur.gridx = 0;
		gbc_lblLargeur.gridy = 0;
		panel_3.add(lblLargeur, gbc_lblLargeur);

		_largFld = new JTextField();
		_largFld.setText(String.valueOf(SimulationManager.getInstance().getMaxY()));
		_largFld.setColumns(10);
		GridBagConstraints gbc_largFld = new GridBagConstraints();
		gbc_largFld.fill = GridBagConstraints.HORIZONTAL;
		gbc_largFld.insets = new Insets(0, 2, 0, 5);
		gbc_largFld.gridx = 1;
		gbc_largFld.gridy = 0;
		panel_3.add(_largFld, gbc_largFld);

		JLabel lblMtres = new JLabel("M\u00E8tres");
		GridBagConstraints gbc_lblMtres = new GridBagConstraints();
		gbc_lblMtres.insets = new Insets(0, 0, 5, 0);
		gbc_lblMtres.gridx = 2;
		gbc_lblMtres.gridy = 0;
		panel_3.add(lblMtres, gbc_lblMtres);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Phyisque", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridwidth = 2;
		gbc_panel_4.insets = new Insets(0, 0, 0, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 2;
		add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{1, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 0;
		panel_4.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JLabel lblG = new JLabel("G :");
		GridBagConstraints gbc_lblG = new GridBagConstraints();
		gbc_lblG.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblG.insets = new Insets(0, 0, 0, 5);
		gbc_lblG.gridx = 0;
		gbc_lblG.gridy = 0;
		panel_5.add(lblG, gbc_lblG);
		
		_gTxtFld = new JTextField();
		_gTxtFld.setText(String.valueOf(SimulationManager.getInstance().getG()));
		_gTxtFld.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 2, 0, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_5.add(_gTxtFld, gbc_textField);
		
		JLabel lblSi = new JLabel("S.I");
		GridBagConstraints gbc_lblSi = new GridBagConstraints();
		gbc_lblSi.gridx = 2;
		gbc_lblSi.gridy = 0;
		panel_5.add(lblSi, gbc_lblSi);

		hookListeners();

	}

	private void hookListeners() {

		_clearBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				SimulationManager.getInstance().stopAndClearSimu();

				try {
					double maxX = Double.parseDouble(_largFld.getText());
					SimulationManager.getInstance().setMaxX(maxX);
				} catch (NumberFormatException ex) {
					SimulationManager.getInstance().setMaxX(-1);
					_largFld.setText(String.valueOf(SimulationManager.getInstance().getMaxX()));
				}

				try {
					double maxY = Double.parseDouble(_hautFld.getText());
					SimulationManager.getInstance().setMaxY(maxY);
				} catch (NumberFormatException ex) {
					SimulationManager.getInstance().setMaxY(-1);
					_hautFld.setText(String.valueOf(SimulationManager.getInstance().getMaxY()));
				}

				GraphFrameController.getInstance().openGraphFrame();

			}
		});
		
		
		_goBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SimulationManager.getInstance().launchSimu();
				
			}
		});

	}
}
