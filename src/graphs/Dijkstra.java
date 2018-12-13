package graphs;

import java.util.*;
import java.util.stream.Collectors;

// source => https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
public class Dijkstra {
    private static int V;
    private static int E;
    private static Map<Integer, String> vertexMap = new HashMap<>();

    public static void main(String[] args) {
        /* Let us create following weighted graph
                 10
            A--------B
            |      \ |
         20 |   5\   |16
            | \      |
            C--------D
                20       */

        V = 4;  // Number of vertices in graph
        E = 5;  // Number of edges in graph
        Graph graph = new Graph(V, E);

        // add edge 0-1
        graph.edge[0].source = "A";
        graph.edge[0].destination = "B";
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].source = "B";
        graph.edge[1].destination = "D";
        graph.edge[1].weight = 16;

        // add edge 0-3
        graph.edge[2].source = "C";
        graph.edge[2].destination = "D";
        graph.edge[2].weight = 20;

        // add edge 1-3
        graph.edge[3].source = "A";
        graph.edge[3].destination = "C";
        graph.edge[3].weight = 20;

        // add edge 2-3
        graph.edge[4].source = "B";
        graph.edge[4].destination = "C";
        graph.edge[4].weight = 5;

        vertexMap.put(0, "A");
        vertexMap.put(1, "B");
        vertexMap.put(2, "C");
        vertexMap.put(3, "D");

        // O(V^2)
        Map<String, Integer> distance1 = new Dijkstra().shortestPath(graph, "A");
        System.out.println(distance1);

        // O(E + V log V)
        Map<String, Integer> distance2 = new Dijkstra().shortestPathWithPriorityQueue(graph, "A");
        System.out.println(distance2);
    }

    private Map<String, Integer> shortestPath(Graph graph, String source) {
        Set<String> unvisited = new HashSet<>();
        Map<String, Integer> distance = new HashMap<>();
        Map<String, String> previous = new HashMap<>();

        for(int i = 0; i < V; i++) {
            String node = vertexMap.get(i);

            if (node.equals(source)) {
                distance.put(node, 0);
            } else {
                distance.put(node, Integer.MAX_VALUE);
            }

            unvisited.add(node);
            previous.put(node, null);
        }

        while (!unvisited.isEmpty()) {
            String current = getNodeWithLowestDistance(distance, unvisited);
            unvisited.remove(current);

            for (Graph.Edge edge : graph.edge) {
                // if source is not the current node
                if (!edge.source.equals(current))
                    continue;

                int alt = distance.get(current) + edge.weight;

                if (alt < distance.get(edge.destination.toString())) {
                    distance.put(edge.destination.toString(), alt);
                    previous.put(edge.destination.toString(), current);
                }
            }
        }

        return distance;
    }

    private String getNodeWithLowestDistance(Map<String, Integer> distance, Set<String> unvisited) {
        Map<String, Integer> sortedMap = distance.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (String key : sortedMap.keySet()) {
            if (unvisited.contains(key))
                return key;
        }

        return null;
    }

    private Map<String, Integer> shortestPathWithPriorityQueue(Graph graph, String source) {
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        Map<String, Integer> distance = new HashMap<>();
        Map<String, String> previous = new HashMap<>();

        for(int i = 0; i < V; i++) {
            String node = vertexMap.get(i);

            if (node.equals(source)) {
                distance.put(node, 0);
            } else {
                distance.put(node, Integer.MAX_VALUE);
            }

            queue.add(new Vertex(node, distance.get(node)));
            previous.put(node, null);
        }

        while (!queue.isEmpty()) {
            String current = queue.poll().label;

            for (Graph.Edge edge : graph.edge) {
                // if source is not the current node
                if (!edge.source.equals(current))
                    continue;

                int alt = distance.get(current) + edge.weight;

                if (alt < distance.get(edge.destination.toString())) {
                    distance.put(edge.destination.toString(), alt);
                    previous.put(edge.destination.toString(), current);
                }
            }
        }

        return distance;
    }

    class Vertex implements Comparable<Vertex> {
        String label;
        Integer distance;

        Vertex(String label, Integer distance) {
            this.label = label;
            this.distance = distance;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.distance, o.distance);
        }
    }
}
