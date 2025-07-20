package boj_2108;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {
    
    private static long getMode(int[] nums) {
        int prevNum = nums[0] - 1;
        int cnt = 0;
        int maxCnt = 0;
        List<Long> cands = new ArrayList<>();

        for (int num : nums) {
            if (num != prevNum) {
                if (cnt > maxCnt) {
                    cands = new ArrayList<>();
                    cands.add((long) prevNum);
                    maxCnt = cnt;
                } else if (cnt == maxCnt) {
                    cands.add((long) prevNum);
                }
                cnt = 1;
                prevNum = num;
            } else {
                cnt++;
            }
        }

        if (cnt > maxCnt) {
            cands = new ArrayList<>();
            cands.add((long) prevNum);
            maxCnt = cnt;
        } else if (cnt == maxCnt) {
            cands.add((long) prevNum);
        }

        return cands.size() > 1 ? cands.get(1) : cands.get(0);
    }

    private static long[] solution(int[] nums) {
        Arrays.sort(nums);

        // average
        long avg = Math.round((double) Arrays.stream(nums).mapToLong(i -> i).sum() / nums.length);

        // median
        long median = (long) nums[nums.length / 2];
        
        // mode
        long mode = getMode(nums);
        
        // range
        long range = (long) nums[nums.length-1] - nums[0];

        return new long[]{avg, median, mode, range};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        for (int i=0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        long[] stats = solution(nums);
        for (long stat : stats) {
            System.out.println(stat);
        }
    }
}
