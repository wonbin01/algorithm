import java.util.*;

public class P42861 {
class Solution {
    HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
    public int solution(int n, int[][] costs) {
        int answer=0;
        Arrays.sort(costs,(a,b) -> {
            if(a[2]==b[2]) { // 건설 비용이 같은 경우
                if(a[0]==b[0]) {
                    return Integer.compare(a[1],b[1]);
                }
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[2],b[2]);
        });
        for(int i=0;i<n;i++) {
            hm.putIfAbsent(i, new ArrayList<>());
        }
        int index=0;
        int connected=0;
        while(connected<n-1) { // 이전값과 비교해서 변하지 않았으면 제거, 변했으면 값 업데이트
            int startCity = costs[index][0];
            int nextCity = costs[index][1];
            int cost = costs[index++][2];
            if(!checkIsConnected(n, startCity, nextCity)) {
                hm.get(startCity).add(nextCity);
                hm.get(nextCity).add(startCity);
                answer+=cost;
                connected++;
            }
        }
        return answer;
    }
    boolean checkIsConnected(int n, int startCity, int nextCity) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        visited[startCity] = true;
        queue.add(startCity);
        while(!queue.isEmpty()) {
            int cx = queue.poll();
            if(cx==nextCity) { // 이미 연결된 도시
                return true;
            }
            for(int nx : hm.get(cx)) {
                if(!visited[nx]) {
                    visited[nx] = true;
                    queue.add(nx);
                }
            }
        }
        return false;
    }
}
}