import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        int result = arr[0];
        dp[0] = arr[0];
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}