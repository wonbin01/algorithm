import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
        while (t>0) {
            t--;
            int n = Integer.parseInt(br.readLine());
            int[][] stickerMap = new int[2][n];
            for(int i=0;i<2;i++) {
                String[] input = br.readLine().split(" ");
                for(int j=0;j<n;j++) {
                   stickerMap[i][j] = Integer.parseInt(input[j]); 
                }
            }
            int[][] dp = new int[n][3]; // 0은 1행, 1은 2행, 2는 아무것도 선택 x
            dp[0][0] = stickerMap[0][0];
            dp[0][1] = stickerMap[1][0];
            dp[0][2] = 0;
            for(int i=1;i<n;i++) {
                dp[i][0] = Math.max(dp[i-1][1],dp[i-1][2]) + stickerMap[0][i];
                dp[i][1] = Math.max(dp[i-1][0],dp[i-1][2]) + stickerMap[1][i];
                dp[i][2] = findMax(dp[i-1][0], dp[i-1][1], dp[i-1][2]);
            }
            int max = findMax(dp[n-1][0], dp[n-1][1], dp[n-1][2]);
            System.out.println(max);
        }
    }
    static int findMax(int a, int b, int c) {
    return Math.max(a, Math.max(b, c));
}
}
