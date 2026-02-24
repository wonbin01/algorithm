import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            String[] input = br.readLine().split(" ");
            int x=Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            list.add(new int[] {x,y});
        }
        Collections.sort(list,(a,b) -> {
            if(a[1]==b[1]) {
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[1],b[1]);
        });
        StringBuilder sb = new StringBuilder();
        for(int[] cx : list) {
            sb.append(cx[0]).append(" ").append(cx[1]).append("\n");
        }
        System.out.println(sb);
    }
}
