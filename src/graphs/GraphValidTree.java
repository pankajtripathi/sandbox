package graphs;

public class GraphValidTree {
    public static void main(String[] args) {
        int[][] edges1 = {
                {0, 1},
                {2, 3}
        };
        System.out.println(new GraphValidTree().validTree(4, edges1));

        int[][] edges2 = {
                {0, 1},
                {2, 3},
                {0, 2}
        };
        System.out.println(new GraphValidTree().validTree(4, edges2));
    }

    private boolean validTree(int n, int[][] edges) {
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int[] edge : edges) {
            int root1 = findParent(parents, edge[0]);
            int root2 = findParent(parents, edge[1]);

            if (root1 == root2)
                return false;

            parents[root2] = root1;
        }

        return edges.length == n - 1;
    }

    private int findParent(int[] parents, int node) {
        if (node == parents[node])
            return node;
        return findParent(parents, parents[node]);
    }
}
