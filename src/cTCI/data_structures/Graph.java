package cTCI.data_structures;

public class Graph {
	public GraphNode[] nodes;
	
	public static class GraphNode{
		public String name;
		public GraphNode[] children;
		public boolean visited = false;
	}
}


