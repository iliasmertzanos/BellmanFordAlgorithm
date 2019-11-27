/**
 * This class analyzes a graph of class Graph. It evaluates 
 * with the Bellman-Ford-Algorithm the matrix U_n and the 
 * tree-Matrix.
 * 
 * @author Marco
 *
 */
public class BellmanFord {
	
	private int[][] tree;	
	private double[][] U_n;
	private boolean negativeCycle;
	
	public BellmanFord(Graph g) {
		
		U_n = bellman(g);
		tree = tree(g);
		
		for(int i = 0; i < U_n.length; i++) {
			for(int j = 0; j < U_n.length; j++) {
				
				if(U_n[i][j] < 0)
					negativeCycle = true;
			}
			
		}
	}
	
	/**
	 * This getter method provides the Bellman-Ford Matrix U.
	 * 
	 * @return the Bellman-Ford Matrix U. 
	 */
	double[][] getDistances() throws IllegalArgumentException{
		
		if(negativeCycle == true)
			throw new IllegalArgumentException("Negative Cycles!");
		return U_n;
	}
	
	/**
	 * This getter method provides the Tree-Matrix tree.
	 * 
	 * @return the tree matrix corresponding to Bellman-Ford-Matrix.
	 */
	int[][] getTree() {
		
		return tree;
	}
	
	/**
	 * Receives two nodes (start node v and end node w) and returns the distance as a double.
	 * @param v
	 * @param w
	 * @return
	 */
	double getDistance(int v, int w) {
		
		return getDistances()[v][w];		
	}

	int[] getShortestPath(int v, int w) throws IllegalArgumentException{
		
		if(negativeCycle == true)
			throw new IllegalArgumentException("Negative Cycles!");
		
		int counterForLength = 0;
		int j = w; // Bsp: w = 3 d.h. {0,1,2,3}
		
		while(j != v) {
			
			j = getTree()[v][j];
			counterForLength++;
			
			if(j<0)
				return null;
		}
		
		int[] container = new int[counterForLength+1];
		
		container[container.length-1] = w;
		
		int i = w;
		for(int k = container.length-2; k >= 0; k--) {
			
			container[k] = getTree()[v][i];
			i = getTree()[v][i];
		}
		
		return container;
	}
	
	public Graph getShortestPathTree(int v) throws IllegalArgumentException{
		
		if(negativeCycle == true)
			throw new IllegalArgumentException("Negative Cycles!");
	
		
		return new Graph(0);
	}
	
	public double[][] bellman(Graph g){
		
		int n = g.getNumberOfNodes(); // number of nodes
		double[][] u = new double[n][n];
		// initialize u
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				u[i][j] = g.getWeight(i, j);
			}
		}
		// main loop
		for (int m = 2; m < n; m++){
			for (int i = 0; i < n; i++) {
				double[] tmp = new double[n]; // tmp array
				// for calculating min{...} in Bellman equation
				for (int j = 0; j < n; j++) {
					// save current distance from i to j
					tmp[j] = u[i][j];
					for (int k = 0; k < n; k++) {
						if (tmp[j] > u[i][k] + g.getWeight(k, j)) {
							tmp[j] = u[i][k] + g.getWeight(k, j);
						}
					}// end for k
				}// end for j
				// store tmp in u[i]
				for (int j = 0; j < n; j++) {
					u[i][j] = tmp[j];
				}
			}// endfor i
		}// endfor m
		
		return u;
	}
	
	public int[][] tree(Graph g) {
		
		int n = g.getNumberOfNodes(); // number of nodes
				
		int[][] tree = new int[n][n];
				
		for(int i = 0; i < n; i++) {
			for(int j =0; j < n; j++) {
				if(g.containsEdge(i, j))
					tree[i][j] = i;
				else
					tree[i][j] = -1;
			}
		}
					
		double[][] u = new double[n][n];
		for ( int i = 0; i < n; i++ )
			for ( int j = 0; j < n; j++ ) u[i][j] = g.getWeight(i, j);
		for ( int m = 2; m < n; m++ )
			for ( int i = 0; i < n; i++ )
				for ( int j = 0; j < n; j++ )
					for ( int k = 0; k < n; k++ )
						if ( u[i][j] > u[i][k] + g.getWeight(k, j) ) {
							u[i][j] = u[i][k] + g.getWeight(k, j);
							tree[i][j] = k;
						}
		return tree;
	}
	
}
