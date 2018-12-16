package graphs;

import java.util.*;

/*
*
 There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should
take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all
courses, return an empty array.

Example 1:

Input: 2, [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
             course 0. So the correct course order is [0,1] .
*
* */
class CourseSchedule {
    int index;
    int[] res;

    private int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];

        // set index and construct res array
        index = numCourses - 1;
        res = new int[numCourses];
        if (prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++) {
                res[i] = i;
            }
        }

        // construct graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pre : prerequisites) {
            if (graph.containsKey(pre[1])) {
                graph.get(pre[1]).add(pre[0]);
            } else {
                List<Integer> il = new ArrayList<>();
                il.add(pre[0]);
                graph.put(pre[1], il);
            }
        }

        // if checking for cycle is the only thing needed
        boolean hasCycle = false;
        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (isCyclic(i, graph, visited)) {
                hasCycle = true;
                return new int[0];
            }
        }

        return res;
    }


    private boolean isCyclic(Integer node, Map<Integer, List<Integer>> graph, int[] visited) {
        if (visited[node] == -1) return true;
        if (visited[node] == 1) return false;

        visited[node] = -1;
        if (graph.containsKey(node)) {
            for (Object child : graph.get(node)) {
                if (isCyclic((Integer) child, graph, visited))
                    return true;
            }
        }

        res[index--] = node;
        visited[node] = 1;
        return false;
    }


    public static void main(String[] args) {
        int[][] prerequisites = {
                {1,0},
                {2,0},
                {3,1},
                {3,2}
        };

        int[] res = new CourseSchedule().findOrder(4, prerequisites);
        System.out.println(Arrays.toString(res));
    }
}
