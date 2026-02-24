import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class B14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 문자열의 개수
        int m = Integer.parseInt(input[1]); // 입력의 개수
        Set<String> set = new HashSet<>();
        int cnt=0;
        for(int i=0;i<n;i++) {
            String in = br.readLine();
            set.add(in);
        }
        for(int i=0;i<m;i++) {
            String in = br.readLine();
            if(set.contains(in)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
