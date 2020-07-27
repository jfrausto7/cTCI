package cTCI;

import java.util.Stack;

import cTCI.data_structures.Graph;
import cTCI.data_structures.Graph.GraphNode;

public class isRoute {
	public static boolean isRoute(GraphNode S, GraphNode E) {
		Stack<GraphNode> adjacent = new Stack<GraphNode>();
		
		if(S == null || S.children.size() == 0) {
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
		
		
		GraphNode node0 = new GraphNode("0");
		GraphNode node1 = new GraphNode("1");
		GraphNode node2 = new GraphNode("2");
		GraphNode node3 = new GraphNode("3");
		GraphNode node4 = new GraphNode("4");
		GraphNode node5 = new GraphNode("5");
		
		graph.nodes.add(node0); 
		graph.nodes.add(node1); 
		graph.nodes.add(node2); 
		graph.nodes.add(node3); 
		graph.nodes.add(node4); 
		graph.nodes.add(node5); 
		graph.addEdge(node0, node1);
		graph.addEdge(node0, node4);
		graph.addEdge(node0, node5);
		graph.addEdge(node1, node3);
		graph.addEdge(node1, node4);
		graph.addEdge(node2, node1);
		graph.addEdge(node3, node2);
		graph.addEdge(node3, node4);
		
		
		
		//actual run-through
		System.out.println(isRoute(node0, node4));
		
	}

}
