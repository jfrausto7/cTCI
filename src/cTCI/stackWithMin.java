package cTCI;

import java.util.Stack;

public class stackWithMin {
	public static class StackNode<Integer>{
		public int data;
		public StackNode<Integer> next;
		
		public StackNode(int data) {
			this.data = data;
		}
	}

	public StackNode<Integer> top;
	public Stack<Integer> mins = new Stack<Integer>();
	
	public int pop() throws EmptyStackException {
		if(top == null) throw new EmptyStackException();
		int item = top.data;
		if(item == mins.peek()) {
			mins.pop();
		}
		top = top.next;
		return item;
	}
	
	public void push(int item) {
		if(mins.isEmpty()) {
			mins.push(item);
		}else if(mins.peek() > item) {
			mins.push(item);
		}
		StackNode<Integer> t = new StackNode<Integer>(item);
		t.next = top;
		top = t;
	}
	
	public int min() {
		if(mins.isEmpty()) {
			System.out.println("No values to return!");
		}else {
			return mins.peek();
		}
		return (java.lang.Integer) null;
	}
	
	public int peek() throws EmptyStackException {
		if(top == null) throw new EmptyStackException();
		return top.data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public class EmptyStackException extends Exception {
		public EmptyStackException() {
			super();
			System.out.println("The stack returned an error! It is empty!");
		}
	}
	
	//driver code for testing
	public static void main(String[] args) throws EmptyStackException {
		stackWithMin stack = new stackWithMin();
		
		stack.push(9);
		stack.push(4);
		stack.push(7);
		stack.pop();
		stack.pop();
		System.out.println(stack.min());
	}
}
