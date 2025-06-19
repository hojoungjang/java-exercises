package programmers_42586;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 */

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int depDay = 0;
        int count = 0;
        
        List<Integer> depDays = new ArrayList<>();
        
        for (int i=0; i < speeds.length; i++) {
            int daysReq = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            if (daysReq > depDay) {
                depDay = daysReq;
                if (count > 0) {
                    depDays.add(count);
                }
                count = 1;
            } else {
                count++;
            }
        }
        
        depDays.add(count);
        return depDays.stream().mapToInt(val -> val.intValue()).toArray();
    }
}
