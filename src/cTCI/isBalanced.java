package cTCI;

import java.util.ArrayList;
import java.util.Collections;

import cTCI.data_structures.TreeNode;

public class isBalanced {

	public static boolean isBalanced(TreeNode root) {
		//setup ArrayList of depth values
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		//modified preorder traversal
		list = preOrderTraversal(root, 0, list);
		
		//compare max and min vals from list
		int min = Collections.min(list);
		int max = Collections.max(list);
		int result = Math.abs(max-min);
		
		if(result > 1) {
			return false;
		}else {
			return true;
		}
	}
	
	public static ArrayList<Integer> preOrderTraversal(TreeNode node, int depth, ArrayList<Integer> al) {
		if(node != null) {
			if(node.left != null || node.right != null) {
				preOrderTraversal(node.left, depth + 1, al);
				preOrderTraversal(node.right, depth + 1, al);
			}else {
				al.add(depth);
			}
		}
		return al;
	}
	
	
	//driver code
	public static void main(String[] args) {
		
		//TRUE CASE
		
		//create root
				TreeNode root = new TreeNode(1);
				
				//create rest of tree
				root.left = new TreeNode(2);
				root.right = new TreeNode(3);
				root.left.right = new TreeNode(4);
				root.right.left = new TreeNode(5);
				root.right.right = new TreeNode(6);
				root.right.left.left = new TreeNode(7);
				root.right.left.right = new TreeNode(8);
				
				
				//actual algorithm
				System.out.println(isBalanced(root));
				
		
		//FALSE CASE
				
				//create root
				TreeNode root2 = new TreeNode(1);
				
				//create rest of tree
				root2.left = new TreeNode(2);
				root2.right = new TreeNode(3);
				
				root2.right.left = new TreeNode(4);
				root2.right.right = new TreeNode(5);
				root2.right.left.left = new TreeNode(6);
				root2.right.left.right = new TreeNode(7);
				
				
				//actual algorithm
				System.out.println(isBalanced(root2));
				
		//SINGLE NODE CASE
				
				//create root
				TreeNode root3 = new TreeNode(1);
				
				//check
				System.out.println(isBalanced(root3));
	}
}
