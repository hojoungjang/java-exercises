package leetcode_39;

/*
 * https://leetcode.com/problems/combination-sum/
 */

import java.util.List;
import java.util.ArrayList;

class Solution {
    private List<List<Integer>> total = new ArrayList<>();

    private void combine(int[] candidates, int i, List<Integer> c, int target) {
        int sum = c.stream().mapToInt(Integer::intValue).sum();
        
        if (sum > target) {
            return;
        }

        if (sum == target) {
            total.add(new ArrayList<>(c));
            return;
        }

        for (int idx=i; idx < candidates.length; idx++) {
            c.add(candidates[idx]);
            combine(candidates, idx, c, target);
            c.remove(c.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combine(candidates, 0, new ArrayList<>(), target);
        return total;
    }
}
