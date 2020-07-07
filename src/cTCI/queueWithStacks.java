package cTCI;

import java.util.Stack;

public class queueWithStacks {
	
	public static Stack<Integer> enqueue = new Stack<Integer>();
	public static Stack<Integer> dequeue = new Stack<Integer>();
	
	
	public void add(int item) {
		//simply add item to first stack
		enqueue.push(item);
	}
	
	public int remove() throws NoSuchElementException {
		if(dequeue.isEmpty()) {
			pourInto(enqueue, dequeue);
			if(dequeue.isEmpty()) {
				throw new NoSuchElementException();
			}
			return dequeue.pop();
		}
		return dequeue.pop();
	}
	
	public int peek() throws NoSuchElementException {
		if(dequeue.isEmpty()) {
			pourInto(enqueue, dequeue);
			if(dequeue.isEmpty()) {
				throw new NoSuchElementException();
			}
			return dequeue.peek();
		}
		return dequeue.peek();
	}
	
	public boolean isEmpty() {
		if(dequeue.isEmpty()) {
			if(enqueue.isEmpty()) {
				return true;
			}
		}
		return false;
	}
	
	public static void pourInto(Stack<Integer> first, Stack<Integer> second) {
		//iterate through first stack pouring into second when needed
		while(!first.isEmpty()) {
			int temp = first.pop();
			second.push(temp);
		}
	}
	
	public class NoSuchElementException extends Exception {
		public NoSuchElementException() {
			super();
			System.out.println("The queue returned an error! It has no such element!");
		}
	}
	
	
	//driver testing code
	public static void main(String[] args) throws Exception {
		
		//create new queue object
		queueWithStacks queue = new queueWithStacks();
		
		//test one
		queue.add(5);
		queue.add(8);
		queue.add(23);
		queue.add(9);
		
		System.out.println(queue.peek());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.peek());
		
		queue.add(7);
		System.out.println(queue.remove());

		
	}
}
