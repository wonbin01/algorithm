import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class B1325 {
    static ArrayList<Integer>[] graph;
    static int maxValue = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 컴퓨터의 개수
        int m = Integer.parseInt(input[1]); // 관계의 개수
        graph = new ArrayList[n+1];
        for(int i=1;i<=n;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            graph[end].add(start);
        }
        for(int i=1;i<=n;i++) {
            hacking(i,n);
        }
        System.out.println(sb);
    }
    static void hacking(int startNode,int n) {
        boolean[] visited = new boolean[n+1];
        int cnt=1;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.add(startNode);
        visited[startNode]=true;
        while(!stack.isEmpty()) {
            int cx = stack.pop();
            for(int nx : graph[cx]) {
                if(!visited[nx]) {
                    visited[nx]=true;
                    cnt++;
                    stack.add(nx);
                }
            }
        }
        if(maxValue==cnt) {
            sb.append(startNode).append(" ");
        }
        else if(maxValue<cnt) {
            maxValue = cnt;
            sb = new StringBuilder();
            sb.append(startNode).append(" ");
        }
    }
}
