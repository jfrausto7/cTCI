package cTCI;

import cTCI.data_structures.TreeNode;

public class isValidBST {
	
	public static boolean isValidBST(TreeNode root, TreeNode l, TreeNode r) {
		//base case breaks recursion
		if(root == null) return true;
		
		//check both conditions for false breakage
		if(l != null && root.data <= l.data) {
			return false;
		}
		if(r != null && root.data >= r.data) {
			return false;
		}
		
		//recursively return for each node
		return isValidBST(root.left, l, root) && isValidBST(root.right, root, r);
	}
	
	//driver code
	public static void main(String[] args) {
		
		//TRUE CASE
		
		//create root
		TreeNode root = new TreeNode(2);
		
		//create rest of tree
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		
		System.out.println(isValidBST(root, null, null));
		
		//FALSE CASE
		
		//create root
				TreeNode root2 = new TreeNode(1);
				
				//create rest of tree
				root2.left = new TreeNode(2);
				root2.right = new TreeNode(3);
				root2.left.left = new TreeNode(4);
				root2.left.right = new TreeNode(5);
				
				System.out.println(isValidBST(root2, null, null));
				
				
				//CORNER CASES
				
				//create root
				TreeNode root3 = new TreeNode(1);
				
				
				System.out.println(isValidBST(root3, null, null));
				
				
				//create root
				TreeNode root4 = new TreeNode(0);
				
				System.out.println(isValidBST(null, null, null));
				
		
	}

}
