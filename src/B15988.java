import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] dp = new long[1000001];  // int가 아니라 long 사용
        final long MOD = 1000000009;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i <= 1000000; i++) {
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % MOD;
        }
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}