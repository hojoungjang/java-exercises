package programmers_120866;

class Solution {
    private static final int BOMB = 1;
    
    public int solution(int[][] board) {
        int answer = 0;
        int[][] deltas = {
            {-1,0}, {1,0}, {0,-1}, 
            {0,1}, {-1,1}, {-1,-1}, 
            {1,-1}, {1,1}
        };
        int rows = board.length;
        int cols = board[0].length;
        
        for (int r=0; r < rows; r++) {
            for (int c=0; c < cols; c++) {
                if (board[r][c] == BOMB)
                    continue;
                
                boolean safe = true;
                for (int[] delta: deltas) {
                    int newR = r + delta[0];
                    int newC = c + delta[1];
                    
                    if (newR < 0 || newR >= rows || newC < 0 || newC >= cols)
                        continue;
                    
                    if (board[newR][newC] == BOMB) {
                        safe = false;
                        break;
                    }
                }
                
                if (safe)
                    answer++;
            }
        }
        return answer;
    }
}
