# connected-components-in-graph
how much is the maximum number of edges that we could delete so every connected component has an even number of vertices?🤔
It's guaranteed that the graph is tree.
Term Project of Discrete Mathematical.
Khaje Nasir Toosi University of thechnology,IR.😎

Input: 
  n -> number of vertices in graph
  In next n-1 lines we add edges. 
 
 
🤞 More Description:

🎄Tree{
    A tree is an undirected graph G that satisfies any of the following equivalent conditions:
      ✔G is connected and acyclic (contains no cycles).
      ✔G is acyclic, and a simple cycle is formed if any edge is added to G.
      ✔G is connected, but would become disconnected if any single edge is removed from G.
      ✔G is connected and the 3-vertex complete graph K3 is not a minor of G.
      ✔Any two vertices in G can be connected by a unique simple path.
    If G has finitely many vertices, say n of them, then the above statements are also equivalent to any of the following conditions:
      ✔G is connected and has n − 1 edges.
      ✔G is connected, and every subgraph of G includes at least one vertex with zero or one incident edges. (That is, G is connected and 1-degenerate.)
      ✔G has no simple cycles and has n − 1 edges
  
}For more Information visit https://en.wikipedia.org/wiki/Tree_(graph_theory)


🧵Depth First Search Algorithm {
    A standard DFS implementation puts each vertex of the graph into one of two categories:
        1.Visited
        2.Not Visited
    The purpose of the algorithm is to mark each vertex as visited while avoiding cycles.

    The DFS algorithm works as follows:

        1.Start by putting any one of the graph's vertices on top of a stack.
        2.Take the top item of the stack and add it to the visited list.
        3.Create a list of that vertex's adjacent nodes. Add the ones which aren't in the visited list to the top of the stack.
        Keep repeating steps 2 and 3 until the stack is empty.
  } More explanation on https://www.programiz.com/dsa/graph-dfs
  
