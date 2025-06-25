package leetcode_743;

import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new ArrayList<>());
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }
        
        int[] dists = new int[n + 1];
        for (int i=1; i <= n; i++) {
            dists[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] item1, int[] item2) {
                return item1[1] - item2[1];
            }
        });

        pq.add(new int[]{k, 0});
        dists[k] = 0;

        while (!pq.isEmpty()) {
            int[] closest = pq.poll();
            int node = closest[0];
            int dist = closest[1];

            if (dist > dists[node])
                continue;
            
            for (int[] next : graph.getOrDefault(node, new ArrayList<>())) {
                int nextNode = next[0];
                int nextDist = next[1] + dist;

                if (nextDist >= dists[nextNode]) {
                    continue;
                }

                dists[nextNode] = nextDist;
                pq.add(new int[]{nextNode, nextDist});
            }
        }

        int maxDist = 0;
        for (int dist : dists) {
            if (dist == Integer.MAX_VALUE) {
                return -1;
            }
            maxDist = Math.max(maxDist, dist);
        }
        return maxDist;
    }
}
