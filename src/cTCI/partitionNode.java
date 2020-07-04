package cTCI;

import cTCI.data_structures.Node;

public class partitionNode {
	public static Node partitionNode(Node head, int x) {
		Node left = null;
		Node right = null;
		Node n = head;
		
		//iterate through main LinkedList
		while(n.next != null){
			if(n.data < x) {
				left = doPartition(n.data, left);
			}else {
				right = doPartition(n.data, right);
			}
			n = n.next;
		}
		//one more at the end!
		if(n.data < x) {
			left = doPartition(n.data, left);
		}else {
			right = doPartition(n.data, right);
		}	
	
		Node end = left;
		//iterate through left partition
		while(end.next != null) {
			end = end.next;
		}
		end.next = right;
		return left;
	}
	
	public static Node doPartition(int n, Node partition) {
		Node p = new Node(n);
		if(partition == null) {
			partition = p;
		}else {
			p.next = partition;
			partition = p;
		}
		return partition;
	}
	
	//method for displaying and printing nodes
		public static void displayNodes(Node head) {
			Node n = head;
			while(n.next != null) {
				System.out.print(n.data + "->");
				n = n.next;
			}
			System.out.println(n.data);
		}
		
		//driver code
		public static void main(String[] args) {
			Node n = new Node(3);
			n.next = new Node(5);
			n.next.next = new Node(8);
			n.next.next.next = new Node(5);
			n.next.next.next.next = new Node(10);
			n.next.next.next.next.next = new Node(2);
			n.next.next.next.next.next.next = new Node(1);
			
			
			//print them out
			displayNodes(n);
			
			Node newNode = partitionNode(n, 5);
			
			displayNodes(newNode);
		

		}
	

}
