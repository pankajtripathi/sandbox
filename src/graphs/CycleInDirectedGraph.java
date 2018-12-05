package graphs;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        Set<Object> visited = new HashSet<>();
        Set<Object> visitedStack = new HashSet<>();

        for (Object node : graph.keySet()) {
            if (isCyclicUtil(node, visited, visitedStack))
                return true;
        }
        return false;
    }

    // if a node is in the stack then there is a cycle
    private boolean isCyclicUtil(Object node, Set<Object> visited, Set<Object> visitedStack) {
        // add current node to visited and in the stack
        visited.add(node);
        visitedStack.add(node);

        // if the child is not visited then add to visited and make recursive call
        // if it's visited and in the stack then cycle exists
        if (graph.containsKey(node)) {
            for (Object child : graph.get(node)) {
                if (!visited.contains(child)) {
                    visited.add(child);
                    isCyclicUtil(child, visited, visitedStack);
                } else if (visitedStack.contains(child)) {
                    return true;
                }
            }
        }

        // once checked for all child nodes then remove the node and return false
        visitedStack.remove(node);
        return false;
    }
}
