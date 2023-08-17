package dataset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
	
	public Node creTree(int[] arr) {
		List<Node> list =  new ArrayList<Node>();
		
		for(int element:arr) {
			list.add(new Node(element));
		}
		
		while(list.size() > 1) {
			Collections.sort(list);
			
			Node left = list.get(0);
			Node right = list.get(1);
			
			Node newTree = new Node(left.getElement() + right.getElement());
			newTree.setLTree(left);
			newTree.setRTree(right);
			list.add(newTree);
			list.remove(left);
			list.remove(right);
		}
		return list.get(0);
	}

}

class Node implements Comparable<Node> {
	private int weight;
	private Node left;
	private Node right;
	
	public Node(int weight) {
		this.weight = weight;
	}
	public int getElement() {
		return this.weight;
	}
	
	public void setElement(int weight) {
		this.weight = weight;
	}
	
	public Node getLTree() {
		return this.left;
	}
	
	public void setLTree(Node lTree) {
		this.left = lTree;
	}
	
	public Node getRTree() {
		return this.right;
	}
	
	public void setRTree(Node rTree) {
		 this.right = rTree;
	}
	
	public void preOrder() {
		
		System.out.println("weight is " + this.weight);
		if(this.getLTree() != null) {
			this.getLTree().preOrder();
		}
		
		if(this.getRTree() != null) {
			this.getRTree().preOrder();
		}
	}
	
	
	@Override
	public int compareTo(Node node) {
		return this.weight - node.weight;
	}
}