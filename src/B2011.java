import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String crypString = br.readLine();
        int length = crypString.length();
        if(crypString.charAt(0) == '0') {
            System.out.println(0);
            return;
        }
        int[] dp = new int[length + 1];
        final int MOD = 1000000;
        dp[0] = 1; // 빈 문자열
        dp[1] = 1; // 첫 번째 문자
        for(int i = 2; i <= length; i++) {
            // 한 자리로 해석 (현재 문자)
            int oneDigit = crypString.charAt(i - 1) - '0';
            if(oneDigit >= 1 && oneDigit <= 9) {
                dp[i] = (dp[i] + dp[i - 1]) % MOD;
            }
            // 두 자리로 해석 (이전 문자 + 현재 문자)
            int twoDigits = (crypString.charAt(i - 2) - '0') * 10 
                          + (crypString.charAt(i - 1) - '0');
            if(twoDigits >= 10 && twoDigits <= 26) {
                dp[i] = (dp[i] + dp[i - 2]) % MOD;
            }
        }
        
        System.out.println(dp[length]);
    }
}