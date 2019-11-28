# BellmanFordAlgorithm

## Implementation of the Bellman Ford algorithm
This java code was developed during my master degree studies within a project team. 
It can be tested using the main method of the class `Example` in the src folder, where two examples are being taken into consideration.

In the package the constructor of the class `BellmanFord` takes as argument a Graph an then initilizes two internal arrays:
- `private int[][] tree;`	, stores the minimum path 
  - for example `tree[1][3]=2` means that the sortest path from `1->3` goes over node 2 
- `private double[][] U_n;` , stores the minimum path value

Once the constructor `public BellmanFord(Graph g)` has been invoked then the method `int[] getShortestPath(int v, int w) throws IllegalArgumentException` can determine the sortest path returning an array with all the nodes.

The class `Graph` is in the src folder to be found, which implements a directed Grap and doesn't allows parallel edges and self-loops.

For specific information see the source code comments. 
For german speakers see also the task description in the src folder.

If you want learn how it works by playing around I recomment this applet here:

https://www-m9.ma.tum.de/graph-algorithms/spp-bellman-ford/index_en.html
