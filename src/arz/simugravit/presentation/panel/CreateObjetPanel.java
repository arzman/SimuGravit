package arz.simugravit.presentation.panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import arz.simugravit.application.ContextManager;
import arz.simugravit.application.exception.SimuApplicationException;
import arz.simugravit.presentation.controller.GraphFrameController;

public class CreateObjetPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7821326404226866812L;
	
	private JButton _createButton;
	
	private ArrayList<ObjetPanel> _objPanelList;

	public CreateObjetPanel() throws SimuApplicationException {

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

		_objPanelList = new ArrayList<ObjetPanel>(ContextManager.getInstance().getNbrObject());
		
		for (int i = 0; i < ContextManager.getInstance().getNbrObject(); i++) {

			GridBagConstraints cons = new GridBagConstraints();
			cons.gridx = 0;
			cons.gridy = i;
			cons.fill = GridBagConstraints.BOTH;
			cons.weightx = 1.0;
			ObjetPanel pan = new ObjetPanel(i);
			groupPanel.add(pan, cons);
			_objPanelList.add(pan);

		}

		GridBagConstraints cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 1;
		cons.fill = GridBagConstraints.BOTH;
		cons.weightx = 1.0;

		_createButton = new JButton();
		_createButton.setText("Create");

		add(_createButton, cons);
		
		hookListener();

	}

	private void hookListener() {
		
		
		_createButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				try{
				
				for(ObjetPanel pan : _objPanelList){
					
					pan.writeObject();
					
				}
				}catch(SimuApplicationException ex){
					
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Impossible de créer les objets", JOptionPane.ERROR_MESSAGE);
					
				}
				
				
				GraphFrameController.getInstance().openGraphFrame();
			}
		});
		
	}

}
