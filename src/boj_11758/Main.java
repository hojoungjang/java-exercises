package boj_11758;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static int solution(int[][] points) {
        double epsilon = 0.00001;

        int dx = points[1][0] - points[0][0];
        int dy = points[1][1] - points[0][1];

        if (dx == 0) {
            if (points[2][0] == points[1][0])
                return 0;
            if (dy > 0)
                return points[2][0] > 0 ? -1 : 1;
            else
                return points[2][0] > 0 ? 1 : -1;
        }
        
        double slope = (double) dy / dx;
        double constant = points[0][1] - slope * points[0][0];
        double lineY = slope * points[2][0] + constant;

        if (Math.abs(lineY - points[2][1]) < epsilon) {
            return 0;
        } else if (lineY < points[2][1]) {
            return dx < 0 ? -1 : 1;
        } else {
            return dx < 0 ? 1: -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] points = new int[3][2];
        for (int i=0; i < 3; i++) {
            int[] point = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            points[i] = point;
        }
        System.out.println(solution(points));        
    }
}
