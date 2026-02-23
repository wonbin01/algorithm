import java.io.*;

public class B1010 {

    static int[][] dp = new int[31][31];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        // 조합 미리 계산
        for(int i = 0; i <= 30; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
            for(int j = 1; j < i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        while(t-- > 0) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            sb.append(dp[m][n]).append("\n");
        }

        System.out.println(sb);
    }
}
