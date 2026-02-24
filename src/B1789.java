import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long target = Long.parseLong(br.readLine());
        long current=0;
        int cnt=0;
        for(long i = 1; ; i++) {
            if(current + i > target) break;
            current += i;
            cnt++;
        }
        System.out.println(cnt);
    }
}
