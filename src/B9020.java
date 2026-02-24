import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B9020 {
    static boolean[] isPrimaryNumber = new boolean[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=10000;i++) {
            isPrimaryNumber[i]=true;
        }
        init();
        while(t>0) {
            t--;
            int num = Integer.parseInt(br.readLine());
            ArrayList<int[]> list = new ArrayList<>();
            for(int i=2;i<=num;i++) {
                if(isPrimaryNumber[i]) {
                    int bigger = num-i;
                    if(isPrimaryNumber[bigger]) {
                        int min = Math.min(i,bigger);
                        int max = Math.max(i,bigger);
                        list.add(new int[] {min,max});
                    }
                }
            }
            Collections.sort(list,(a,b) -> {
                return Integer.compare(Math.abs(a[0]-a[1]),Math.abs(b[0]-b[1]));
            });
            sb.append(list.get(0)[0]).append(" ").append(list.get(0)[1]).append("\n");
        }
        System.out.println(sb);
    }
    static void init() {
        for(int i=2;i*i<=10000;i++) {
            if(isPrimaryNumber[i]) {
                for(int j=i*i;j<=10000;j+=i) {
                    isPrimaryNumber[j] = false;
            }
            }
        }
    }
}
