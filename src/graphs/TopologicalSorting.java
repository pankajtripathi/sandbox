package graphs;

import java.util.*;

public class TopologicalSorting {
    static Map<Object , List<Object>> graph;
    static Set<Object> visited = new HashSet<>();
    static Stack<Object> stack = new Stack<>();

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge("5", "2");
        g.addEdge("5", "0");
        g.addEdge("4", "0");
        g.addEdge("4", "1");
        g.addEdge("2", "3");
        g.addEdge("3", "1");
        graph = g.getGraph();

        new TopologicalSorting().sort();
    }

    private void sort() {
        for (Object vertex : graph.keySet()) {
            if (!visited.contains(vertex))
                dfs(vertex);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop().toString());
        }
    }

    private void dfs(Object vertex) {
        if (graph.containsKey(vertex)) {
            for (Object child : graph.get(vertex)) {
                if (!visited.contains(child)) {
                    dfs(child);
                }
            }
        }

        visited.add(vertex);
        stack.push(vertex);
    }
}
