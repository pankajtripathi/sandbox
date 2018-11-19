package graphs;

import java.util.*;

public class Graph {
    static boolean isDirected = false;
    Map<Object, List<Object>> graph;
    Set<Object> visited;

    Graph() {
        this.graph = new HashMap();
        this.visited = new HashSet<>();
    }

    void traverse(){
        for (Object key : graph.keySet()) {
            System.out.println(key + " : " + graph.get(key));
        }
    }

    Map<Object, List<Object>> getGraph(){
        return graph;
    }

    Set<Object> getVisited(){
        return visited;
    }

    void addEdge(Object source, Object destination) {
        if (graph.containsKey(source)) {
            graph.get(source).add(destination);
        } else {
            List<Object> init = new ArrayList<>();
            init.add(destination);
            graph.put(source, init);

            visited.add(source);
        }

        if (isDirected) {
            graph.put(destination, new ArrayList<>());
            visited.add(destination);
        }
    }

    public static void main(String[] args) {
        Graph obj = new Graph();
        obj.addEdge("A", "C");
        obj.addEdge("A", "B");
        obj.addEdge("B", "D");
        obj.addEdge("C", "D");
        obj.addEdge("C", "E");
        obj.addEdge("D", "E");
        obj.traverse();
    }
 }
