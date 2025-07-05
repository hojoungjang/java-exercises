package programmers_389478;

import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        List<int[]> boxes = new ArrayList<>();
        boolean rev = false;
        int r = 0;
        int c = 0;
        
        while (boxes.size() * w < n) {
            int row = boxes.size();
            int[] boxRow = new int[w];
            for (int i=1; i <= w; i++) {
                int boxId = row * w + i;
                
                if (boxId > n) {
                    break;
                }
                
                if (boxId == num) {
                    r = boxes.size();
                    c = rev ? w - i : i - 1;
                }
                
                if (rev) {
                    boxRow[w-i] = boxId;    
                } else {
                    boxRow[i-1] = boxId;
                }
            }
            boxes.add(boxRow);
            rev = rev ? false : true;
        }
        
        int count = 0;
        while (r < boxes.size()) {
            if (boxes.get(r)[c] == 0) {
                break;
            }
            count++;
            r++;
        }

        return count;
    }
}
