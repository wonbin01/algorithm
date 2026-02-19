import java.util.*;

public class P86971 {
    class Solution {

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int minValue = Integer.MAX_VALUE;

        public int solution(int n, int[][] wires) {

            for(int i = 1; i <= n; i++) {
                map.put(i, new ArrayList<>());
            }

            for(int i = 0; i < wires.length; i++) {
                int a = wires[i][0];
                int b = wires[i][1];
                map.get(a).add(b);
                map.get(b).add(a);
            }

            // 간선 하나씩 제거
            for(int i = 1; i <= n; i++) {

                // ★ 복사본 사용 (순회 안전)
                for(int node : new ArrayList<>(map.get(i))) {

                    // ★ 같은 간선 두 번 자르는 것 방지
                    if(i < node) {

                        // 간선 제거
                        map.get(i).remove(Integer.valueOf(node));
                        map.get(node).remove(Integer.valueOf(i));

                        boolean[] visited = new boolean[n+1];

                        // 한 쪽 트리 크기 구하기
                        int firstTree = checkDiff(visited, i);

                        // 두 트리 차이 계산
                        int secondTree = n - firstTree;

                        minValue = Math.min(minValue,
                                Math.abs(firstTree - secondTree));

                        // 간선 복구
                        map.get(i).add(node);
                        map.get(node).add(i);
                    }
                }
            }

            return minValue;
        }

        int checkDiff(boolean[] visited, int start) {

            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            visited[start] = true;

            int cnt = 1;

            while(!queue.isEmpty()) {
                int cur = queue.poll();

                for(int next : map.get(cur)) {
                    if(!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                        cnt++;
                    }
                }
            }

            return cnt;
        }
    }
}
