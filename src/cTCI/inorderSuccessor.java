package cTCI;

import cTCI.data_structures.TreeNode;

public class inorderSuccessor {
	
	public static TreeNode inorderSuccessor(TreeNode node) {
		//base case
		if(node == null) return null;
		
		//first case
		if(node.right != null) {
			node = node.right;
			while(node.left != null) {
				node = node.left;
			}
			return node;
		}
		
		//second case
		TreeNode p = node.parent;
		while(node != p.left) {	
			//break loop case
			if(p.parent == null) {
				p = node;
				p.data = -1;
				break;
			}
			
			node = p;
			p = node.parent;
		}
		return p;
	}
	
	
	//driver code
	public static void main(String[] args) {
		
		//create root
				TreeNode root = new TreeNode(25);
				
				//create rest of tree
				root.left = new TreeNode(15);
				root.left.parent = root;
				root.left.left = new TreeNode(10);
				root.left.left.parent = root.left;
				root.left.left.parent = root.left;
				root.left.right = new TreeNode(22);
				root.left.right.parent = root.left;
				
				root.right = new TreeNode(50);
				root.right.parent = root;
				root.right.left = new TreeNode(35);
				root.right.left.parent = root.right;
				root.right.right = new TreeNode(70);
				root.right.right.parent = root.right;
				
				System.out.println(inorderSuccessor(root).data);	//35
				System.out.println(inorderSuccessor(root.right.right).data);	//null
				System.out.println(inorderSuccessor(root.right).data);	//70
				System.out.println(inorderSuccessor(root.left.right).data);	//25
				System.out.println(inorderSuccessor(root.left).data); //22
				
	}
}
