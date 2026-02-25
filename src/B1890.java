import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        long[][] dp = new long[n][n]; // i,j에 도달할 수 있는 경우의 수
        for(int i=0;i<n;i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0;j<n;j++) {
                map[i][j] = Integer.parseInt(input[j]);
                dp[i][j]=0;
            }
        }
        dp[0][0]=1;
       for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(dp[i][j] == 0) continue;  // 도달 못한 곳은 스킵
                if(i == n-1 && j == n-1) continue;  // 도착점은 스킵
                int jump = map[i][j];
                if(j + jump < n) {
                    dp[i][j + jump] += dp[i][j];
                }
                if(i + jump < n) {
                    dp[i + jump][j] += dp[i][j];
                }
            }
        }
       System.out.println(dp[n-1][n-1]);
    }
}
