package boj_10815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Integer.parseInt(br.readLine());
        int[] targets = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] ans = solution(nums, targets);
        StringBuilder sb = new StringBuilder();
        for (int val : ans) {
            sb.append(String.valueOf(val));
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }

    private static int[] solution(int[] nums, int[] targets) {
        int[] ans = new int[targets.length];
        Arrays.sort(nums);
        for (int i=0; i < targets.length; i++) {
            int idx = Arrays.binarySearch(nums, targets[i]);
            ans[i] = idx >= 0 ? 1 : 0;
        }
        return ans;
    }
}
