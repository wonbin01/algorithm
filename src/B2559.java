import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class B2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 전체 날짜의 수
        int k = Integer.parseInt(input[1]); // 연속적인 날짜의 수
        int maxValue=Integer.MIN_VALUE;
        int[] arr = new int[n];
        input = br.readLine().split(" ");
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        int current=0;
        
        for(int i=0;i<n;i++) {
            deque.addLast(arr[i]);
            current += arr[i];
            if(deque.size() > k) {
                current -= deque.removeFirst();
            }
            if(deque.size() == k) {
                maxValue = Math.max(maxValue, current);
            }
        }

        System.out.println(maxValue);
    }
}
