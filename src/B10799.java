import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        Stack<Integer> stack = new Stack<>();
        int total = 0;
        
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            
            if(c == '(') {
                stack.push(i);
            }
            else { // c == ')'
                int start = stack.pop();
                
                if(i - start == 1) {
                    // 레이저: 현재 스택에 있는 막대기 개수만큼 조각 생성
                    total += stack.size();
                }
                else {
                    // 막대기 끝: 마지막 조각 1개 추가
                    total += 1;
                }
            }
        }
        
        System.out.println(total);
    }
}