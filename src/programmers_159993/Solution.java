package programmers_159993;

import java.util.*;

class Solution {
    char START = 'S';
    char END = 'E';
    char LEVER = 'L';
    char EMPTY = 'O';
    char WALL = 'X';
    int[][] deltas = new int[][]{
        new int[]{0, -1},
        new int[]{0, 1},
        new int[]{-1, 0},
        new int[]{1, 0}
    };
    
    public int[] bfs(String[] maps, int[] pos, char target) {
        int rows = maps.length;
        int cols = maps[0].length();
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        
        queue.add(pos);
        queue.add(null);
        visited[pos[0]][pos[1]] = true;
        
        int moveCount = 0;
        
        while (!queue.isEmpty()) {
            if (queue.peek() == null) {
                queue.poll();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                moveCount++;
                continue;
            }
            
            int[] curPos = queue.poll();
            int r = curPos[0];
            int c = curPos[1];
            
            if (maps[r].charAt(c) == target) {
                return new int[]{r, c, moveCount};
            }
            
            for (int[] delta : deltas) {
                int newR = r + delta[0];
                int newC = c + delta[1];
                
                if (newR < 0 || newR >= rows || newC < 0 || newC >= cols) {
                    continue;
                }
                
                if (visited[newR][newC] || maps[newR].charAt(newC) == WALL) {
                    continue;
                }
                
                visited[newR][newC] = true;
                queue.add(new int[]{newR, newC});
            }
        }
        return null;
    }
    
    public int solution(String[] maps) {
        int rows = maps.length;
        int cols = maps[0].length();
        
        // find start
        int[] startPos = new int[2];
        
        for (int r=0; r < rows; r++) {
            for (int c=0; c < cols; c++) {
                if (maps[r].charAt(c) == START) {
                    startPos[0] = r;
                    startPos[1] = c;
                    break;
                }
            }
        }
        
        int[] leverBfs = bfs(maps, startPos, LEVER);
        if (leverBfs == null) {
            return -1;
        }
        int[] endBfs = bfs(maps, new int[]{leverBfs[0], leverBfs[1]}, END);
        if (endBfs == null) {
            return -1;
        }
        return leverBfs[2] + endBfs[2];
    }
}
