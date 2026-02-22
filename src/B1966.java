import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B1966 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
while(t > 0) {
    String[] input = br.readLine().trim().split("\\s+");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);

    if(n == 1) {
        sb.append(1).append("\n");
        br.readLine(); // 중요도 줄 소비해줘야 안전
        t--;
        continue;
    }

    input = br.readLine().trim().split("\\s+");

    Queue<int[]> queue = new LinkedList<>();
    for(int i = 0; i < n; i++) {
        int point = Integer.parseInt(input[i]);
        queue.add(new int[] {point, i});
    }

    printing(queue, m);
    t--;
}

        System.out.println(sb);
    }
static void printing(Queue<int[]> queue,int m) {
    int cnt = 0;

    while(!queue.isEmpty()) {
        int[] current = queue.poll();
        boolean isMax = true;

        // 현재 문서보다 높은 중요도가 있는지 확인
        for(int[] cx : queue) {
            if(current[0] < cx[0]) {
                isMax = false;
                break;
            }
        }

        if(!isMax) {
            queue.add(current);
        } else {
            cnt++;
            if(current[1] == m) {
                sb.append(cnt).append("\n");
                return;
            }
        }
    }
}

}
