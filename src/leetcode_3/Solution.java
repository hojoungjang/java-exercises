package leetcode_3;

/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

import java.util.Map;
import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int start = 0;
        int maxLength = 0;
        for (int end=0; end < s.length(); end++) {
            while (!window.isEmpty() && window.containsKey(s.charAt(end))) {
                window.remove(s.charAt(start));
                start++;
            }
            window.put(s.charAt(end), 1);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
