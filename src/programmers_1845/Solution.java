package programmers_1845;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 */

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> types = new HashSet<>();
        for (int num: nums) {
            types.add(num);
        }
        return Math.min(types.size(), nums.length / 2);
    }
}
