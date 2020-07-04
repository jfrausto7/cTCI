package cTCI.data_structures;

public class Node {
	public Node next = null;
	public int data;
	
	public Node(int d) {
		data = d;
	}
	
	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while(n.next != null) {
			n = n.next;
		}
	n.next = end;
	}
	
	Node deleteNode(Node head, int d) {
		if(head == null) return null;
		Node n = head;
		
		if (n.data == d) {
			return head.next;//head moved
		}
		
		while(n.next != null) {
			if(n.next.data == d) {
				n.next = n.next.next;
				return head;//head didn't change
			}
		n = n.next;
		}
		return head;
	}
	
	//method for getting count of a LinkedList
		public static int getLength(Node head) {
			int counter = 1;
			while(head.next != null) {
				counter++;
				head = head.next;
			}
			return counter;
		}

}
