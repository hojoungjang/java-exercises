package leetcode_1;

/*
 * https://leetcode.com/problems/two-sum/
 */

import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i=0; i < nums.length; i++) {
            int pairNum = target - nums[i];
            if (seen.containsKey(pairNum)) {
                return new int[]{i, seen.get(pairNum)};
            }
            seen.put(nums[i], i);
        }
        return new int[]{};
    }
}
