import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B16953 {
    static int minValue = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int num = Integer.parseInt(input[0]);
        int target = Integer.parseInt(input[1]);
        calculateResult(target, num, 1);
        System.out.println(minValue);
    }
    static void calculateResult(int current, int target, int cnt) {
        while(current>target) {
            if(current%2==0) {
                current/=2;
                cnt++;
            }
            else if(current%10 == 1) {
                current-=1;
                current/=10;
                cnt++;
            }
            else break;
        }
        if(current==target) {
            minValue = Math.min(minValue,cnt);
        }
        else {
            minValue = -1;
        }
    }
}
// 2를 곱하기
// 가장 오른쪽에 1 붙이기
// 2 → 4 → 8 → 81 → 162