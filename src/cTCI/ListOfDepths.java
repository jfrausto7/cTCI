package cTCI;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import cTCI.data_structures.Node;
import cTCI.data_structures.TreeNode;

public class ListOfDepths {
	public static ArrayList<Node> ListOfDepths(TreeNode root){
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);	//add to queue
		ArrayList<Node> arrayOfLists = new ArrayList<Node>();
		
		//iterate through queue until empty
		while(!q.isEmpty()) {
			int num = q.size();
			Node temp = new Node(-1);
			//iterate through independent level
			for(int i = 0; i < num; i++) {
				TreeNode r = q.remove();
				Node node = new Node(r.data);
				if(temp.data == -1) {
					temp = node;
					arrayOfLists.add(node);
				}else {
					temp.next = node;
					temp = node;
				}
				if(r.left != null) q.add(r.left);
				if(r.right != null) q.add(r.right);
			}
		}
		return arrayOfLists;
	}
	
	public static void listPrinter(ArrayList<Node> list) {
		int count = 1;
		for(Node n : list) {
			System.out.print("List number " + count + ": ");
			System.out.print(n.data);
			n = n.next;
			while(n != null) {
				System.out.print(" -> " + n.data);
				n = n.next;
			}
			System.out.println("\n");
			count++;
		}
		
	}
	
	
	//driver code
	public static void main(String[] args) {
		
		//create root
		TreeNode root = new TreeNode(5);
		
		//create rest of tree
		root.left = new TreeNode(6);
		root.right = new TreeNode(12);
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(12);
		
		//convert to linked lists
		ArrayList<Node> lists = ListOfDepths(root);
		
		//print out lists
		listPrinter(lists);
		
		
		
		
	}

}
