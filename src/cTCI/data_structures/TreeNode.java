package cTCI.data_structures;

public class TreeNode {
	public int data;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	
	public TreeNode(int value) {
		this.data = value;
		this.left = this.right = this.parent = null;
	}
}
