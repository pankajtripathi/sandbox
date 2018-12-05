package graphs;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CycleInUndirectedGraph {
    static Map<Object, List<Object>> graph;

    public static void main(String[] args) {
        Graph g = new Graph();

        // contains cycle
        g.addEdge(0, 2);
        g.addEdge(2, 0);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(3, 4);

        // Doesn't contain cycle
        // g.addEdge(0, 1);
        // g.addEdge(1, 2);

        graph = g.getGraph();

        CycleInUndirectedGraph obj = new CycleInUndirectedGraph();
        if(obj.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }

    private boolean isCyclic() {
        Set<Object> visited = new HashSet<>();

        for (Object node : graph.keySet()) {
            if (!visited.contains(node)) {
                if (isCyclicUtil(visited, node, -1))
                    return true;
            }
        }

        return false;
    }

    private boolean isCyclicUtil(Set<Object> visited, Object node, Object parent) {
        visited.add(node);

        if (graph.containsKey(node)) {
            for (Object child : graph.get(node)) {
                if (!visited.contains(child)) {
                    if (isCyclicUtil(visited, child, node))
                        return true;
                } else if (!child.equals(parent)) {
                    return true;
                }
            }
        }
        return false;
    }
}
