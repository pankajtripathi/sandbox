package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
For an undirected graph with tree characteristics, we can choose any node as the root.
The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called
minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of
their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of
undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same
as [1, 0] and thus will not appear together in edges.

Example 1 :
Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3

Output: [1]
* */
public class MinimumHeightTrees {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {
                {0, 3},
                {1, 3},
                {2, 3},
                {4, 3},
                {5, 4}
        };

        System.out.println(new MinimumHeightTrees().findMinHeightTrees(n, edges));
    }

    private List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<>();

        if (n == 0) return leaves;
        if (n == 1) {
            leaves.add(0);
            return leaves;
        }

        // construct the graph
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new HashSet<>());

        // populate the graph
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // if a node has one node connected then add it to leaves
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) leaves.add(i);
        }

        while (n > 2) {
            List<Integer> newLeaves = new ArrayList<>();
            n -= leaves.size();

            // get the neighbor of the leaf and remove it leaf and neighbor edge for leaf
            // then check if the size of the neighbors set is == 1 then add the neighbor to newLeaves
            for (int l : leaves) {
                int neighbor = graph.get(l).iterator().next();
                graph.get(neighbor).remove(l);
                if (graph.get(neighbor).size() == 1) newLeaves.add(neighbor);
            }

            leaves = newLeaves;
        }

        return leaves;
    }

}
