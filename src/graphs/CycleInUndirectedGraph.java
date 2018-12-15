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

        if(obj.isCyclicCheck())
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


    // 2nd approach using union find
    private boolean isCyclicCheck() {
        int[] parents = new int[1000];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        for (Object node : graph.keySet()) {
            for (Object child : graph.get(node)) {
                int root1 = (int) findParent(parents, (Integer) node);
                int root2 = (int) findParent(parents, (Integer) child);

                if (root1 == root2) return true;

                parents[root2] = root1;
            }
        }

        return false;
    }

    private int findParent(int[] parents, int node) {
        if (node == parents[node])
            return node;
        return findParent(parents, parents[node]);
    }
}
