package graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// Problem is similar to Making Wired Connections problem from EPI.
public class Bipartite {
    static class GraphVertex {
        int label = -1;
        List<GraphVertex> vertices = new ArrayList<>();

        GraphVertex(int label) {
            this.label = label;
            vertices = new ArrayList<>();
        }
    }

    public boolean canBePlacedInTwoGroups(List<GraphVertex> G) {
        for (GraphVertex v : G) {
            if (v.label == -1 && !isBipartite(v))
                return false;
        }
        return true;
    }

    private boolean isBipartite(GraphVertex v) {
        Queue<GraphVertex> queue = new ArrayDeque<>();
        v.label = 0;
        queue.add(v);

        while (!queue.isEmpty()) {
            for (GraphVertex e : queue.peek().vertices) {
                // if not visited set it to parent's label + 1 and add to queue.
                if (e.label == -1) {
                    e.label = queue.peek().label + 1;
                    queue.add(e);
                } else if (e.label == queue.peek().label) {
                    return false;
                }
            }
        }

        queue.remove();
        return true;
    }

    // Demo graph to check if graph is Bipartite or not.
    public static void main(String[] args) {
        GraphVertex zero = new GraphVertex(0);
        zero.vertices.add(new GraphVertex(1));
        zero.vertices.add(new GraphVertex(3));

        GraphVertex one = new GraphVertex(1);
        one.vertices.add(new GraphVertex(0));
        one.vertices.add(new GraphVertex(2));

        GraphVertex two = new GraphVertex(2);
        two.vertices.add(new GraphVertex(0));
        two.vertices.add(new GraphVertex(3));

        GraphVertex third = new GraphVertex(3);
        third.vertices.add(new GraphVertex(2));
        third.vertices.add(new GraphVertex(0));

        List<GraphVertex> vertices = new ArrayList<>();
        vertices.add(zero);
        vertices.add(one);
        vertices.add(two);
        vertices.add(third);

        System.out.println(new Bipartite().canBePlacedInTwoGroups(vertices));
    }
}
