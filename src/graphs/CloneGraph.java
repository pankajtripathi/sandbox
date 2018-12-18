package graphs;

import java.util.*;

/* Consider a vertex type for a directed graph in which there are two fields: an integer label and  a list of
   references to other neighbors. Design an algorithm that takes a reference to a vertex u and creates a copy of the
   graph on the neighbors reachable from u. Return a copy of u
*/
public class CloneGraph {
    static class GraphVertex {
        int label;
        List<GraphVertex> neighbors;

        GraphVertex(int label) {
            this.label = label;
            neighbors = new ArrayList<>();
        }
    }

    public GraphVertex cloneGraph(GraphVertex node) {
        if (node == null) return null;

        Map<GraphVertex, GraphVertex> vertexMap = new HashMap<>();
        Queue<GraphVertex> queue = new ArrayDeque<>();

        GraphVertex head = new GraphVertex(node.label);
        vertexMap.put(node, head);
        queue.add(node);

        while (!queue.isEmpty()) {
            GraphVertex current = queue.poll();

            for (GraphVertex neighbor : current.neighbors) {
                // copy vertex neighbor
                if (!vertexMap.containsKey(neighbor)) {
                    GraphVertex copy = new GraphVertex(neighbor.label);
                    vertexMap.put(neighbor, copy);
                    queue.add(neighbor);
                    vertexMap.get(current).neighbors.add(copy);
                }

                // copy edge
                vertexMap.get(current).neighbors.add(vertexMap.get(neighbor));
            }
        }

        return head;
    }

    public static void main(String[] args) {
        GraphVertex zero = new GraphVertex(0);
        zero.neighbors.add(new GraphVertex(1));
        zero.neighbors.add(new GraphVertex(2));

        GraphVertex two = new GraphVertex(2);
        two.neighbors.add(new GraphVertex(0));
        two.neighbors.add(new GraphVertex(3));

        GraphVertex returnedVertex = new CloneGraph().cloneGraph(zero);
        for (GraphVertex v : returnedVertex.neighbors) {
            System.out.println(v.label);
        }
    }
}
