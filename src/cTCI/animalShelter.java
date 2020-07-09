package cTCI;

import cTCI.data_structures.MyQueue.NoSuchElementException;
import cTCI.data_structures.MyQueue.QueueNode;

public class animalShelter {
	public static class QueueNode<Integer>{
		public int data;
		public boolean isOn;
		public String type;
		public QueueNode<Integer> next;
		
		public QueueNode(int data, String type) {
			this.data = data;
			this.isOn = true;
			this.type = type;
		}
	}
	
	public QueueNode<Integer> first;
	public QueueNode<Integer> last;
	
	public void enqueue(int item, String type) {
		QueueNode<Integer> t = new QueueNode<Integer>(item, type);
		if(last != null) {
			last.next = t;
		}
		last = t;
		if(first == null) {
			first = last;
		}
	}
	
	public int dequeueAny() throws NoSuchElementException {
		if(first == null) throw new NoSuchElementException();
		int data = first.data;
		first = first.next;
		if(first == null) {
			last = null;
		}
		return data;
	

}
	
	public int dequeueDog() throws NoSuchElementException {
		if(first == null) throw new NoSuchElementException();
		QueueNode<Integer> node = first;
		int data;
		while(node != null && node.type != "dog") {
			node = node.next;
		}
		if(node == null) return -1;	//no dogs!
		else if(node.data == -1) return -1;
		else {
			data = node.data;
			QueueNode<Integer> prevNode = node;
			while(prevNode.next != null ) {
				prevNode.data = prevNode.next.data;
				prevNode.type = prevNode.next.type;
				prevNode = prevNode.next;
			}
			
			
			prevNode.data = -1;	//delete last in list
			prevNode = null;
			
			
			
		}
		return data;
	}
	
	public int dequeueCat() throws NoSuchElementException {
		if(first == null) throw new NoSuchElementException();
		QueueNode<Integer> node = first;
		int data;
		while(node != null && node.type != "cat") {
			node = node.next;
		}
		if(node == null) return -1;	//no dogs!
		else if(node.data == -1) return -1;
		else {
			data = node.data;
			QueueNode<Integer> prevNode = node;
			while(prevNode.next != null ) {
				prevNode.data = prevNode.next.data;
				prevNode.type = prevNode.next.type;
				prevNode = prevNode.next;
			}
			
			
			prevNode.data = -1;	//delete last in list
			last = null;
			prevNode = null;
			
			
			
		}
		return data;
	}
	
	
	
	public class NoSuchElementException extends Exception {
		public NoSuchElementException() {
			super();
			System.out.println("The queue returned an error! It has no such element!");
		}
	}
		
	
	//driver code
	public static void main(String[] args) throws NoSuchElementException {
		animalShelter queue = new animalShelter();
		String cat = "cat";
		String dog = "dog";
		
		queue.enqueue(1, cat);
		queue.enqueue(2, dog);
		queue.enqueue(3, cat);
		queue.enqueue(4, dog);
		System.out.println(queue.dequeueDog());
		System.out.println(queue.dequeueAny());
		System.out.println(queue.dequeueAny());
		System.out.println(queue.dequeueAny());
		System.out.println(queue.dequeueAny());
		queue.enqueue(5, dog);
		System.out.println(queue.dequeueAny());
		
	}
	

}

