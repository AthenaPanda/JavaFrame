package dataset;

public class CycleList {
	
	private static class Node {
		int data;
		Node next;
		Node(int data){
			this.data = data;
		}
	}
	
	public static boolean isCycle(Node head) {
		Node p1 = head;
		Node p2 = head;
		
		Node p3 = null;   //记录第一次相遇结点
		int countChecked = 0; //相遇次数
		boolean result = false; //是否有环
		
		int cycleLen = 0; //计算环长，第一次相遇到下一次循环相遇次数
		
		while(p2 != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
				
			if(p1 == p2) {
				result = true;
				countChecked++;
			}
			
			if(countChecked == 1) {
				cycleLen++;
			}
			
			if(cycleLen == 1) p3 = p2;
			if(countChecked == 2) break;
		}
		System.out.println("cycle len is " + cycleLen);
		return result;
	}
	
	public static void main(String[] args) {
		Node node1 = new Node(5);
		Node node2 = new Node(3);
		Node node3 = new Node(7);
		Node node4 = new Node(2);
		Node node5 = new Node(6);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node3;
		
		System.out.println(isCycle(node1));
	}
}
