import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        for(int i=0;i<n;i++) {
            str[i] = br.readLine();
        }
        Arrays.sort(str,(a,b) -> {
            if(a.length()==b.length()) {
                return a.compareTo(b);
            }
            return Integer.compare(a.length(),b.length());
        });
        StringBuilder sb = new StringBuilder();
        sb.append(str[0]).append("\n");
        for(int i=1;i<str.length;i++) {
            if(str[i].equals(str[i-1])) {
                continue;
            }
            sb.append(str[i]).append("\n");
        }
        System.out.println(sb);
    }
}
