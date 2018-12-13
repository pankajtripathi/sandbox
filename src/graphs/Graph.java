package graphs;

import java.util.*;

public class Graph {
    boolean isDirected = false;
    Map<Object, List<Object>> graph;
    Set<Object> visited;
    int V;
    int E;
    Edge[] edge;

    Graph() {
        this.graph = new HashMap();
        this.visited = new HashSet<>();
    }

    Graph(int v, int e) {
        V = v;
        E = e;

        edge = new Edge[e];
        for (int i = 0; i < e; i++) {
            edge[i] = new Edge();
        }
    }

    void traverse(){
        for (Object key : graph.keySet()) {
            System.out.println(key + " : " + graph.get(key));
        }
    }

    Map<Object, List<Object>> getGraph(){
        return graph;
    }

    Edge[] getEdges() {
        return edge;
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

    class Edge implements Comparable<Edge> {
        Object source;
        Object destination;
        Integer weight;

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }

        @Override
        public String toString() {
            return String.valueOf(this.weight);
        }
    }
 }
