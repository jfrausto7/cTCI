package cTCI;

import cTCI.data_structures.TreeNode;

public class isSubtree {
	
	public static boolean isSubtree(TreeNode t1, TreeNode t2) {
		//base cases
		if(t1 == null) return false;
		if(t2 == null) return true;
		
		//preorder traversal through t1
		return preOrderCheck(t1, t2);
	}
	
	public static boolean preOrderCheck(TreeNode root1, TreeNode root2) {
		if(root1 != null) {
			if(root1.data == root2.data) {
				return areSame(root1, root2);
			}
			return preOrderCheck(root1.left, root2) || preOrderCheck(root1.right, root2);
		}
		return false;	//reached end of tree
	}
	
	public static boolean areSame(TreeNode root1, TreeNode root2) {
		//check for break of recursion
		if(root1 == null && root2 == null) return true;
		if(root1 == null || root2 == null) return false;
		
		//recurse otherwise
		return (areSame(root1.left, root2.left) && areSame(root1.right, root2.right) && (root1.data == root2.data));	
		
	}
	
	//driver code
	public static void main(String[] args) {
		//make the two trees
		TreeNode root1 = new TreeNode(26);
		root1.left = new TreeNode(10);
		root1.right = new TreeNode(3);
		root1.right.right = new TreeNode(18);
		root1.left.left = new TreeNode(4);
		root1.left.right = new TreeNode(6);
		root1.left.left.right = new TreeNode(30);
		
		TreeNode root2 = new TreeNode(10);
		root2.right = new TreeNode(6);
		root2.left = new TreeNode(4);
		root2.left.right = new TreeNode(30);
		
		System.out.println(isSubtree(root1, root2));
	}

}
