import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
        while(t>0) {
            t--;
            int n = Integer.parseInt(br.readLine()); // 동전의 가지 수 -> 1~20
            ArrayList<Integer> coins = new ArrayList<>();
            String[] input = br.readLine().split(" "); // 동전의 각 금액
            for(int i=0;i<n;i++) {
                coins.add(Integer.parseInt(input[i]));
            }
            int target = Integer.parseInt(br.readLine()); // 만들어야 할 금액
            int[] dp = new int[target+1]; // 각 금액을 만들 수 있는 경우의 수 저장
            dp[0]= 1;
            for(int coin : coins) {
                for(int i=coin;i<=target;i++) {
                    dp[i]+=dp[i-coin];
                }
            }
            System.out.println(dp[target]);
        }
    }
}
