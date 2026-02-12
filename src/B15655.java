import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class B15655 {
    static int[] numbers;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // n개의 수
        numbers = new int[n];
        int m = Integer.parseInt(input[1]); // n개의 수에서 m개 고르기
        input = br.readLine().split(" ");
        for(int i=0;i<n;i++) {
            int num = Integer.parseInt(input[i]);
            numbers[i] = num;
        }
        Arrays.sort(numbers);
        chooseNumbers(new TreeSet<>(), new boolean[n], m, 0, 0);
        System.out.println(sb.toString());
    }
    static void chooseNumbers(TreeSet<Integer> set, boolean[] visited, int m, int currentCnt, int index) {
        if(currentCnt==m) {
            for(int num : set) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=index;i<numbers.length;i++) {
            if(!visited[i]) {
                set.add(numbers[i]);
                visited[i]=true;
                chooseNumbers(set, visited, m, currentCnt+1, i+1);
                visited[i]=false;
                set.remove(numbers[i]);
            }
        }
    }
}
