package graphs;

import java.util.*;

/*
*  1. Sort all the edges in non-decreasing order of their weight.
   2. Pick the smallest edge. Check if it forms a cycle with the spanning tree formed so far.
      If cycle is not formed, include this edge. Else, discard it.
   3. Repeat step#2 until there are (V-1) edges in the spanning tree.
* */
public class Kruskal {
    private Map<Integer, Set<Integer>> forest = new HashMap<>();
    private static int V;
    private static int E;

    public static void main(String[] args) {
        /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
        V = 4;  // Number of vertices in graph
        E = 5;  // Number of edges in graph
        Graph graph = new Graph(V, E);

        // add edge 0-1
        graph.edge[0].source = 0;
        graph.edge[0].destination = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].source = 0;
        graph.edge[1].destination = 2;
        graph.edge[1].weight = 6;

        // add edge 0-3
        graph.edge[2].source = 0;
        graph.edge[2].destination = 3;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].source = 1;
        graph.edge[3].destination = 3;
        graph.edge[3].weight = 15;

        // add edge 2-3
        graph.edge[4].source = 2;
        graph.edge[4].destination = 3;
        graph.edge[4].weight = 4;

        List<Graph.Edge> mst = new Kruskal().kruskalMST(graph);
        int totalCost = 0;
        for (Graph.Edge edge : mst) {
            totalCost += edge.weight;
            System.out.print(edge.toString() + " ");
        }

        System.out.println("\nTotal cost of the Spanning Tree: " + totalCost);
    }

    private List<Graph.Edge> kruskalMST(Graph graph) {
        Stack<Graph.Edge> edges = new Stack<>();
        List<Graph.Edge> minSpanTree = new ArrayList<>();

        // The algorithm first says to make a a forest of trees. This means for every vertex you should create
        // a set with just itself as a member.
        for (int i = 0; i < V; i++) {
            Set<Integer> vs = new HashSet<>();
            vs.add(i);
            forest.put(i, vs);
        }

        // Create a stack of edges. Sorting edges in DESC order coz this is stored in stack later
        Arrays.sort(graph.edge, Comparator.reverseOrder());
        for (Graph.Edge edge : graph.edge) {
            edges.push(edge);
        }

        // For each edge you want to merge the sets of reachable vertices for the 2 vertices that is joined by the edge.
        // If the sets of reachable vertices is the same for the 2 vertices that make the edge then don't merge because
        // it will form a loop. If they don't, add the edge to your min tree.
        while (true) {
            Graph.Edge edge = edges.pop();

            Set<Integer> visited1 = forest.get(edge.source);
            Set<Integer> visited2 = forest.get(edge.destination);

            if (visited1.equals(visited2))
                continue;

            minSpanTree.add(edge);
            visited1.addAll(visited2);

            for (Integer i : visited1)
                forest.put(i, visited1);

            if (visited1.size() == V)
                break;
        }

        return minSpanTree;
    }
}
