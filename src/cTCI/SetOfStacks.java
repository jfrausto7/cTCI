package cTCI;

import cTCI.data_structures.MyStack.EmptyStackException;
import cTCI.data_structures.MyStack.StackNode;

public class SetOfStacks {
	public static class StackNode<Integer>{
		public int data;
		public StackNode<Integer> next;
		
		public StackNode(int data) {
			this.data = data;
		}
	}
	
	public SubStack<Integer> first;
	public SubStack<Integer> currentStack;
	public int stackCapacity;	//max any stack can have in this set
	public int stackCount;
	
	/* This is the constructor of the SetOfStacks! */
	public SetOfStacks(int stackMax) {
		first = new SubStack<Integer>();
		currentStack = first;
		stackCapacity = stackMax;
		stackCount = 1;
	}
	
	public static class SubStack<Integer>{
		
	public StackNode<Integer> top;
	public SubStack<Integer> next = null;
	public SubStack<Integer> prev = null;
	public int count = 0;
	
	
	public int pop() throws Exception {
		if(top == null) throw EmptyStackException();
		int item = top.data;
		top = top.next;
		count--;
		return item;
	}
	
	public void push(int item) {
		StackNode<Integer> t = new StackNode<Integer>(item);
		t.next = top;
		top = t;
		count++;
	}
	
	public int peek() throws Exception {
		if(top == null) throw EmptyStackException();
		return top.data;
	}
	
	private Exception EmptyStackException() {
		// TODO Auto-generated method stub
		System.out.println("The stack returned an error! It is empty!");
		return null;
	}

	public boolean isEmpty() {
		return top == null;
	}
	
	}
	
	public class EmptyStackException extends Exception {
		public EmptyStackException() {
			super();
			System.out.println("The SetOfStacks returned an error! It is empty!");
		}
	}
	
	//main methods for the main class
	
	public int pop() throws Exception {
		int temp = currentStack.pop();
		if(currentStack.isEmpty()) {
			if(currentStack.prev != null) {
				//remove current stack and move back one
				currentStack = currentStack.prev;
				currentStack.next = null;
				stackCount--;
			}else {
				throw new EmptyStackException();
			}
		}
		return temp;
	}
	
	public void push(int item) {
		if(currentStack.count < stackCapacity) {
			currentStack.push(item);
		}else {
			//make a new stack and update references
			SubStack<Integer> newSubStack = new SubStack<Integer>();
			currentStack.next = newSubStack;
			SubStack<Integer> temp = currentStack;
			currentStack = currentStack.next;
			currentStack.prev = temp;
			currentStack.push(item);
			stackCount++;
		}
	}
	
	public int peek() throws Exception {
		return currentStack.peek();
	}
	
	public boolean isEmpty() {
		if(currentStack.prev == null) {
			if(currentStack.isEmpty()) {
				return true;
			}
		}
		return false;
	}
	
	
	//driver code in method below
	public static void main(String[] args) throws Exception {
		
		//test one!
		SetOfStacks multiStack = new SetOfStacks(4);
		multiStack.push(6);
		multiStack.push(5);
		multiStack.push(3);
		multiStack.push(7);
		System.out.println(multiStack.peek());
		System.out.println(multiStack.currentStack);
		multiStack.push(14);
		System.out.println(multiStack.currentStack);
		System.out.println(multiStack.pop());
		System.out.println(multiStack.currentStack);
		
		//test two!
		SetOfStacks multiStack2 = new SetOfStacks(7);
		
		//iterate through a few hundred pushes
		int i = 0;
		while(i < 791) {
			multiStack2.push(i);
			i++;
		}
		
		System.out.println(multiStack2.stackCount);
		
		

	}
}
