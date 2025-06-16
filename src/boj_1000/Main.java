package boj_1000;

// import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
// import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // Scanner sc = new Scanner(System.in);
        // String[] nums = sc.nextLine().split(" ");
        // System.out.println(Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]));
        // sc.close();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nums = br.readLine().split(" ");
        bw.write(String.valueOf(Integer.parseInt(nums[0]) + Integer.parseInt(nums[1])));
        bw.newLine();
        br.close();
        bw.close();
    }
}
