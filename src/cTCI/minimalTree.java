package cTCI;

import java.lang.reflect.Array;
import java.util.Arrays;

import cTCI.data_structures.TreeNode;

public class minimalTree {
	
	public static TreeNode minimalTree(int[] array, int start, int end) {
		//base case
		if(start > end) {
			return null;
		}
		//get root node first
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(array[mid]);
		
		//set both sides up with recursion
		root.left = minimalTree(array, start, mid-1);
		root.right = minimalTree(array, mid+1, end);
		
		return root;
	}
	
	public static void preOrderTraversal(TreeNode node) {
		if(node != null) {
			System.out.println(node.data);
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}
	
	
	//driver code
	public static void main(String[] args) {
		int[] arrayToTest = {10,14,19,27,31,35,42};
		
		//create tree and get root
		TreeNode root = minimalTree(arrayToTest, 0, arrayToTest.length-1);
		
		//print tree
		preOrderTraversal(root);
	}
}
