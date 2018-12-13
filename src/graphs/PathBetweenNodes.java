package graphs;

import java.util.*;

public class PathBetweenNodes {
    private static Map<Object , List<Object>> graph;
    private List<String> paths = new ArrayList<>();

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge("0", "1");
        g.addEdge("1", "2");
        g.addEdge("2", "0");
        g.addEdge("2", "3");
        g.addEdge("3", "3");
        graph = g.getGraph();

        new PathBetweenNodes().displayPaths("0", "2");
    }

    private void displayPaths(String source, String destination) {
        Set<Object> visited = new HashSet<>();
        List<String> paths = dfs(source, destination, visited, "");

        if (paths != null) {
            System.out.println(String.format("Path from %s to %s", source, destination));
            System.out.println(paths.get(0));
        } else {
            System.out.println("Cannot find path");
        }
    }

    private List<String> dfs(String current, String destination, Set<Object> visited, String res) {
        visited.add(current);
        res += current + " ";

        if (current.equals(destination)) {
            paths.add(res);
        } else {
            for (Object neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    dfs((String) neighbor, destination, visited, res);
                }
            }
        }

        return paths;
    }
}
