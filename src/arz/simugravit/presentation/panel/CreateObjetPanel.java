package arz.simugravit.presentation.panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CreateObjetPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7821326404226866812L;
	private JButton _createButton;

	public CreateObjetPanel() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		setLayout(gridBagLayout);

		JPanel groupPanel = new JPanel();
		groupPanel.setLayout(new GridBagLayout());

		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		gbc_scrollPane.weightx = 1.0;
		gbc_scrollPane.weighty = 1.0;
		add(groupPanel, gbc_scrollPane);

		for (int i = 0; i < 3; i++) {

			GridBagConstraints cons = new GridBagConstraints();
			cons.gridx = 0;
			cons.gridy = i;
			cons.fill = GridBagConstraints.BOTH;
			cons.weightx = 1.0;

			groupPanel.add(new ObjetPanel(i), cons);

		}

		GridBagConstraints cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 1;
		cons.fill = GridBagConstraints.BOTH;
		cons.weightx = 1.0;

		_createButton = new JButton();
		_createButton.setText("Create");

		add(_createButton, cons);

	}

}
