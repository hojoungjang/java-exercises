package leetcode_78;

/*
 * https://leetcode.com/problems/subsets/
 */

import java.util.List;
import java.util.ArrayList;

class Solution {
    private void helper(int[] nums, int i, List<Integer> s, List<List<Integer>> totalSets) {
        if (i == nums.length) {
            return;
        }

        s.add(nums[i]);
        totalSets.add(new ArrayList<>(s));
        helper(nums, i+1, s, totalSets);
        s.remove(s.size() - 1);
        helper(nums, i+1, s, totalSets);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> totalSets = new ArrayList<>();
        totalSets.add(new ArrayList<>());
        helper(nums, 0, new ArrayList<>(), totalSets);
        return totalSets;
    }
}
