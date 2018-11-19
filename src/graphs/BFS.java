package graphs;

import java.util.*;

public class BFS {
    static Map<Object, List<Object>> graph;
    Set<Object> visited = new HashSet<>();

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge("0", "1");
        g.addEdge("0", "2");
        g.addEdge("1", "2");
        g.addEdge("2", "0");
        g.addEdge("2", "3");
        g.addEdge("3", "3");

        graph = g.getGraph();

        BFS obj = new BFS();
        obj.bfs("2");
    }

    private void bfs(String source) {
        Queue<String> queue = new LinkedList<>();
        visited.add(source);
        queue.offer(source);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.println(current);

            for (Object vertex : graph.get(current)) {
                if (!visited.contains(vertex)) {
                    visited.add(vertex);
                    queue.offer((String) vertex);
                }
            }
        }
    }
}
