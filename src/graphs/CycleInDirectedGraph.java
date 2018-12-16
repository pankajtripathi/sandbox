package graphs;

import java.util.List;
import java.util.Map;

public class CycleInDirectedGraph {
    static Map<Object, List<Object>> graph;

    public static void main(String[] args) {
        Graph g = new Graph();

        g.addEdge(0, 2);
        g.addEdge(2, 0);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        graph = g.getGraph();

        CycleInDirectedGraph obj = new CycleInDirectedGraph();
        if(obj.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }

    private boolean isCyclic() {
        int[] visited = new int[1000];

        for (Object node : graph.keySet()) {
            if (isCyclicUtil(node, visited))
                return true;
        }
        return false;
    }

    private boolean isCyclicUtil(Object node, int[] visited) {
        // same node seen again as child of itself
        if (visited[(Integer)node] == -1) return true;

        if (visited[(Integer)node] == 1) return false;


        visited[(Integer)node] = -1;
        if (graph.containsKey(node)) {
            for (Object child : graph.get(node)) {
                if (isCyclicUtil(child, visited))
                    return true;
            }
        }

        // only when done seeing all the children set it to 1
        visited[(Integer) node] = 1;
        return false;
    }
}
