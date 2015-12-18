package arz.simugravit.presentation.panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import arz.simugravit.application.ContextManager;
import arz.simugravit.application.exception.SimuApplicationException;
import arz.simugravit.presentation.controller.GraphFrameController;

import javax.swing.JButton;

public class ObjetPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5429232630888787340L;
	private JTextField _posXFld;
	private JTextField _posYFld;
	private JTextField _nrmVitFld;
	private JTextField _anglVitFld;
	private JTextField _massFld;

	private final int _num;
	private JButton _setPositionBtn;
	private JCheckBox _isMobilChck;
	private JButton _centerBtn;

	public ObjetPanel(int num) throws SimuApplicationException {

		_num = num;

		setBorder(new TitledBorder(null, "Objet n\u00B0 " + _num, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0 };
		setLayout(gridBagLayout);

		JPanel positionGroup = new JPanel();
		positionGroup.setBorder(new TitledBorder(null, "Position", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_positionGroup = new GridBagConstraints();
		gbc_positionGroup.insets = new Insets(0, 0, 5, 5);
		gbc_positionGroup.fill = GridBagConstraints.HORIZONTAL;
		gbc_positionGroup.gridx = 0;
		gbc_positionGroup.gridy = 0;
		add(positionGroup, gbc_positionGroup);
		GridBagLayout gbl_positionGroup = new GridBagLayout();
		gbl_positionGroup.columnWeights = new double[] { 0.0, 1.0, 0.0 };
		positionGroup.setLayout(gbl_positionGroup);

		JLabel xLbl = new JLabel("X :");
		GridBagConstraints gbc_xLbl = new GridBagConstraints();
		gbc_xLbl.insets = new Insets(0, 0, 5, 5);
		gbc_xLbl.anchor = GridBagConstraints.SOUTHWEST;
		gbc_xLbl.gridx = 0;
		gbc_xLbl.gridy = 0;
		positionGroup.add(xLbl, gbc_xLbl);

		_posXFld = new JTextField();
		GridBagConstraints gbc_posXFld = new GridBagConstraints();
		gbc_posXFld.insets = new Insets(0, 0, 5, 5);
		gbc_posXFld.fill = GridBagConstraints.HORIZONTAL;
		gbc_posXFld.gridx = 1;
		gbc_posXFld.gridy = 0;
		positionGroup.add(_posXFld, gbc_posXFld);
		_posXFld.setColumns(10);
		_posXFld.setText(String.valueOf(ContextManager.getInstance().getDoubleAttributeValue(_num, ContextManager.POS_X)));

		JLabel xunitLbl = new JLabel("m\u00E8tre(s)");
		GridBagConstraints gbc_xunitLbl = new GridBagConstraints();
		gbc_xunitLbl.insets = new Insets(0, 0, 5, 0);
		gbc_xunitLbl.gridx = 2;
		gbc_xunitLbl.gridy = 0;
		positionGroup.add(xunitLbl, gbc_xunitLbl);

		JLabel YLbl = new JLabel("Y : ");
		GridBagConstraints gbc_YLbl = new GridBagConstraints();
		gbc_YLbl.anchor = GridBagConstraints.EAST;
		gbc_YLbl.insets = new Insets(0, 0, 5, 5);
		gbc_YLbl.gridx = 0;
		gbc_YLbl.gridy = 1;
		positionGroup.add(YLbl, gbc_YLbl);

		_posYFld = new JTextField();
		_posYFld.setColumns(10);
		GridBagConstraints gbc_posYFld = new GridBagConstraints();
		gbc_posYFld.insets = new Insets(0, 0, 5, 5);
		gbc_posYFld.fill = GridBagConstraints.HORIZONTAL;
		gbc_posYFld.gridx = 1;
		gbc_posYFld.gridy = 1;
		positionGroup.add(_posYFld, gbc_posYFld);
		_posYFld.setText(String.valueOf(ContextManager.getInstance().getDoubleAttributeValue(_num, ContextManager.POS_Y)));

		JLabel xUnitLbl = new JLabel("m\u00E8tre(s)");
		GridBagConstraints gbc_xUnitLbl = new GridBagConstraints();
		gbc_xUnitLbl.insets = new Insets(0, 0, 5, 0);
		gbc_xUnitLbl.gridx = 2;
		gbc_xUnitLbl.gridy = 1;
		positionGroup.add(xUnitLbl, gbc_xUnitLbl);

		JPanel positionBtnPanel = new JPanel();
		GridBagConstraints gbc_positionBtnPanel = new GridBagConstraints();
		gbc_positionBtnPanel.gridwidth = 3;
		gbc_positionBtnPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_positionBtnPanel.gridx = 0;
		gbc_positionBtnPanel.gridy = 2;
		positionGroup.add(positionBtnPanel, gbc_positionBtnPanel);
		GridBagLayout gbl_positionBtnPanel = new GridBagLayout();
		gbl_positionBtnPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_positionBtnPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_positionBtnPanel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_positionBtnPanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		positionBtnPanel.setLayout(gbl_positionBtnPanel);

		_setPositionBtn = new JButton("import");
		GridBagConstraints gbc_setPositionBtn = new GridBagConstraints();
		gbc_setPositionBtn.gridx = 0;
		gbc_setPositionBtn.gridy = 0;
		positionBtnPanel.add(_setPositionBtn, gbc_setPositionBtn);

		JButton centerBtn = new JButton("Centrer");
		GridBagConstraints gbc_centerBtn = new GridBagConstraints();
		gbc_centerBtn.gridx = 1;
		gbc_centerBtn.gridy = 0;
		positionBtnPanel.add(centerBtn, gbc_centerBtn);

		JPanel vitesseGroup = new JPanel();
		vitesseGroup.setBorder(new TitledBorder(null, "Vitesse", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_vitesseGroup = new GridBagConstraints();
		gbc_vitesseGroup.insets = new Insets(0, 0, 5, 0);
		gbc_vitesseGroup.fill = GridBagConstraints.BOTH;
		gbc_vitesseGroup.gridx = 1;
		gbc_vitesseGroup.gridy = 0;
		add(vitesseGroup, gbc_vitesseGroup);
		GridBagLayout gbl_vitesseGroup = new GridBagLayout();
		gbl_vitesseGroup.columnWeights = new double[] { 0.0, 1.0, 0.0 };
		vitesseGroup.setLayout(gbl_vitesseGroup);

		JLabel intLbl = new JLabel("Norme :");
		GridBagConstraints gbc_intLbl = new GridBagConstraints();
		gbc_intLbl.fill = GridBagConstraints.BOTH;
		gbc_intLbl.insets = new Insets(0, 0, 5, 5);
		gbc_intLbl.gridx = 0;
		gbc_intLbl.gridy = 0;
		vitesseGroup.add(intLbl, gbc_intLbl);
		

		_nrmVitFld = new JTextField();
		_nrmVitFld.setColumns(10);
		GridBagConstraints gbc_nrmVitFld = new GridBagConstraints();
		gbc_nrmVitFld.fill = GridBagConstraints.BOTH;
		gbc_nrmVitFld.insets = new Insets(0, 0, 5, 5);
		gbc_nrmVitFld.gridx = 1;
		gbc_nrmVitFld.gridy = 0;
		vitesseGroup.add(_nrmVitFld, gbc_nrmVitFld);
		_nrmVitFld.setText(String.valueOf(ContextManager.getInstance().getDoubleAttributeValue(_num, ContextManager.NORME_VIT)));

		JLabel nrmVitUnitLbl = new JLabel("m/s");
		GridBagConstraints gbc_nrmVitUnitLbl = new GridBagConstraints();
		gbc_nrmVitUnitLbl.fill = GridBagConstraints.BOTH;
		gbc_nrmVitUnitLbl.insets = new Insets(0, 0, 5, 5);
		gbc_nrmVitUnitLbl.gridx = 2;
		gbc_nrmVitUnitLbl.gridy = 0;
		vitesseGroup.add(nrmVitUnitLbl, gbc_nrmVitUnitLbl);

		JLabel anglVitLbl = new JLabel("Orientation :");
		GridBagConstraints gbc_anglVitLbl = new GridBagConstraints();
		gbc_anglVitLbl.fill = GridBagConstraints.BOTH;
		gbc_anglVitLbl.insets = new Insets(0, 0, 5, 0);
		gbc_anglVitLbl.gridx = 0;
		gbc_anglVitLbl.gridy = 1;
		vitesseGroup.add(anglVitLbl, gbc_anglVitLbl);

		_anglVitFld = new JTextField();
		_anglVitFld.setColumns(10);
		GridBagConstraints gbc_anglVitFld = new GridBagConstraints();
		gbc_anglVitFld.fill = GridBagConstraints.BOTH;
		gbc_anglVitFld.insets = new Insets(0, 0, 0, 5);
		gbc_anglVitFld.gridx = 1;
		gbc_anglVitFld.gridy = 1;
		vitesseGroup.add(_anglVitFld, gbc_anglVitFld);
		_anglVitFld.setText(String.valueOf(ContextManager.getInstance().getDoubleAttributeValue(_num, ContextManager.ORIEN_VIT)));

		JLabel anglVitUnitLbl = new JLabel("degr\u00E9s");
		GridBagConstraints gbc_anglVitUnitLbl = new GridBagConstraints();
		gbc_anglVitUnitLbl.fill = GridBagConstraints.BOTH;
		gbc_anglVitUnitLbl.insets = new Insets(0, 0, 0, 5);
		gbc_anglVitUnitLbl.gridx = 2;
		gbc_anglVitUnitLbl.gridy = 1;
		vitesseGroup.add(anglVitUnitLbl, gbc_anglVitUnitLbl);

		JPanel propGroup = new JPanel();
		propGroup.setBorder(new TitledBorder(null, "Propri\u00E9t\u00E9s", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_propGroup = new GridBagConstraints();
		gbc_propGroup.gridwidth = 2;
		gbc_propGroup.fill = GridBagConstraints.BOTH;
		gbc_propGroup.gridx = 0;
		gbc_propGroup.gridy = 1;
		add(propGroup, gbc_propGroup);
		GridBagLayout gbl_propGroup = new GridBagLayout();
		gbl_propGroup.columnWeights = new double[] { 0.0, 0.0 };
		propGroup.setLayout(gbl_propGroup);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		propGroup.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0 };
		panel.setLayout(gbl_panel);

		JLabel lblMasse = new JLabel("masse : ");
		GridBagConstraints gbc_lblMasse = new GridBagConstraints();
		gbc_lblMasse.insets = new Insets(0, 0, 0, 5);
		gbc_lblMasse.gridx = 0;
		gbc_lblMasse.gridy = 0;
		panel.add(lblMasse, gbc_lblMasse);

		_massFld = new JTextField();
		GridBagConstraints gbc_massFld = new GridBagConstraints();
		gbc_massFld.fill = GridBagConstraints.HORIZONTAL;
		gbc_massFld.insets = new Insets(0, 0, 0, 5);
		gbc_massFld.gridx = 1;
		gbc_massFld.gridy = 0;
		panel.add(_massFld, gbc_massFld);
		_massFld.setColumns(10);
		_massFld.setText(String.valueOf(ContextManager.getInstance().getDoubleAttributeValue(_num, ContextManager.MASSE)));

		JLabel massUnitLbl = new JLabel("Kg");
		GridBagConstraints gbc_massUnitLbl = new GridBagConstraints();
		gbc_massUnitLbl.gridx = 2;
		gbc_massUnitLbl.gridy = 0;
		panel.add(massUnitLbl, gbc_massUnitLbl);

		_isMobilChck = new JCheckBox("est mobile");
		GridBagConstraints gbc__isMobilChck = new GridBagConstraints();
		gbc__isMobilChck.gridx = 1;
		gbc__isMobilChck.gridy = 0;
		propGroup.add(_isMobilChck, gbc__isMobilChck);
		_isMobilChck.setSelected(ContextManager.getInstance().getBooleanAttributeValue(_num, ContextManager.IS_MOBILE));
		hookListener();
	}

	/**
	 * Mise en place des actions sur les boutons
	 */
	private void hookListener() {

		// import de la position dans les champs
		_setPositionBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				_posXFld.setText(String.valueOf(GraphFrameController.getInstance().getLastX()));
				_posYFld.setText(String.valueOf(GraphFrameController.getInstance().getLastY()));

			}
		});

		_centerBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// TODO centrer sur l'objet

			}
		});

	}

	public void writeObject() throws SimuApplicationException {
		
		
		ContextManager.getInstance().updateObject(_num, ContextManager.IS_MOBILE, String.valueOf(_isMobilChck.isSelected()));
		ContextManager.getInstance().updateObject(_num, ContextManager.POS_X, _posXFld.getText());
		ContextManager.getInstance().updateObject(_num, ContextManager.POS_Y, _posYFld.getText());
		ContextManager.getInstance().updateObject(_num, ContextManager.NORME_VIT, _nrmVitFld.getText());
		ContextManager.getInstance().updateObject(_num, ContextManager.ORIEN_VIT, _anglVitFld.getText());
		
		
	}

	

}
