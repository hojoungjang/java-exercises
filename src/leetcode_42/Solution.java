package leetcode_42;

/*
 * https://leetcode.com/problems/trapping-rain-water/
 */

import java.util.Stack;

class Solution {
    
    class Bar {
        int height;
        int index;

        public Bar(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }

    public int trap(int[] height) {
        Stack<Bar> stack = new Stack<>();
        int water = 0;

        for (int i=0; i < height.length; i++) {
            Bar bar = new Bar(height[i], i);
            int maxSeenHeight = 0;
            while (!stack.empty() && stack.peek().height <= height[i]) {
                Bar poppedBar = stack.pop();
                water += (i - poppedBar.index - 1) * Math.max(poppedBar.height - maxSeenHeight, 0);
                maxSeenHeight = Math.max(maxSeenHeight, poppedBar.height);
            }
            if (!stack.empty()) {
                water += (i - stack.peek().index - 1) * Math.max(height[i] - maxSeenHeight, 0);
            }
            stack.push(bar);
        }
        return water;
    }
}
