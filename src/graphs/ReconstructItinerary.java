package graphs;

import java.util.*;

/*
*
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct
the itinerary in order. All of the tickets belong to a man who departs from JFK.
Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when
read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].

All airports are represented by three capital letters (IATA code).

You may assume all tickets form at least one valid itinerary.

Example 1:
Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]

Example 2:
Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]

Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.
* */
public class ReconstructItinerary {
    public static void main(String[] args) {
        String[][] tickets = {
                {"MUC", "LHR"},
                {"JFK", "MUC"},
                {"SFO", "SJC"},
                {"LHR", "SFO"}
        };
        System.out.println(new ReconstructItinerary().findItinerary(tickets));
    }

    // Problem is similar to Topological Sorting. Use heap to maintain lexical ordering
    private List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        if (tickets == null || tickets.length == 0) return result;

        for (String[] ticket : tickets) {
            if (map.containsKey(ticket[0])) {
                map.get(ticket[0]).add(ticket[1]);
            } else {
                PriorityQueue<String> q = new PriorityQueue<>();
                q.add(ticket[1]);
                map.put(ticket[0], q);
            }
        }

        Stack<String> stack = new Stack<>();
        // Itinerary must begin with JFK
        dfs("JFK", map, stack);

        while (!stack.empty()) {
            result.add(stack.pop());
        }
        return result;
    }

    private void dfs(String source, Map<String, PriorityQueue<String>> map, Stack<String> stack) {
        PriorityQueue<String> queue = map.get(source);

        while (queue != null && !queue.isEmpty()) {
            dfs(queue.poll(), map, stack);
        }

        // Once done with all neighbors add source to stack
        // to avoid using stack just use addFirst method of list and add to result list
        stack.push(source);
    }
}
