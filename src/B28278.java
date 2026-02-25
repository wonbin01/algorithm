import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class B28278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while(n>0) {
            n--;
            String[] input = br.readLine().split(" ");
            int cmd = Integer.parseInt(input[0]);
            if(cmd==1) {
                int item = Integer.parseInt(input[1]);
                deque.addFirst(item);
            }
            else if(cmd == 2) {
                if(deque.size()!=0) {
                    sb.append(deque.getFirst()).append("\n");
                    deque.removeFirst();
                }
                else {
                    sb.append(-1).append("\n");
                }
            }
            else if(cmd == 3) {
                sb.append(deque.size()).append("\n");
            }
            else if(cmd==4) {
                if(deque.size()==0) {
                    sb.append(1).append("\n");
                }
                else {
                    sb.append(0).append("\n");
                }
            }
            else {
                if(!deque.isEmpty()) {
                    sb.append(deque.getFirst()).append("\n");
                }
                else {
                    sb.append(-1).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
