package tree_test;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.*;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class FormatTestFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5030042946948795203L;
	private DocumentFilter filter = new IntFilter();
	private JButton okButton;
	private JPanel mainPanel;
	
	public FormatTestFrame()
	{
		JPanel buttonPanel = new JPanel();
		okButton = new JButton("ok");
		buttonPanel.add(okButton);
		add(buttonPanel, BorderLayout.SOUTH);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(0, 3));
		add(mainPanel, BorderLayout.CENTER);
		
		JFormattedTextField intField = new JFormattedTextField(NumberFormat.getIntegerInstance());
		intField.setValue(new Integer(100));
		addRow("Number", intField);
		
		JFormattedTextField intField2 = new JFormattedTextField(NumberFormat.getIntegerInstance());
		intField2.setValue(new Integer(100));
		intField2.setFocusLostBehavior(JFormattedTextField.COMMIT);
		addRow("Number(Commit behavior)", intField2);
		
		JFormattedTextField intField3 = new JFormattedTextField(new InternationalFormatter(
				NumberFormat.getIntegerInstance())
				{
					protected DocumentFilter getDocumentFilter()
					{
						return filter;
					}
				});
		intField3.setValue(new Integer(100));
		addRow("Filter number", intField3);
		
		JFormattedTextField intField4 = new JFormattedTextField(NumberFormat.getIntegerInstance());
		intField4.setValue(new Integer(100));
		intField4.setInputVerifier(new InputVerifier()
				{
					public boolean verify(JComponent component)
					{
						JFormattedTextField field = (JFormattedTextField) component;
						return field.isEditValid();
					}
				});
		addRow("Verified Number", intField4);
		
		JFormattedTextField currencyField  = new JFormattedTextField(NumberFormat.getCurrencyInstance());
		currencyField.setValue(new Double(10));
		addRow("Currency:", currencyField);
		
		JFormattedTextField dateField = new JFormattedTextField(DateFormat.getDateInstance());
		dateField.setValue(new Date());
		addRow("Date:", dateField);
		
		DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT);
		format.setLenient(false);
		JFormattedTextField dateField2 = new JFormattedTextField(format);
		dateField2.setValue(new Date());
		addRow("Date(short)", dateField2);
		
		try
		{
			DefaultFormatter formatter = new DefaultFormatter();
			formatter.setOverwriteMode(false);
			JFormattedTextField urlField  = new JFormattedTextField(formatter);
			urlField.setValue(new URL("www.java.com"));
			addRow("URL", urlField);
		}
		catch(MalformedURLException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			MaskFormatter formatter = new MaskFormatter("###-##-####");
			formatter.setPlaceholderCharacter('0');
			JFormattedTextField ssnField = new JFormattedTextField(formatter);
			ssnField.setValue("002-32-4567");
			addRow("SSN mask:", ssnField);
		}
		catch(ParseException ex)
		{
			ex.printStackTrace();
		}
		pack();
	}
	
	public void addRow(String labelText, final JFormattedTextField field)
	{
		mainPanel.add(new JLabel(labelText));
		mainPanel.add(field);
		final JLabel valueLabel = new JLabel();
		mainPanel.add(valueLabel);
		okButton.addActionListener(new ActionListener()		
				{
					public void actionPerformed(ActionEvent event)
					{
						Object value = field.getValue();
						Class<?>cl = value.getClass();
						String text = null;
						if(cl.isArray())   //����
						{
							if(cl.getComponentType().isPrimitive())
							{
								try
								{
									text = Array.class.getMethod("toString", cl).invoke(null, value).toString();
								}
								catch(ReflectiveOperationException e)
								{
								
								}
							}
							else text = Arrays.toString((Object[])value);
						}
						else text = value.toString();
						valueLabel.setText(text);
					}
				});
	}
}
