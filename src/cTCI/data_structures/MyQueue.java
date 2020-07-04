package cTCI.data_structures;

public class MyQueue {
	public static class QueueNode<Integer>{
		public int data;
		public QueueNode<Integer> next;
		
		public QueueNode(int data) {
			this.data = data;
		}
	}
	
	public QueueNode<Integer> first;
	public QueueNode<Integer> last;
	
	public void add(int item) {
		QueueNode<Integer> t = new QueueNode<Integer>(item);
		if(last != null) {
			last.next = t;
		}
		last = t;
		if(first == null) {
			first = last;
		}
	}
	
	public int remove() throws NoSuchElementException {
		if(first == null) throw new NoSuchElementException();
		int data = first.data;
		first = first.next;
		if(first == null) {
			last = null;
		}
		return data;
	}
	
	public int peek() throws NoSuchElementException {
		if(first == null) throw new NoSuchElementException();
		return first.data;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public class NoSuchElementException extends Exception {
		public NoSuchElementException() {
			super();
			System.out.println("The queue returned an error! It has no such element!");
		}
	}
}
