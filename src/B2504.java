import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<input.length();i++) {
            char c = input.charAt(i);
            int point = 0;
            char next = ' ';
            if(i+1<=input.length()) {
                next = input.charAt(i+1);
            }
            if(c=='(' || c=='[') {
                stack.push(c);
                continue;
            }
            if(!stack.isEmpty()) { // 스택이 차 있는 경우
                if(stack.peek()=='(' && c==')') {
                    stack.pop();
                    point=2;
                }
                else if(stack.peek()=='[' && c==']') {
                    stack.pop();
                    point=3;
                }
            }
            else {
                System.out.println(0);
                return;
            }
        }
    }
}
// () : 2 / [] : 3
// (x) : 2*x , [x] : 3*x , xy : x+y
// (()[[]])([]) : 28
// (3*3+2)*2+3*2 = 28
// 닫히고 열리면 더하기로 이어짐
// 닫히고 닫히면 곱하기로 이어짐

// [][]((]) -> 0