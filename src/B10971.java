import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class B10971 {
    static int minCost = Integer.MAX_VALUE;
    static HashMap<Integer,List<TravelInfo>> hm = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시의 수
        for(int i=1;i<=n;i++) {
            String[] input = br.readLine().split(" ");
            hm.putIfAbsent(i, new ArrayList<>());
            for(int j=1;j<=n;j++) {
                if(i==j) {
                    continue;
                }
                int city=j;
                int cost = Integer.parseInt(input[j-1]);
                hm.get(i).add(new TravelInfo(city,cost));
            }
        }
        for(int i=1;i<=n;i++) {
            boolean[] visited = new boolean[n+1];
            visited[i] = true;
            traversalCity(i, visited, 1, n, 0,i);
        }
        System.out.println(minCost);
    }
    static void traversalCity(int startCity, boolean[] visited, int travelCnt, int n, int totalCost, int endCity) {
        if(travelCnt==n) {
            int cost=0;
            for(TravelInfo candidate : hm.get(startCity)) {
                if(candidate.city==endCity) {
                    cost=candidate.cost;
                }
            }
            if(cost!=0) {
                minCost = Math.min(minCost, totalCost+cost);
            }
            return;
        }
        for(int i=1;i<=n;i++) {
            if(startCity==i) {
                continue;
            }
            if(!visited[i]) { //아직 방문되지 않은 경우
                visited[i]=true;
                int cost=0;
                for(TravelInfo candidate : hm.get(startCity)) {
                    if(candidate.city==i) {
                        cost=candidate.cost;
                        if(cost==0) {
                            continue;
                        }
                        break;
                    }
                }
                if(cost!=0) {
                    totalCost+=cost;
                    traversalCity(i, visited, travelCnt+1, n, totalCost,endCity);
                    totalCost-=cost;
                    visited[i]=false;
                }
                visited[i]=false;
            }
        }
    }
}
class TravelInfo{
    int city;
    int cost;
    TravelInfo(int city, int cost) {
        this.city=city;
        this.cost=cost;
    }
}
// 4
// 0 10 15 20
// 5 0 9 10
// 6 13 0 12
// 8 8 9 0