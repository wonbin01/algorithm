import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t>0) {
            t--;
            int n = Integer.parseInt(br.readLine()); // 지원자의 수
            int[][] participant = new int[n][2]; // 서류 점수, 면접 점수
            int cnt=1;
            for(int i=0;i<n;i++) {
                String[] input = br.readLine().split(" ");
                int paperScore = Integer.parseInt(input[0]);
                int finalScore = Integer.parseInt(input[1]);
                participant[i][0] = paperScore;
                participant[i][1] = finalScore;
            }
            Arrays.sort(participant,(a,b) -> { // 서류 점수를 기준으로 정렬
                return Integer.compare(a[0],b[0]);
            });
            int minValue = participant[0][1];
            for(int i=1;i<n;i++) {
                int current = participant[i][1];
                if(minValue > current) {
                    cnt++;
                    minValue=current;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
