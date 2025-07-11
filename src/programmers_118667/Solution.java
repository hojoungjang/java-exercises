package programmers_118667;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/118667
 */

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int[] totalQueue = new int[queue1.length * 2];
        long sum1 = 0;
        long sum2 = 0;
        
        for (int i=0; i < queue1.length; i++) {
            totalQueue[i] = queue1[i];
            sum1 += queue1[i];
        }
        for (int i=queue1.length; i < queue1.length*2; i++) {
            totalQueue[i] = queue2[i - queue1.length];
            sum2 += queue2[i - queue1.length];
        }
        
        int start = 0;
        int end = queue1.length;
        int count = 0;
        
        while (start <= end) {
            if (sum1 == sum2) {
                return count;
            } else if (sum1 < sum2 && end < totalQueue.length) {
                sum1 += totalQueue[end];
                sum2 -= totalQueue[end];
                end++;
            } else if (sum1 > sum2) {
                sum1 -= totalQueue[start];
                sum2 += totalQueue[start];
                start++;
            } else {
                break;
            }
            count++;
        }
        return -1;
    }
}
