package leetcode_17;

/*
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    private Map<Character, String[]> numMap = new HashMap<>() {{
        put('2', new String[]{"a", "b", "c"});
        put('3', new String[]{"d", "e", "f"});
        put('4', new String[]{"g", "h", "i"});
        put('5', new String[]{"j", "k", "l"});
        put('6', new String[]{"m", "n", "o"});
        put('7', new String[]{"p", "q", "r", "s"});
        put('8', new String[]{"t", "u", "v"});
        put('9', new String[]{"w", "x", "y", "z"});
    }};

    public List<String> letterCombinations(String digits) {
        List<String> letterCombs = new ArrayList<>();
        List<String> letters = new ArrayList<>();

        dfs(0, digits, letterCombs, letters);
        return letterCombs;
    }

    private void dfs(int idx, String digits, List<String> letterCombs, List<String> letters) {
        if (idx >= digits.length()) {
            if (letters.size() > 0)
                letterCombs.add(String.join("", letters));
            return;
        }

        for (String letter : numMap.get(digits.charAt(idx))) {
            letters.add(letter);
            dfs(idx + 1, digits, letterCombs, letters);
            letters.remove(letters.size()-1);
        }
    }
}