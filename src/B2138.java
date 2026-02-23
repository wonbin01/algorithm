import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2138 {
    static int[] beginning;
    static int[] target;
    static int cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        beginning = new int[n];
        target = new int[n];
        String input = br.readLine(); // 현재 상태
        for(int i=0;i<n;i++) {
            beginning[i] = input.charAt(i)-'0';
        }
        input = br.readLine(); // 목표 상태
        for(int i=0;i<n;i++) {
            target[i] = input.charAt(i)-'0';
        }
        int result1 = simulate(false,n);
        int result2 = simulate(true, n);
        int answer = Math.min(result1,result2);
        if(answer == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }

    static boolean isSame(int[] arr, int n) {
        for(int i=0;i<n;i++) {
            if(arr[i] != target[i]) {
                return false;
            }
        }
        return true;
    }

    static int simulate(boolean firstPress,int n) {
        int[] arr = beginning.clone();
        int count = 0;
        if(firstPress) {
            press(arr,0,n);
            count++;
        }
        for(int i=1;i<n;i++) {
            if(arr[i-1]!=target[i-1]) {
                press(arr,i,n);
                count++;
            }
        }
        if(isSame(arr,n)) {
            return count;
        }
        return Integer.MAX_VALUE;
    }

    static void press(int[] arr, int index,int n) {
        if(index == 0) {
            arr[0] = 1 - arr[0];
            if(n > 1) arr[1] = 1 - arr[1];
        }
        else if(index == n-1) {
            arr[n-1] = 1 - arr[n-1];
            arr[n-2] = 1 - arr[n-2];
        }
        else {
            arr[index-1] = 1 - arr[index-1];
            arr[index] = 1 - arr[index];
            arr[index+1] = 1 - arr[index+1];
        }
    }
}