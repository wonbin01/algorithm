import java.util.Arrays;

class P87946 {
    class Solution {
    boolean visited[];
    int maxValue = Integer.MIN_VALUE;
    public int solution(int k, int[][] dungeons) {
        int length = dungeons.length;
        if(length==1) { // 던전이 1인 경우 예외 확인
            if(dungeons[0][0] > k) {
                return 0;
            }
            else {
                return 1;
            }
        }
        visited = new boolean[length];
        Arrays.sort(dungeons, (a,b) -> {
            return Integer.compare(a[0], b[0]);
        }); // 필요 피로도를 기준으로 정렬
        calculateTravel(k, dungeons, 0);
        return maxValue;
    }
    void calculateTravel(int current, int[][] dungeons, int depth) {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<visited.length;i++) {
            if(!visited[i]) {
                min = Math.min(min,dungeons[i][0]);
                break;
            }
        }
        if(current < min) {
            maxValue = Math.max(maxValue,depth);
            return;
        }
        for(int i=0;i<visited.length;i++) {
            if(!visited[i] && current>=dungeons[i][0]) {
                visited[i] = true;
                calculateTravel(current-dungeons[i][1], dungeons, depth+1);
                visited[i] = false;
            }
        }
    }
}
} 