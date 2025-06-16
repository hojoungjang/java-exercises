package boj_2163;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static int solution(int n, int m) {
        return n * m - 1;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        System.out.println(solution(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1])));
    }
}
