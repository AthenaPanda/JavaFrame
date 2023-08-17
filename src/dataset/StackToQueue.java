package dataset;

import java.util.Stack;

public class StackToQueue {

	private Stack<Integer> stackA = new Stack<Integer>();
	private Stack<Integer> stackB = new Stack<Integer>();
	
	public void enQueue(int element) {
		stackA.push(element);
	}
	
	public Integer deQueue() {
		if(stackB.isEmpty()) {
			if(stackA.isEmpty()) {
				return null;
			}
			tranfer();
		}
		return stackB.pop();
	}
	
	public void tranfer() {
		while(!stackA.isEmpty()) {
			stackB.push(stackA.pop());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackToQueue stackQueue = new StackToQueue();
		stackQueue.enQueue(2);
		stackQueue.enQueue(3);
		stackQueue.enQueue(4);
		System.out.println(stackQueue.deQueue());
		System.out.println(stackQueue.deQueue());
		stackQueue.enQueue(5);
		System.out.println(stackQueue.deQueue());
	}

}
