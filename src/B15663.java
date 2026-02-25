import java.io.*;
import java.util.*;

public class B15663 {
    static int[] numbers;
    static boolean[] visited;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        numbers = new int[n];
        visited = new boolean[n];

        input = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(numbers); // 오름차순 정렬
        dfs(0, new ArrayList<>());

        System.out.println(sb);
    }

    static void dfs(int depth, ArrayList<Integer> list) {
        if(depth == m) {
            for(int num : list) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1; // 같은 depth에서 중복 방지

        for(int i = 0; i < n; i++) {
            if(!visited[i] && numbers[i] != prev) {
                visited[i] = true;
                list.add(numbers[i]);
                prev = numbers[i];

                dfs(depth + 1, list);

                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
