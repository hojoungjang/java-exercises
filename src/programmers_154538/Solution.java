package programmers_154538;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(y);
        queue.add(null);
        
        Set<Integer> visited = new HashSet<>();
        visited.add(y);
        
        int level = 0;
        
        while (!queue.isEmpty()) {
            if (queue.peek() == null) {
                queue.poll();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                level++;
                continue;
            }
            
            int num = queue.poll();
            
            if (num == x) {
                return level;
            } 
            
            if (num - n >= x && !visited.contains(num - n)) {
                visited.add(num - n);
                queue.add(num - n);
            }
            if ((num%2 == 0) && (num/2 >= x) && !visited.contains(num/2)) {
                visited.add(num / 2);
                queue.add(num / 2);
            }
            if ((num%3 == 0) && (num/3 >= x) && !visited.contains(num/3)) {
                visited.add(num / 3);
                queue.add(num / 3);
            }
        }
        
        return -1;
    }
}
