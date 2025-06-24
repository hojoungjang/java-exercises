package leetcode_207;

/*
 * https://leetcode.com/problems/course-schedule/
 */

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] depCounts = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] prereq : prerequisites) {
            int parent = prereq[0];
            int child = prereq[1];
            graph.putIfAbsent(parent, new ArrayList<>());
            graph.get(parent).add(child);
            depCounts[child]++;
        }

        Queue<Integer> courses = new LinkedList<>();
        for (int id=0; id < numCourses; id++) {
            if (depCounts[id] == 0) {
                courses.add(id);
            }
        }

        while (!courses.isEmpty()) {
            int courseId = courses.poll();
            for (int childCourseId : graph.getOrDefault(courseId, new ArrayList<>())) {
                depCounts[childCourseId]--;
                if (depCounts[childCourseId] == 0) {
                    courses.add(childCourseId);
                }
            }
        }

        return Arrays.stream(depCounts).sum() == 0;
    }
}
