package cTCI;

import java.util.Stack;

import cTCI.data_structures.Graph;
import cTCI.data_structures.Graph.GraphNode;

public class isRoute {
	public static boolean isRoute(GraphNode S, GraphNode E) {
		Stack<GraphNode> adjacent = new Stack<GraphNode>();
		
		if(S == null || S.children.length == 0) {
			System.out.println("No children or node.");
			return false;
		}
		
		//add adjacent to array
		for(GraphNode n : S.children) {
			adjacent.add(n);
		}
		
		//now iterate through until condition met
		while(!adjacent.isEmpty()) {
			GraphNode k = adjacent.pop();
			k.visited = true;
			if(k == E) return true;
			
			//add neighbors if not visited
			for(GraphNode each : k.children) {
				if(each.visited == false) {
					adjacent.add(each);
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph();
		
		
		GraphNode node0 = new GraphNode();
		node0.name = "0";
		GraphNode node1 = new GraphNode();
		node1.name = "1";
		GraphNode node2 = new GraphNode();
		node2.name = "2";
		GraphNode node3 = new GraphNode();
		node3.name = "3";
		GraphNode node4 = new GraphNode();
		node4.name = "4";
		GraphNode node5 = new GraphNode();
		node5.name = "5";
		
		node0.children = new GraphNode[] {node1, node4, node5};
		node1.children = new GraphNode[] {node3, node4};
		node2.children = new GraphNode[] {node1};
		node3.children = new GraphNode[] {node2, node4};
		node4.children = new GraphNode[0];
		node5.children = new GraphNode[0];
		
		graph.nodes = new GraphNode[]{node0, node1, node2, node3, node4, node5}; 
		
		
		
		//actual run-through
		System.out.println(isRoute(node0, node4));
		
	}

}
