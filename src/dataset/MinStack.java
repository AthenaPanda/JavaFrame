package dataset;

import java.util.Stack;

//最小栈
public class MinStack {
	
	private Stack<Integer> mainStack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();

	//入栈
	public void push(int element) {
		mainStack.push(element);
		if(minStack.empty() || element <= minStack.peek()) {
			minStack.push(element);
		}
	}
	
	//出栈
	public Integer pop() {
		if(mainStack.peek().equals(minStack.peek())) {
			minStack.pop();
		}
		return mainStack.pop();
	}
	
	//获取栈的最小元素
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
