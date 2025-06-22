package leetcode_973;

import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                double dist1 = Math.sqrt((p1[0] * p1[0]) + (p1[1] * p1[1]));
                double dist2 = Math.sqrt((p2[0] * p2[0]) + (p2[1] * p2[1]));
                if (dist1 < dist2) {
                    return -1;
                } else if (dist1 == dist2) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        for (int[] point : points) {
            pq.add(point);
        }

        int[][] closests = new int[k][];
        for (int i=0; i < k; i++) {
            closests[i] = pq.poll();
        }
        return closests;
    }
}
