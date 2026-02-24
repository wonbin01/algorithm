import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 세로
        int m = Integer.parseInt(input[1]); // 가로
        int blockCnt = Integer.parseInt(input[2]); // 블록의 개수
        int minTime = Integer.MAX_VALUE;
        int maxValue=Integer.MIN_VALUE;
        int[][] map = new int[n][m];
        int maxHeight = Integer.MIN_VALUE;
        int minHeight = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            input = br.readLine().split(" ");
            for(int j=0;j<m;j++) {
                int height = Integer.parseInt(input[j]);
                map[i][j] = height;
                maxHeight = Math.max(maxHeight, height);
                minHeight = Math.min(minHeight, height);
            }
        }
        for(int h = minHeight; h <= maxHeight; h++) {

            int remove = 0;
            int add = 0;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(map[i][j] > h) {
                        remove += map[i][j] - h;
                    } else {
                        add += h - map[i][j];
                    }
                }
            }

            if(remove + blockCnt < add) continue;

            int time = remove * 2 + add;

            if(time < minTime ||
            (time == minTime && h > maxValue)) {
                minTime = time;
                maxValue = h;
            }
}
        System.out.println(minTime + " " +maxValue);
    }
}
// 제거하고 인벤토리 추가 : 2초
// 인벤토리에서 블록 꺼내서 추가 : 1초