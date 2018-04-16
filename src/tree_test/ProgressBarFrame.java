package tree_test;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;

public class ProgressBarFrame extends JFrame 
{
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 600;
	public static final int TEXT_ROWS = 10;
	public static final int TEXT_COLUMNS = 40;
	private JButton startButton;
	private JProgressBar progressBar;
	private JCheckBox checkBox;
	private JTextArea textArea;
	private SimulatedActivity activity;
	
	public ProgressBarFrame()
	{
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		textArea = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
		final int MAX = 1000;
		JPanel panel = new JPanel();
		startButton = new JButton("start");
		progressBar = new JProgressBar(0, MAX);
		progressBar.setStringPainted(true);
		panel.add(startButton);
		panel.add(progressBar);
		
		checkBox = new JCheckBox("interminate");
		checkBox.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evnet)
					{
						progressBar.setIndeterminate(checkBox.isSelected());//是否显示进度
						progressBar.setStringPainted(!progressBar.isIndeterminate());//是否显示当前进度值
					}
				});
		panel.add(checkBox);
		add(new JScrollPane(textArea), BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		startButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evnet)
					{
						startButton.setEnabled(false);
						activity = new SimulatedActivity(MAX);
						activity.execute();
					}
				});
		pack();
	}

	class SimulatedActivity extends SwingWorker<Void, Integer>
	{
		private int current;
		private int target;
		
		public SimulatedActivity(int t)
		{
			current = 0;
			target = t;
		}
	
		protected Void doInBackground() throws Exception
		{
			try
			{
				while(current < target)
				{
					Thread.sleep(100);
					current++;
					publish(current);
				}
			}
			catch (InterruptedException e)
			{
				
			}
			return null;
		}
	
		protected void process(List<Integer> chunks)
		{
			for(Integer chunk : chunks)
			{
				textArea.append(chunk + "\n");
				progressBar.setValue(chunk);
			}
		}
		
		protected void done()
		{
			startButton.setEnabled(true);
		}
	}
}
