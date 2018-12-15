package graphs;

import java.util.*;

/*
In this problem, a tree is an undirected graph that is connected and has no cycles.

The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N),
with one additional edge added. The added edge has two different vertices chosen from 1 to N, and
was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v,
that represents an undirected edge connecting nodes u and v.

Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers,
return the answer that occurs last in the given 2D-array.
The answer edge [u, v] should be in the same format, with u < v.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given undirected graph will be like this:
  1
 / \
2 - 3

* */
class RedundantConnection {
    public static void main(String[] args) {
        int[][] edges = {
                {1,4},
                {3,4},
                {1,3},
                {1,2},
                {4,5}
        };
        System.out.println(Arrays.toString(new RedundantConnection().findRedundantConnection(edges)));
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] parents = new int[edges.length + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        for (int[] edge : edges) {
            int root1 = findParent(parents, edge[0]);
            int root2 = findParent(parents, edge[1]);

            if (root1 == root2) return edge;

            parents[root2] = root1;
        }

        return new int[2];
    }

    private int findParent(int[] parents, int node) {
        if (parents[node] == node)
            return node;
        return findParent(parents, parents[node]);
    }
}
