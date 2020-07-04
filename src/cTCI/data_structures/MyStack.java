package cTCI.data_structures;

public class MyStack {
	public static class StackNode<Integer>{
		public int data;
		public StackNode<Integer> next;
		
		public StackNode(int data) {
			this.data = data;
		}
	}

	public StackNode<Integer> top;
	
	public int pop() throws EmptyStackException {
		if(top == null) throw new EmptyStackException();
		int item = top.data;
		top = top.next;
		return item;
	}
	
	public void push(int item) {
		StackNode<Integer> t = new StackNode<Integer>(item);
		t.next = top;
		top = t;
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
}
