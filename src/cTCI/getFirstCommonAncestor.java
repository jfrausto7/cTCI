package cTCI;

import cTCI.data_structures.TreeNode;

public class getFirstCommonAncestor {
	
	public static TreeNode getFirstCommonAncestor(TreeNode root, TreeNode a, TreeNode b){
		//base cases
		if(root == null) return null;
		if(a == null || b == null) return null;
		
		if(root.left != null) {
			if(checkLeft(root.left, a) && checkLeft(root.left,  b)) {
				return getFirstCommonAncestor(root.left, a, b);
			}
		}
		
		if(root.right != null) {
			if(checkRight(root.right, a) && checkRight(root.right,  b)) {
				return getFirstCommonAncestor(root.right, a, b);
			}
		}
		
		return root;
	}
	
	public static boolean checkLeft(TreeNode root, TreeNode toCheck) {
		if(root != null) {
			if(root == toCheck) return true;
		}else {
			return false;
		}
		return checkLeft(root.left, toCheck) || checkLeft(root.right, toCheck);
	}
	
	public static boolean checkRight(TreeNode root, TreeNode toCheck) {
		if(root != null) {
			if(root == toCheck) return true;
		}else {
			return false;
		}
		//if not
		return checkRight(root.left, toCheck) || checkRight(root.right, toCheck);
	}
	
	
	//driver code
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(10);
		
		root.left = new TreeNode(5);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(7);
		root.right.left.left = new TreeNode(9);
		root.right.left.right = new TreeNode(18);
		
		
		//actual testing
		System.out.println(getFirstCommonAncestor(root,root.right.right, root.right.left.left).data);	//20
		System.out.println(getFirstCommonAncestor(root,root.right.left.right, root.right.left.left).data);	//3
		System.out.println(getFirstCommonAncestor(root,root.left, root.right.left.left).data);	//10
		

	}

}
