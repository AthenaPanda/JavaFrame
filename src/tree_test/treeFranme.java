package tree_test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;

public class treeFranme extends JFrame
{
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;
	
	private DefaultTreeModel model;
	private JTree tree;
	
	public  treeFranme()
	{
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		TreeNode root = makeTree();
		model = new DefaultTreeModel(root);
		tree  = new JTree(model);
		tree.setEditable(true);
		 
		JScrollPane pane = new JScrollPane(tree);
		add(pane, BorderLayout.CENTER);
		
		makeButtons();
	}

	public TreeNode makeTree()
	{
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("World");
		DefaultMutableTreeNode country = new DefaultMutableTreeNode("CN");
		root.add(country);
		DefaultMutableTreeNode state = new DefaultMutableTreeNode("Gd");
		country.add(state);
		state = new DefaultMutableTreeNode("Hb");
		country.add(state);
		return root;
	}
	
	public void makeButtons()
	{
		JPanel panel = new JPanel();
		JButton addSiButton = new JButton("Add sibing");
		addSiButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event) 
				{
					DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
					if(selectedNode == null) return;
					
					DefaultMutableTreeNode parent = (DefaultMutableTreeNode)selectedNode.getParent();
					if(parent == null) return;
					
					DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("New");
					
					int selectedIndex = parent.getIndex(selectedNode);
					model.insertNodeInto(newNode, parent, selectedIndex + 1);
					
					TreeNode[] nodes = model.getPathToRoot(newNode);
					TreePath path  = new TreePath(nodes);
					tree.scrollPathToVisible(path);
				}
			});
		panel.add(addSiButton);
		
		JButton childButton = new JButton("Add child");
		childButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
					if(selectedNode == null) return;
					
					DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("New");			
					model.insertNodeInto(newNode, selectedNode, selectedNode.getChildCount() );
			
					TreeNode[] nodes = model.getPathToRoot(newNode);
					TreePath path  = new TreePath(nodes);
					tree.scrollPathToVisible(path);
				}
			});
		panel.add(childButton);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
					
					if(selectedNode != null && selectedNode.getParent() != null) model.removeNodeFromParent(selectedNode);
				}
			}); 
		panel.add(deleteButton);
		add(panel, BorderLayout.SOUTH);
	}
}
