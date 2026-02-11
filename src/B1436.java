import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int series = Integer.parseInt(br.readLine()); // N번째 작은 수
        long start = 666;
        int cnt=0;
        while(true) {
            String nums = start+"";
            if(nums.contains("666")) {
                cnt++;
            }
            if(cnt==series) {
                break;
            }
            start++;
        }
        System.out.println(start);
    }
}