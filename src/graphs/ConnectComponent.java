package graphs;

/*

Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
write a function to find the number of connected components in an undirected graph.

Example 1:

Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]

     0          3
     |          |
     1 --- 2    4

Output: 2
* */
public class ConnectComponent {
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1},
                {1, 2},
                {3, 4}
        };

        System.out.println(new ConnectComponent().countComponents(5, edges));
    }

    private int countComponents(int n, int[][] edges) {
        int[] parents = new int[n];
        for (int i = 0; i < n; i++)
            parents[i] = i;

        int res = n;
        for (int[] edge : edges) {
            int root1 = findParent(edge[0], parents);
            int root2 = findParent(edge[1], parents);

            if (root1 != root2) {
                res--;
                parents[root2] = root1;
            }
        }

        return res;
    }

    private int findParent(int node, int[] parents) {
        if (node == parents[node])
            return node;
        return findParent(parents[node], parents);
    }
}
