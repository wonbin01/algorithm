import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int current=n;
        ArrayList<Integer> list = new ArrayList<>();
        while(current!=1) {
            if(isPrimaryNumber(current)) { // 소수인지 확인
                list.add(current);
                break;
            }
            for(int i=2;i<=current;i++) {
                if(current%i==0) {
                    list.add(i);
                    current/=i;
                    break;
                }
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int num : list) {
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }
    static boolean isPrimaryNumber(int num) {
        int cnt=0;
        for(int i=1;i<=num/2;i++) {
            if(num%i==0) {
                cnt++;
            }
        }
        return cnt==1;
    }
}
