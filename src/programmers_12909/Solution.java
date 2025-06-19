package programmers_12909;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
 */

import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == ')') {
                if (stack.empty()) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push('(');
            }
        }
        return stack.empty();
    }
}
