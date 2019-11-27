/**
 * The class Graph handles directed graphs with nodes and edges.
 */
public class Graph {
	
	/**
	 * Stores the set of nodes and their connection with edges 
	 * in a two-dimensional array.
	 */
	private boolean[][] graphArray;
	
	/**
	 * Provides information about the assessment of the edges in 
	 * a two-dimensional array.
	 */
	private double[][] assesmentArray;
	
	/**
	 * Counts how often edges are removed.
	 */
	private int counterRemove;
	
	/**
	 * Counts how often edges are added.
	 */
	private int counterAdd;
	
	/**
	 * Adds an directed edge from node v to w. At one go its weight is 
	 * imparted and this weight is saved in the assesmentArray.
	 * 
	 * @param v is the node where the edge starts
	 * @param w is the node where the edge ends
	 * @param weight is the weight stored in assesmentArray.
	 * 
	 * @exception IllegalArgumentException if the edge already exists, if v equals w, if an edge the other 
	 * way around is already established or if a non-existing index of node is invoked. 
	 */
	public void addEdge (int v, int w, double weight) throws IllegalArgumentException {
		
		if(graphArray[v][w] != false)
			throw new IllegalArgumentException("This edge is already defined.");
		
		if(v == w)
			throw new IllegalArgumentException("Loops aren't allowed.");
		
		//if(graphArray[w][v] != false)
			//throw new IllegalArgumentException("One edge for every pair of nodes.");
		
		if(v > graphArray.length || w > graphArray[0].length )
			throw new IllegalArgumentException("The conveyed index for a node is not part of the graph.");
		
		counterAdd++;
		graphArray[v][w] = true;
		setWeight(v, w, weight);
	}
	
	/**
	 * This method removes the edge between node v and w.
	 * 
	 * @param v is the node where the edge starts
	 * @param w is the node where the edge ends
	 */
	public void removeEdge(int v, int w) {
		
		counterRemove++;
		graphArray[v][w] = false;
	}
	
	/**
	 * This method examines whether a edge is defined or not.
	 * 
	 * @param v is node v
	 * @param w is node w
	 * 
	 * @return True is returned if the edge exists, if not false is given back.
	 */
	public boolean containsEdge(int v, int w) {
		
		if(graphArray[v][w] == false)
			return false;
		
		return true;
	}
	
	/**
	 * Sets a new weight of an edge only if the edge exists in the graph.
	 * 
	 * @param v is node where the edge starts.
	 * @param w is node where the edge arrives.
	 * @param weight contains the value which is to set as new weigth.
	 * 
	 * @exception IllegalArgumentException if one tries to set a new weight to a non-existing edge.
	 */
	public void setWeight(int v, int w, double weight) throws IllegalArgumentException{
		
		if(graphArray[v][w] == false)
			throw new IllegalArgumentException("Setting the weight of a non-existing edge is not allowed.");
		
		if(weight == Double.POSITIVE_INFINITY || weight == Double.NEGATIVE_INFINITY)
			throw new IllegalArgumentException("You can't set a new weight with these values.");
			
		assesmentArray[v][w] = weight;
	}
	
	/**
	 * Returns the weight of the edge from node v to node w.
	 * 
	 * @param v is node where the edge starts.
	 * @param w is node where the edge arrives.
	 * 
	 * @return the weight of the edge from v to w.
	 */
	public double getWeight(int v, int w) {
		
		return assesmentArray[v][w];
	}
	
	/**
	 * This method returns the number of nodes as an integer value.
	 * 
	 * @return the number of nodes represented by graphArray.
	 */
	public int getNumberOfNodes() {
		
		return graphArray.length;
	}
	
	/**
	 * This method reckons the difference of addEdges method calls and removeEdges method calls.
	 * 
	 * @return the current number of edges
	 */
	public int getNumberOfEdges() {
		
		return counterAdd-counterRemove;
	}
	
	/**
	 * This method visualizes the graph in matrix style.
	 * 
	 * @return gives back a representation of the graph as a matrix.
	 */
	public String toString() {
		
		String matrix = "\n" + "Consists of " + graphArray.length + " nodes." + "\n \n";
		
		for(int i = 0; i < graphArray.length; i++) {
			
			for(int j = 0; j < graphArray.length-1; j++) {
				
				matrix += graphArray[i][j] + "\t";
			}
			
			matrix += graphArray[i][graphArray.length-1] + "\n";

		}
		
		matrix += "\n";
		
		for(int i = 0; i < graphArray.length; i++) {
			
			for(int j = 0; j < graphArray.length-1; j++) {
				
				matrix += this.getWeight(i,j) + "\t";
			}
			
			matrix += this.getWeight(i,graphArray.length-1) + "\n";

		}
		
		return matrix;
	}
	
	/**
	 * The constructor generates a empty graph. This means every field 
	 * in graphArray is set on false, hence no edges exist.
	 * @param n
	 */
	public Graph(int n) {
		
		graphArray = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			
			for(int j = 0; j < n; j++) {
				
				graphArray[i][j] = false;
			}
		}
		
		assesmentArray = new double[n][n];
		
		for(int i = 0; i < n; i++) {
			
			for(int j = 0; j < n; j++) {
				
				if(i == j)
					assesmentArray[i][j] = 0;
				
				else
					assesmentArray[i][j] = Double.POSITIVE_INFINITY;
			}
		}
	}
}