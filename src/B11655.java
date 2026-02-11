import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11655 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        for(String s : input) {
            ROT13(s);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
    static void ROT13(String s) {
        int length = s.length();
        for(int i=0;i<length;i++) {
            char c = s.charAt(i);
            if(c>='a' && c<='z') {
                int index = c-'a';
                index = (index+13) % 26;
                sb.append((char)('a'+index));
            }
            else if(c>='A' && c<='Z') {
                int index = c-'A';
                index = (index+13)%26;
                sb.append((char)('A'+index));
            }
            else {
                sb.append(s.charAt(i));
            }
        }
    }
}
// abcdefghijklmnopqrstuvwxyz