package graphs;

import java.util.*;

/* Consider a vertex type for a directed graph in which there are two fields: an integer label and  a list of
   references to other vertices. Design an algorithm that takes a reference to a vertex u and creates a copy of the
   graph on the vertices reachable from u. Return a copy of u
*/
public class CloneGraph {
    static class GraphVertex {
        int label;
        List<GraphVertex> vertices;

        GraphVertex(int label) {
            this.label = label;
            vertices = new ArrayList<>();
        }
    }

    public GraphVertex cloneGraph(GraphVertex u) {
        if (u == null) return null;

        Map<GraphVertex, GraphVertex> vertexMap = new HashMap<>();
        Queue<GraphVertex> queue = new ArrayDeque<>();

        vertexMap.put(u, new GraphVertex(u.label));
        queue.add(u);

        while (!queue.isEmpty()) {
            GraphVertex g = queue.poll();

            for (GraphVertex e : g.vertices) {
                // copy vertex e
                if (!vertexMap.containsKey(e)) {
                    vertexMap.put(e, new GraphVertex(e.label));
                    queue.add(e);
                }

                // copy edge
                vertexMap.get(g).vertices.add(vertexMap.get(e));
            }
        }

        return vertexMap.get(u);
    }

    public static void main(String[] args) {
        GraphVertex zero = new GraphVertex(0);
        zero.vertices.add(new GraphVertex(1));
        zero.vertices.add(new GraphVertex(2));

        GraphVertex two = new GraphVertex(2);
        two.vertices.add(new GraphVertex(0));
        two.vertices.add(new GraphVertex(3));

        GraphVertex returnedVertex = new CloneGraph().cloneGraph(zero);
        for (GraphVertex v : returnedVertex.vertices) {
            System.out.println(v.label);
        }
    }
}
