package tree_test;

import java.awt.*;
import javax.swing.*;

public class tree_test 
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				//treeFranme frame = new treeFranme();
				//editorPane frame = new editorPane();
				//ProgressBarFrame frame = new ProgressBarFrame();
				progressMonitorFrame frame = new progressMonitorFrame();
				frame.setTitle("Tree");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
