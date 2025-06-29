package programmers_87390;

class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int) (right - left + 1L);
        int[] answer = new int[size];
        
        for (long i=left; i <= right; i++) {
            int r = (int) (i / n);
            int c = (int) (i % n);
            int idx = (int) (i - left);
            answer[idx] = Math.max(r, c) + 1;
        }
        
        return answer;
    }
}
