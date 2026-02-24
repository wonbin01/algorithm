import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class B18352 {
    static HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] distance; // 최단 거리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 도시의 개수
        int m = Integer.parseInt(input[1]); // 도로의 개수
        int k = Integer.parseInt(input[2]); // 거리 정보
        int x = Integer.parseInt(input[3]); // 출발 도시 정보
        distance = new int[n+1];
        for(int i=1;i<=n;i++) {
            hm.putIfAbsent(i, new ArrayList<>());
        }
        for(int i=0;i<m;i++) {
            input = br.readLine().split(" ");
            int city1 = Integer.parseInt(input[0]);
            int city2 = Integer.parseInt(input[1]);
            hm.get(city1).add(city2);
        }
        traversal(x,n,k);
        for(int i=1;i<=n;i++) {
            if(distance[i]==k) {
                list.add(i);
            }
        }
        Collections.sort(list);
        if(list.size()==0) {
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int city : list) {
            sb.append(city).append("\n");
        }
        System.out.println(sb);
    }
    static void traversal(int x,int n,int k) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        for(int i=1;i<=n;i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[x]=0;
        deque.add(new int[] {x,0});
        while(!deque.isEmpty()) {
            int[] cx = deque.getFirst();
            deque.removeFirst();
            if(cx[1]==k) {
                continue;
            }
            for(int nx : hm.get(cx[0])) {
                int nextCnt = cx[1] +1;
                if(nextCnt<=distance[nx]) {
                    distance[nx]=nextCnt;
                    deque.addLast(new int[] {nx,nextCnt});
                }
            }
        }
    }
}
