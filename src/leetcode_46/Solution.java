package leetcode_46;

/*
 * https://leetcode.com/problems/permutations/
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Solution {
    List<List<Integer>> total = new ArrayList<>();
    Set<Integer> used = new HashSet<>();

    public void permuteHelper(List<Integer> p, int[] nums) {
        if (p.size() == nums.length) {
            total.add(new ArrayList<>(p));
            return;
        }

        for (int i=0; i < nums.length; i++) {
            if (used.contains(i)) {
                continue;
            }
            used.add(i);
            p.add(nums[i]);
            permuteHelper(p, nums);
            used.remove(i);
            p.remove(p.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        permuteHelper(new ArrayList<>(), nums);
        return total;
    }
}
