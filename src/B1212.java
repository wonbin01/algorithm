import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1212 {
    static String[] table = {"000", "001", "010", "011", "100", "101", "110", "111"};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        if(input.equals("0")) {
            System.out.println("0");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        
        // 첫 번째 자리
        int first = input.charAt(0) - '0';
        sb.append(Integer.toBinaryString(first));
        
        // 나머지 자리
        for(int i = 1; i < input.length(); i++) {
            int num = input.charAt(i) - '0';
            sb.append(table[num]);
        }
        
        System.out.println(sb.toString());
    }
}