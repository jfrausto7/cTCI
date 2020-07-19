package cTCI.data_structures;

import java.util.ArrayList;

public class Graph {
	public GraphNode[] nodes;
	
	public static class GraphNode{
		public String name;
		public ArrayList<GraphNode> children;
		public boolean visited = false;
		
		public GraphNode(String title) {
			this.name = title;
			this.children = new ArrayList<GraphNode>();
			
		}
	}
	
	public void addEdge(GraphNode start, GraphNode end) {
		start.children.add(end);
	}
}


