package leetcode_216;

/*
 * https://leetcode.com/problems/combination-sum-iii
 */

import java.util.List;
import java.util.ArrayList;

class Solution {
    
    private List<List<Integer>> results = new ArrayList<>();
    
    private void helper(int num, List<Integer> c, int sum, int k, int n) {
        if (c.size() == k) {
            if (sum == n) {
                results.add(new ArrayList<>(c)); 
            }
            return;
        }

        if (num > 9) {
            return;
        }

        c.add(num);
        helper(num + 1, c, sum + num, k, n);
        c.remove(c.size()-1);
        helper(num + 1, c, sum, k, n);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(1, new ArrayList<>(), 0, k, n);
        return results;
    }
}
