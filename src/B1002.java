import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(t-- > 0) {
            String[] input = br.readLine().split(" ");

            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int r1 = Integer.parseInt(input[2]);
            int x2 = Integer.parseInt(input[3]);
            int y2 = Integer.parseInt(input[4]);
            int r2 = Integer.parseInt(input[5]);

            int dx = x1 - x2;
            int dy = y1 - y2;

            int distPow = dx*dx + dy*dy;
            int sumPow = (r1 + r2) * (r1 + r2);
            int diffPow = (r1 - r2) * (r1 - r2);

            if(distPow == 0) {
                if(r1 == r2) sb.append(-1);
                else sb.append(0);
            }
            else if(distPow > sumPow) {
                sb.append(0);
            }
            else if(distPow == sumPow) {
                sb.append(1);
            }
            else if(distPow < diffPow) {
                sb.append(0);
            }
            else if(distPow == diffPow) {
                sb.append(1);
            }
            else {
                sb.append(2);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
