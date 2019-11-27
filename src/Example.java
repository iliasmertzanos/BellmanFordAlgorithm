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

      /*  System.out.println("\n============= 3rd example ==============");
        
        graph = new Graph(7);
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 5, 2);
        graph.addEdge(1, 2, 2);        
        graph.addEdge(1,3,5);
        graph.addEdge(1,5,3);
        graph.addEdge(1,0,0);
        graph.addEdge(2,3,2);
        graph.addEdge(2,5,1);
        graph.addEdge(3,4,-1);
        graph.addEdge(3,6,4);
        graph.addEdge(4,3,1);
        graph.addEdge(4,6,0);
        graph.addEdge(4,5,-1);
        graph.addEdge(5,0,2);
        graph.addEdge(5,1,3);
        graph.addEdge(5,2,0);
        //doManyThings(graph); */

    /*    System.out.println("\n============= 4th example ==============");
        
        // veraendere den Graph aus dem 3. Beispiel        
        
        try {
	    System.out.println("\nWir veraendern den Graph aus dem dritten Beispiel ...");
        System.out.println("------------- Example 4A ---------------");
	    graph.addEdge(5, 2, -1); // (5, 2) gibt es schon, so geht das also nicht!
        } catch (Exception e) {
	    System.out.println(e);
        }
	System.out.println("\n... wir veraendern ihn nochmal ...");
        System.out.println("------------- Example 4B ---------------");
        graph.setWeight(5,2,-1); // das geht, nun gibt es aber einen negativen Kreis.
        
        try {
	    doManyThings(graph);
        } catch (Exception e) {
	    System.out.println(e);
	}
        
        try {
	    System.out.println("\n... und wir veraendern ihn ein letztes Mal ...");
        System.out.println("------------- Example 4C ---------------");
	    graph.removeEdge(5,2);
	    graph.removeEdge(3,4);
	    graph.removeEdge(4,5);
	    doManyThings(graph);
        } catch (Exception e) {
	    System.out.println(e);
	} */
    }

	
	/**
	 * Runs the shortest path computation and displays some of the results.
	 * @param graph The graph to work with.
	 */
	
    public static void doManyThings(Graph graph) {        
		
		
		
	    // FIXME
	    // Eventuell muesst ihr das an eure Klasse ein bisschen anpassen,
	    // wenn eure Methoden anders aufgerufen werden.
	
	    System.out.println("Example for what can be done. First, the graph:");
	    System.out.println(graph);
         
	    System.out.println("Computing the distances ...");         
	    BellmanFord bf = new BellmanFord(graph);
	    
	    System.out.println("Done. Here are the distances");         
	    printMatrix(bf.getDistances());
	    	/*System.out.println("Some single distances:");
	    	System.out.println("From 0 to 3: " + bf.getDistance(0,3));
	    	System.out.println("From 1 to 3: " + bf.getDistance(1,3));
	    	System.out.println("From 2 to 3: " + bf.getDistance(2,3));*/
	    System.out.println("Here are the tree variables");                 
	    printMatrix(bf.getTree());        
	    /*
	    System.out.println("This is a shortest path tree for vertex 0:");
	    Graph tree = bf.getShortestPathTree(0);
	    System.out.println(tree);
        */
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
