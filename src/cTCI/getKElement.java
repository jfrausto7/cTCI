package cTCI;

public class getKElement {
	public static Node getKElement(Node head, int k) {
	int count = 1;
	Node n = head;
	Node result = head;
	if(head == null) return null;
	
	//first iteration to get count
	while(n.next != null) {
		n = n.next;
		count++;
	}
	
	//second iteration to return element
	for(int i = 0; i < count-k; i++) {
		result = result.next;
	}
	return result;	
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
			Node n = new Node(4);
			n.next = new Node(2);
			n.next.next = new Node(4);
			n.next.next.next = new Node(5);
			n.next.next.next.next = new Node(5);
			n.next.next.next.next.next = new Node(9);
			n.next.next.next.next.next.next = new Node(7);
			n.next.next.next.next.next.next.next = new Node(7);
			
			//print them out
			displayNodes(n);
			
			//get last element
			System.out.println(getKElement(n, 1).data);
			
			//get second to last element
			System.out.println(getKElement(n, 2).data);
			
			//get third to last element
			System.out.println(getKElement(n, 3).data);
			
			//get element outside of range for testing
			System.out.println(getKElement(n, 12).data);	//will just return head of LinkedList
			
		}
}
