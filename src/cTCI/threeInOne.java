package cTCI;

public class threeInOne {
	private int numberOfStacks = 3;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;
	
	public threeInOne(int stackSize) {
		stackCapacity = stackSize;
		values = new int[stackSize * numberOfStacks];
		sizes = new int[numberOfStacks];
	}
	
	//method for pushing onto stack
	public void push(int stackNum, int value) throws FullStackException{
		//check that we have space
		if(isFull(stackNum)) {
			throw new FullStackException();
		}
		
		//increment stack pointer and then update top value
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = value;
	}
	
	//pop item from stack
	public int pop(int stackNum) throws EmptyStackException {
		if(isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		
		int topIndex = indexOfTop(stackNum);
		int value = values[topIndex]; //get top
		values[topIndex] = 0; //clear
		sizes[stackNum]--; //shrink sizes
		return value;
	}
	
	//return top element
	public int peek(int stackNum) throws EmptyStackException {
		if(isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		return values[indexOfTop(stackNum)];
	}
	
	//return if stack is empty
	public boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0;
	}
	
	//return if stack if full
	public boolean isFull(int stackNum) {
		return sizes[stackNum] == stackCapacity;
	}
	
	//return index of the top of the stack
	private int indexOfTop(int stackNum) {
		int offset = stackNum * stackCapacity;
		int size = sizes[stackNum];
		return offset + size - 1;
	}
	
	
	//now for the exceptions
	public class EmptyStackException extends Exception {
		public EmptyStackException() {
			super();
			System.out.println("The stack returned an error! It is empty!");
		}
	}
	
	public class FullStackException extends Exception {
		public FullStackException() {
			super();
			System.out.println("The stack returned an error! It is full!");
		}
	}

}
