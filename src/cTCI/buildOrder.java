package cTCI;

import java.util.ArrayList;

import cTCI.data_structures.Graph;
import cTCI.data_structures.Graph.GraphNode;

public class buildOrder {
	
	public static String buildOrder(String[] projects, String[][] dependencies) {
		//base cases
		if(projects == null || projects.length == 0) return null;
		if(dependencies == null || dependencies.length == 0) return projects.toString();
		
		//create graph and list
		Graph graph = new Graph();
		graph.nodes = new ArrayList<GraphNode>();
		ArrayList<String> result = new ArrayList<String>();
		
		//iterate through, create nodes, and add to graph
		for(String s : projects) {
			GraphNode node = new GraphNode(s);
			graph.nodes.add(node);
		}
		
		//iterate through dependencies and make edges
		for(GraphNode node : graph.nodes) {
			for(String[] s : dependencies) {
				if(node.name == s[0]) {
					for(GraphNode n : graph.nodes) {
						if(n.name == s[1]) {
							graph.addEdge(node, n);
						}
					}	
				}
			}
		}
		
		//the main meat
		while(!graph.nodes.isEmpty()) {
			GraphNode node = graph.nodes.remove(0);
			//base case for breakage
			if(!node.parents.isEmpty()) {
				if(node.visited == true) {
					return null;
				}
				node.visited = true;
				graph.nodes.add(node);
				continue;
			}
			
			//delete edges
			for(GraphNode child : node.children) {
				child.parents.remove(node);
			}
			node.children.clear();
			
			//add to result
			result.add(node.name);
			
			//clear visited
			for(GraphNode each : graph.nodes) {
				each.visited = false;
			}
		}
		
		//create result array
		String resultArray = result.toString();
		
		return resultArray;
	}
	
	
	//driver code
	public static void main(String[] args) {
		String[] arrayToTest = {"a","b","c","d","e","f","g"};
		String[][] dependencyToTest = {
				{"a","e"},
				{"f","b"},
				{"f","c"},
				{"b","a"},
				{"b","e"},
				{"c","a"},
				{"d","c"},
				{"d","g"}
		};
		System.out.println(buildOrder(arrayToTest, dependencyToTest));
	}

}
