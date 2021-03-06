package tree_test;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;

public class SpinnerFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6105313316444418579L;
	private JPanel mainPanel;
	private JButton okButton;
	
	public SpinnerFrame()
	{
		JPanel buttonPanel = new JPanel();
		okButton = new JButton("ok");
		buttonPanel.add(okButton);
		add(buttonPanel, BorderLayout.SOUTH);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(0, 3));
		add(mainPanel, BorderLayout.CENTER);
		
		JSpinner defaultSpinner = new JSpinner();
		addRow("Default", defaultSpinner);
		
		JSpinner boundedSpinner  = new JSpinner(new SpinnerNumberModel(5, 0, 10, 0.5));
		addRow("Bounded", boundedSpinner);
		
		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		JSpinner listSpinner = new JSpinner(new SpinnerListModel(fonts));
		addRow("List", listSpinner);
		
		@SuppressWarnings("serial")
		JSpinner reverseListSpinner  = new JSpinner(new SpinnerListModel(fonts)
				{
					public Object getNextValue(){return super.getPreviousValue();}
					public Object getPreviousValue() {return super.getNextValue();}
				});
		addRow("Reverse List", reverseListSpinner);
		
		JSpinner betterDateSpinner = new JSpinner(new SpinnerDateModel());
		String pattern = ((SimpleDateFormat)DateFormat.getDateInstance()).toPattern();
		betterDateSpinner.setEditor(new JSpinner.DateEditor(betterDateSpinner, pattern));
		addRow("Better Date", betterDateSpinner);
		
		JSpinner timeSpinner  = new JSpinner(new SpinnerDateModel());
		pattern = ((SimpleDateFormat)DateFormat.getTimeInstance(DateFormat.SHORT)).toPattern();
		timeSpinner.setEditor(new JSpinner.DateEditor(timeSpinner, pattern));
		addRow("Time", timeSpinner);
		
		JSpinner permSpinner = new JSpinner(new PermutationSpinnerModel("meat"));
		addRow("Word permutations", permSpinner);
		pack();
	}
	
	public void addRow(String labelText, final JSpinner spinner)
	{
		mainPanel.add(new JLabel(labelText));
		mainPanel.add(spinner);
		final JLabel valueLabel  = new JLabel();
		mainPanel.add(valueLabel);
		okButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						Object value = spinner.getValue();
						valueLabel.setText(value.toString());
					}
				});
	}
}
