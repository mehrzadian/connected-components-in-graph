package main.ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Graph {
    // graph
    static ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();

    static int res;

    public Graph() {
    }

    public ArrayList<ArrayList<Integer>> getG() {
        return g;
    }

    public void setG(ArrayList<ArrayList<Integer>> g) {
        this.g = g;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    // Utility method to do DFS of the graph and count edge
// deletion for even forest
    private static int dfs( int u, boolean visit[])
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
    private static int maxEdgeRemovalToMakeForestEven( int N)
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
    private static void addEdge( int u, int v)
    {
        g.get(u).add(v);
        g.get(v).add(u);
    }

    private static void makeGraph(int[][] edges, int N) {
        for (int i = 0; i < N +1; i++)
            g.add(new ArrayList<Integer>());

        for (int i = 0; i < N; i++)
            addEdge( edges[i][0], edges[i][1]);
    }

    // Driver code to test above methods
    public static void main(String args[]) {


        int edges[][] ={{0, 2}, {0, 1}, {0, 4},
                {2, 3}, {4, 5}, {5, 6},
                {5, 7}};
        int N = edges.length;
        makeGraph(edges, N);
        System.out.println(maxEdgeRemovalToMakeForestEven( N));
        int edges3[][]={{7},{5,10},{5,9},
                {7,8},{2,3,6},{5},
                {1,4},{4,10},{3},
                {2,8}};
        int N3 = edges3.length;
        makeGraph(edges3,N3);
        System.out.println(maxEdgeRemovalToMakeForestEven( N3));
        int edges2[][]={{2},{1,3},{2}};
        int N2 = edges2.length;
        makeGraph(edges2,N2);
        System.out.println(maxEdgeRemovalToMakeForestEven( N2));
    }

}
