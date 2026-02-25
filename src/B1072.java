import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long total = Long.parseLong(input[0]); // 전체 게임횟수
        long winNumber = Long.parseLong(input[1]); // 이긴 횟수
        long possibility = (int)((double)winNumber / total * 100);
        if(possibility>=99) { // 확률이 절대 변하지 않음
            System.out.println(-1);
            return;
        }
        long left=1;
        long right = 1000000000;
        long mid = -1;
        long answer=0;
        while(left <= right) {
            mid = (left+right)/2;
            long current = ((winNumber+mid)*100) / (total+mid);
            if(current>possibility) {
                answer = mid;
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        System.out.println(answer);
    }
}
