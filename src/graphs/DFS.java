package graphs;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DFS {
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

        DFS obj = new DFS();
        obj.dfs("2");

        obj.visited.clear();
        System.out.println(obj.isReachable("1", "3"));
    }

    // Add source to visited and print the source. Keep on visiting each vertex reachable from the source if the vertex
    // has not been visited yet.
    private void dfs(String source) {
        visited.add(source);

        System.out.println(source);

        for (Object vertex : graph.get(source)) {
            if (!visited.contains(vertex))
                dfs((String) vertex);
        }
    }

    private boolean isReachable(String current, String destination) {
        // if the current is destination then true else if the graph has not connected vertex and visited node is just
        // current node then return false
        if (current.equals(destination)) {
            return true;
        } else if (visited.contains(current) || graph.get(current) == null) {
            return false;
        }

        // similar to dfs
        visited.add(current);
        for (Object vertex : graph.get(current)) {
            if (isReachable((String) vertex, destination))
                return true;
        }

        return false;
    }
}
