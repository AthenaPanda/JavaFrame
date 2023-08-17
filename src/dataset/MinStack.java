package dataset;

import java.util.Stack;

//��Сջ
public class MinStack {
	
	private Stack<Integer> mainStack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();

	//��ջ
	public void push(int element) {
		mainStack.push(element);
		if(minStack.empty() || element <= minStack.peek()) {
			minStack.push(element);
		}
	}
	
	//��ջ
	public Integer pop() {
		if(mainStack.peek().equals(minStack.peek())) {
			minStack.pop();
		}
		return mainStack.pop();
	}
	
	//��ȡջ����СԪ��
	public int getMin() throws Exception {
		if(mainStack.empty()) {
			throw new Exception("Stack is Empty");
		}
		return mainStack.peek();
	}	
	public static void main(String[] args)  throws Exception {
		MinStack stack = new MinStack();
		stack.push(4);
		stack.push(9);
		stack.push(7);
		stack.push(3);
		stack.push(8);
		stack.push(5);
		
		System.out.println(stack.getMin());
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println(stack.getMin());
	}

}
