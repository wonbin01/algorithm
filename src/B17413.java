import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class B17413 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int length = input.length();
        for(int i=0;i<length;i++) {
            char c = input.charAt(i);
            if(c=='<') {
                sb.append(reverseString(stack));
                stack.clear();
                queue.add(c);
                continue;
            }
            if(c=='>') {
                queue.add(c);
                sb.append(makeString(queue));
                queue.clear();
                continue;
            }
            if(!queue.isEmpty()) {
                queue.add(c);
                continue;
            }
            if(c==' ') {
                sb.append(reverseString(stack)).append(" ");
                stack.clear();
                continue;
            }
            stack.add(c);
        }
        sb.append(reverseString(stack));
        System.out.println(sb.toString());
    }
    static String makeString(Queue<Character> queue) {
        StringBuilder sb = new StringBuilder();
        for(char c : queue) {
            sb.append(c);
        }
        return sb.toString();
    }
    static String reverseString(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}