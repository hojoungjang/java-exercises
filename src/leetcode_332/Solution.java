package leetcode_332;

/*
 * https://leetcode.com/problems/reconstruct-itinerary/
 */

import java.util.*;

class Solution {
    private void travel(
        String airport, 
        Map<String, List<String>> graph, 
        List<String> itinerary
    ) {
        List<String> tickets = graph.getOrDefault(airport, new ArrayList<>());
        while (!tickets.isEmpty()) {
            travel(tickets.removeLast(), graph, itinerary);
        }
        itinerary.add(airport);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> itinerary = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            String dep = ticket.get(0);
            String dest = ticket.get(1);
            graph.putIfAbsent(dep, new ArrayList<>());
            graph.get(dep).add(dest);
        }

        for (String key : graph.keySet()) {
            Collections.sort(graph.get(key), Collections.reverseOrder());
        }

        travel("JFK", graph, itinerary);
        return itinerary.reversed();
    }
}
