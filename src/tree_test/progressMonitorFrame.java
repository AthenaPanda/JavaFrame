package tree_test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class progressMonitorFrame extends JFrame 
{
	private static final int DEFAULT_WIDTH = 800;
	private static final int DEFAULT_HEIGHT = 600;
	public static final int TEXT_ROWS = 10;
	public static final int TEXT_COLUMNS = 40;
	private final int MAX = 500;
	
	private Timer cancelMonitor;
	private JButton startButton;
	private ProgressMonitor progressDialog;
	private JTextArea textArea;
	private SimulateActivity activity;
	
	public progressMonitorFrame()
	{
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		textArea = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
		
		JPanel panel = new JPanel();
		startButton = new JButton("Start");
		panel.add(startButton);
		
		add(new JScrollPane(textArea), BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		startButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evnet)
			{
				startButton.setEnabled(false);
				activity = new SimulateActivity(MAX);
				activity.execute();
				
				progressDialog = new ProgressMonitor(progressMonitorFrame.this,
						"Wating for activity", null, 0, MAX);
				cancelMonitor.start();
			}
		});
		
		cancelMonitor = new Timer(500, new ActionListener()
				{
					public void actionPerformed(ActionEvent evnet)
					{
						if(progressDialog.isCanceled())
						{
							activity.cancel(true);
							startButton.setEnabled(true);
						}
						else if(activity.isDone())
						{
							progressDialog.close();
							startButton.setEnabled(true);
						}
						else
						{
							progressDialog.setProgress(activity.getProgress());
						}
					}
				});
		pack();
	}
	
	class SimulateActivity extends SwingWorker<Void, Integer>
	{
		private int current;
		private int target;
		
		public SimulateActivity(int t)
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
					textArea.append(current + "\n");
					setProgress(current*100/MAX);
				}
			}
			catch (InterruptedException e)
			{
				
			}
			return null;
		}
	}
}
