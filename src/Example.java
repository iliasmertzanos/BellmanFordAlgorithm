/**
 * A class that creates a few example graphs and calls the shortest path routines for them.
 */
public class Example {

    /**
     * The main method.
     * @param args The arguments will be ignored.
     */
    public static void main (String[] args) {

        System.out.println("\n============= 1st example ==============");

	Graph graph = new Graph(4);
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 3);
        graph.addEdge(2, 3, 1);
        
        doManyThings(graph);
        
        System.out.println("\n============= 2nd example ==============");
        
        graph = new Graph(9);
        graph.addEdge(0, 1, 2);
        graph.addEdge(1, 0, 2);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 1, 2);
        graph.addEdge(0, 3, 1);
        graph.addEdge(3, 0, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(3, 1, 1);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 2, 1);
        graph.addEdge(2, 4, 3);
        graph.addEdge(4, 2, 3);
        graph.addEdge(1, 5, 2);
        graph.addEdge(5, 1, 2);
        graph.addEdge(2, 5, 3);
        graph.addEdge(5, 2, 3);
        graph.addEdge(3, 6, 1);
        graph.addEdge(6, 3, 1);
        graph.addEdge(4, 6, 2);
        graph.addEdge(6, 4, 2);
        graph.addEdge(5, 6, 1);
        graph.addEdge(6, 5, 1);
        graph.addEdge(0, 7, 4);
        graph.addEdge(7, 0, 4);
        graph.addEdge(0, 8, 5);
        graph.addEdge(8, 0, 5);
        graph.addEdge(7, 8, 2);
        graph.addEdge(8, 7, 2);
        
        doManyThings(graph); 

    }

	
	/**
	 * Runs the shortest path computation and displays some of the results.
	 * @param graph The graph to work with.
	 */
	
    public static void doManyThings(Graph graph) {     
    	
	    System.out.println("Example for what can be done. First, the graph:");
	    System.out.println(graph);
         
	    System.out.println("Computing the distances ...");         
	    BellmanFord bf = new BellmanFord(graph);
	    
	    System.out.println("Done. Here are the distances");         
	    printMatrix(bf.getDistances());
	    
	    System.out.println("Here are the tree variables");                 
	    printMatrix(bf.getTree());        
	    
	    System.out.println("The shortest paths from vertex 0 to the other vertices are:");
        
	    for (int i = 0; i < graph.getNumberOfNodes(); i++) {
		System.out.print(i + ": ");
		int[] path = bf.getShortestPath(0,i);
		if (path == null) {
		    System.out.print("no path");
		} else {
		    for (int j = 0; j < path.length; j++) {
			System.out.print(path[j] + " ");
		    }
		}
		System.out.println();
	    }
        	
        	
	}
	


           

   
	
	
	/**
	 * Displays a 2-dimensional array of double values on System.out.
	 * @param matrix The array
	 */
	public static void printMatrix(double[][] matrix) {
	    for (int i = 0; i < matrix.length; i++) {
		for (int j = 0; j < matrix[i].length; j++) {
		    double t = matrix[i][j];
		    if (t == Double.POSITIVE_INFINITY) {
			System.out.print("Inf");
		    } else {
			System.out.print(t);
		    }
		    System.out.print("\t ");
		}
		System.out.println();
	    }
	}

	/**
	 * Displays a 2-dimensional array of int values System.out.
	 * @param matrix The array
	 */	
	public static void printMatrix(int[][] matrix) {
	    for (int i = 0; i < matrix.length; i++) {
		for (int j = 0; j < matrix[i].length; j++) {
		    System.out.print(matrix[i][j] + "\t ");
		}
		System.out.println();
	    }
	}
    }
