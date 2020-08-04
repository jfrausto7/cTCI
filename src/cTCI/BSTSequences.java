package cTCI;

import java.util.ArrayList;
import java.util.LinkedList;

import cTCI.data_structures.TreeNode;

public class BSTSequences {
	
	public static ArrayList<LinkedList<Integer>> allSequences(TreeNode node){
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		
		//base case
		if(node == null) {
			result.add(new LinkedList<Integer>());
			return result;
		}
		
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(node.data);
		
		//recurse on left and right subtrees
		ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
		ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);
		
		//weave together each list from the left and right sides
		for(LinkedList<Integer> left : leftSeq) {
			for(LinkedList<Integer> right: rightSeq) {
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
				weaveLists(left, right, weaved, prefix);
				result.addAll(weaved);
			}
		}
		return result;
	}
	
	/**
	 * Weave lists in all possible ways with the method below
	 */
	public static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
			ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
		//one list is empty, add remainder to a cloned prefix and store result
		if(first.size() == 0 || second.size() == 0) {
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}
		
		//recursive step: use head of first added to prefix, then return
		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		first.addFirst(headFirst);
		
		//do same thing with second
		int headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		second.addFirst(headSecond);
	}
	
	//driver code
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(5);
		
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);
		
		
		//actually perform code
		System.out.println(allSequences(root));
	}

}
