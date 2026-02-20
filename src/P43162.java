import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class P43162 {
    class Solution {
        HashMap<Integer,ArrayList<Integer>> network = new HashMap<>();
    public int solution(int n, int[][] computers) {
        for(int i=0;i<n;i++) {
            network.putIfAbsent(i, new ArrayList<>());
        }
        for(int i=0;i<computers.length;i++) {
            int[] info = computers[i];
            for(int j=0;j<info.length;j++) {
                if(i==j) continue;
                if(info[j]==1) {
                    network.get(i).add(j);
                }
            }
        }
        boolean[] visited = new boolean[n];
        int cnt=0;
        for(int i=0;i<n;i++) {
            if(!visited[i]) { // 아직 방문되지 않은 경우
                traversal(visited,i);
                cnt++;
            }
        }
        return cnt;
    }
    void traversal(boolean[] visited, int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;
        while(!queue.isEmpty()) {
            int cx = queue.poll();
            for(int nx : network.get(cx)) {
                if(!visited[nx]) {
                    visited[nx] = true;
                    queue.add(nx);
                }
            }
        }
    }
}
}
