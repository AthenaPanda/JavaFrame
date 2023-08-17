package dataset;

public class linklistDemo {
	
	private static class Node {
		int data; 
		Node next;
		
		public Node(int data) {
			this.data = data;
			
		}
	}
	private Node head;
	private Node last;
	private int size;
		
	public void insert(int data, int index) throws Exception {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Beyond size");
		}
		
		Node insertNode = new Node(data);
		if(size == 0) {
			head  = insertNode;
			last = insertNode;
		}
		else if( index == 0) {
			insertNode.next = head;
			head = insertNode;
		}
		else if(size == index) {
			last.next = insertNode;
			last = insertNode;
		}
		else {
			//insert in the middle
			Node  prevNode = get(index -1);
			insertNode.next = prevNode.next;
			prevNode.next = insertNode;
		}
		size++;
	}
	
	public Node get(int index) throws IndexOutOfBoundsException {
		
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Beyond field");
		}
		Node node;
		node = head;
		for(int i=0; i<index; i++) {		
			node = node.next;				
		}
		
		return node;
	}
}
