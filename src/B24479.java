import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class B24479 {
    static HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[] visiting;
    static int cnt=1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 정점의 수
        int m = Integer.parseInt(input[1]); // 간선의 수
        int R = Integer.parseInt(input[2]); // 시작 정점
        for(int i=1;i<=n;i++) {
            hm.putIfAbsent(i,new ArrayList<>());
        }
        for(int i=0;i<m;i++) {
            input = br.readLine().split(" ");
            int node1 = Integer.parseInt(input[0]);
            int node2 = Integer.parseInt(input[1]);
            hm.get(node1).add(node2);
            hm.get(node2).add(node1);
        }
        for(int i=1;i<=n;i++) {
            Collections.sort(hm.get(i));
        }
        visited = new boolean[n+1];
        visiting = new int[n+1]; // 방문 순서 저장
        for(int i=1;i<=n;i++) {
            visiting[i]=0;
        }
        dfs(R,n);
        for(int i=1;i<=n;i++) {
            sb.append(visiting[i]).append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int startNode, int n) {
    Stack<Integer> stack = new Stack<>();
    stack.push(startNode);

    while(!stack.isEmpty()) {
        int cx = stack.pop();

        if(!visited[cx]) {
            visited[cx] = true;
            visiting[cx] = cnt++;

            // 오름차순 방문을 위해 역순으로 push
            ArrayList<Integer> list = hm.get(cx);
            for(int i = list.size() - 1; i >= 0; i--) {
                int nx = list.get(i);
                if(!visited[nx]) {
                    stack.push(nx);
                }
            }
        }
    }
}

}
