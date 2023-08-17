package dataset;

public class Tree {
	
	private static class TreeNode {
		int data;
		TreeNode leftChild;
		TreeNode rightChild;
		
		public TreeNode(int data) {
			this.data = data;
		}
	}
	
	public static void preOrderTravel(TreeNode node) {
		if(node == null) return;
		
		System.out.println(node.data);
		preOrderTravel(node.leftChild);
		preOrderTravel(node.rightChild);
	}

	public static void inOrderTravel(TreeNode node) {
		if(node == null) return;
		
		inOrderTravel(node.leftChild);
		System.out.println(node.data);
		inOrderTravel(node.rightChild);
	}
	
	public static void postOrderTravel(TreeNode node) {
		if(node == null) return;
		
		postOrderTravel(node.leftChild);
		postOrderTravel(node.rightChild);
		System.out.println(node.data);
	}
}
