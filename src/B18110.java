import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] level = new int[n];
        for(int i=0;i<n;i++) {
            int info = Integer.parseInt(br.readLine());
            level[i] = info;
        }
        Arrays.sort(level); // 오름차순으로 정렬
        int cut = (int)Math.round(n * 0.15);
        int total = 0;
        for(int i=cut;i<n-cut;i++) {
            total+=level[i];
        }
        int average = (int)Math.round((double)total/(n-2*cut));
        System.out.println(average);
    }
}
