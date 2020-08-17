package cTCI;

import cTCI.data_structures.TreeNode;

/**
 * This is the brute force solution for problem 4.12
 * Its runtime is O(NlogN), with the space complexity being O(1).
 * @author frausto
 *
 */

public class PathsWithSum {
	
	public static int countPathsWithSum(TreeNode root, int target) {
		if (root == null) return 0;
		
		/* Count paths with sum starting from the root. */
		int pathsFromRoot = countPathsWithSumFromNode(root, target, 0);
		
		/* Try the nodes on the left and right. */
		int pathsOnLeft = countPathsWithSum(root.left, target);
		int pathsOnRight = countPathsWithSum(root.right, target);
		
		return pathsFromRoot + pathsOnLeft + pathsOnRight;
	}
	
	/* Returns the number of paths with this sum starting from this node. */
	public static int countPathsWithSumFromNode(TreeNode node, int target, int current) {
		if (node == null) return 0;
	
		current += node.data;
		
		int totalPaths = 0;
		if (current == target) { // Found a path from the root
			totalPaths++;
		}
		
		totalPaths += countPathsWithSumFromNode(node.left, target, current); // Go left
		totalPaths += countPathsWithSumFromNode(node.right, target, current); // Go right
		
		return totalPaths;
	}	
	
	
	//driver code
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(0);
		root.right = new TreeNode(0);
		root.right.left = new TreeNode(0);
		root.right.left.right = new TreeNode(0);
		root.right.right = new TreeNode(0);
		System.out.println(countPathsWithSum(root, 0));
		System.out.println(countPathsWithSum(root, 4));
	}
}


