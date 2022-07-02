package main.ir.ac.kntu;
/* Program to get maximum number of edges which
can be removed such that each connected component
of this tree will have an even number of vertices */

import java.util.Scanner;
import java.util.Vector;

class Graph
{

    // graph
    static Vector<Vector<Integer>> g = new Vector<Vector<Integer>>();

    static int res;

    // Utility method to do DFS of the graph and count edge
// deletion for even forest
    static int dfs( int u, boolean visit[])
    {
        visit[u] = true;
        int currComponentNode = 0;

        // iterate over all neighbor of node u
        for (int i = 0; i < g.get(u).size(); i++)
        {
            int v = g.get(u).get(i);
            if (!visit[v])
            {
                // Count the number of nodes in a subtree
                int subtreeNodeCount = dfs(v, visit);

                // if returned node count is even, disconnect
                // the subtree and increase result by one.
                if (subtreeNodeCount % 2 == 0)
                    res++;

                    // else add subtree nodes in current component
                else
                    currComponentNode += subtreeNodeCount;
            }
        }

        // number of nodes in current component and one for
        // current node
        return (currComponentNode + 1);
    }

    /* method returns max edge that we can remove, after which
        each connected component will have even number of
        vertices */
    static int maxEdgeRemovalToMakeForestEven( int N)
    {
        // Create a visited array for DFS and make all nodes
        // unvisited in starting
        boolean visit[]=new boolean[N + 1];
        for (int i = 0; i <= N; i++)
            visit[i] = false;

        res = 0; // Passed as reference

        // calling the dfs from node-0
        dfs(0, visit);

        return res;
    }

    // Utility function to add an undirected edge (u,v)
    static void addEdge( int u, int v)
    {
        g.get(u).add(v);
        g.get(v).add(u);
    }

    // Driver code to test above methods
    public static void main(String args[])
    {
        //As the question has said, the graph will be tree.
        //So the program will work properly for trees.
        //exp4 and exp5 are not tree.
        //exp1: [[1, 3], [0], [3, 4], [2, 0], [5, 2], [4]]
        //output : 2 CORRECT
        //exp2: [[1],[0,2],[1]]
        //output: :( CORRECT
        //exp3: [[6], [9, 4], [8, 4], [7, 6], [5, 2, 1], [4], [0, 3], [3, 9], [2], [7, 1]]
        //output: 4 CORRECT
        //exp4: [[1, 3], [0, 2], [1, 3], [0, 2], [6, 5], [6, 4], [4, 5], []]
        //output:1 WRONG :(
        //exp5:[[1, 2], [0, 2], [0, 1], []]
        //output:1 WRONG :(
        //exp6:[[1], [0, 2], [1, 3], [2]]
        //output:1 RIGHT
        //exp7:[[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11], [0], [0], [0], [0], [0], [0], [0], [0], [0], [0], [0]]
        //output: :( RIGHT

        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int j=0;
        if (n%2!=0){
            j=1;
        }
        else {
            for (int i = 0; i < n; i++) {
                g.add(new Vector<>());
            }
            int a;
            int b;
            System.out.println(g);
            for (int i = 0; i < n - 1; i++) {
                a = scanner.nextInt();
                b = scanner.nextInt();
                g.get(a).add(b);
                g.get(b).add(a);
                System.out.println(g);
            }
            for (int i=0;i<n;i++){
                if (g.get(i)==null){
                    j=2;
                }
            }
            if (j != 0){
                System.out.println(":(");
            } else if (maxEdgeRemovalToMakeForestEven(n) == 0) {
                System.out.println(":(");
            } else {
                System.out.println(maxEdgeRemovalToMakeForestEven(n));
            }
        }
    }
}
 