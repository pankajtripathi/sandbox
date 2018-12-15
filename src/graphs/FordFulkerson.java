package graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class FordFulkerson {
    public static void main (String[] args) {
        // Let us create a graph shown in the above example
        int[][] graph = new int[][]{
                {0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0}
        };

        FordFulkerson m = new FordFulkerson();
        System.out.println("The maximum possible flow is " +
                m.fordFulkerson(graph, 0, 5));

    }

    private boolean bfs(int[][] graph, int source, int sink, int[] parent) {
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            visited[i] = false;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(source);
        visited[source] = true;
        parent[source] = -1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int v = 0; v < graph.length; v++) {
                if (!visited[v] && graph[current][v] > 0) {
                    queue.add(v);
                    parent[v] = current;
                    visited[v] = true;
                }
            }
        }

        // normal bfs but just make sure that sink is reachable
        return visited[sink];
    }

    private int fordFulkerson(int[][] graph, int source, int sink) {
        // residual graph
        int rGraph[][] = new int[graph.length][graph.length];
        for (int u = 0; u < graph.length; u++) {
            for (int v = 0; v < graph.length; v++) {
                rGraph[u][v] = graph[u][v];
            }
        }

        // This array is filled by BFS and to store path
        int parent[] = new int[graph.length];
        int max_flow = 0;  // There is no flow initially

        while (bfs(rGraph, source, sink, parent)) {
            int path_flow = Integer.MAX_VALUE;

            // Find minimum residual capacity of the edges
            // along the path filled by BFS. Or we can say
            // find the maximum flow through the path found.
            for (int v=sink; v!=source; v=parent[v]) {
                int u = parent[v];
                path_flow = Math.min(path_flow, rGraph[u][v]);
            }

            // update residual capacities of the edges and
            // reverse edges along the path
            for (int v = sink; v != source; v=parent[v]) {
                int u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
            }

            max_flow += path_flow;
        }

        return max_flow;
    }
}
