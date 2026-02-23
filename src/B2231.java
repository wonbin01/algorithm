import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int minValue=Integer.MAX_VALUE;
        for(int i=n-1;i>0;i--) {
            int current=i;
            int total=current;
            while(true) {
                int remain = current%10;
                total+=remain;
                current/=10;
                if(current==0) break;
            }
            if(total==n) {
                minValue = Math.min(minValue,i);
            }
        }
        if(minValue==Integer.MAX_VALUE) {
            System.out.println(0);
            return;
        }
        System.out.println(minValue);
    }
}
