import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 표의 크기
        int m = Integer.parseInt(input[1]); // 합을 구해야하는 횟수
        int[][] map = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            input = br.readLine().split(" ");
            for(int j=1;j<=n;j++) {
                int num = Integer.parseInt(input[j-1]);
                map[i][j]=num;
            }
        }
        if(n==1) {
            System.out.println(map[1][1]);
            return;
        }
        int[][] dp = new int[n+1][n+1]; // 1,1에서 i,j까지의 합
        dp[1][0] = 0; dp[0][1] = 0; dp[0][0] = 0; 
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(i==1) {
                   dp[i][j]=dp[i][j-1]+map[i][j]; //가장 위에 있는 행인 경우
                }
                else if(j==1) {
                    dp[i][j] = dp[i-1][j] + map[i][j]; // 가장 왼쪽에 있는 열인 경우
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + map[i][j];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++) {
            input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);
            int result = dp[x2][y2]
           - dp[x1-1][y2]
           - dp[x2][y1-1]
           + dp[x1-1][y1-1];
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
