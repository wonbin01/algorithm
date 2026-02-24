import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 몇명의 사람이 있는지
        int k = Integer.parseInt(input[1]); // 몇번째 제거하는지
        ArrayList<Integer> list = new ArrayList<>();
        int index=0; int cnt=0;
        boolean[] visited = new boolean[n+1];
        while(list.size()<n) {
            index++;
            index%=n;
            if(index==0) index=n;
            if(!visited[index]) {
                cnt++;
            }
            if(cnt==k) {
                list.add(index);
                visited[index]=true;
                cnt=0;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i=0;i<n;i++) {
            if(i==n-1) {
                sb.append(list.get(i)).append(">");
            }
            else {
                sb.append(list.get(i)).append(", ");
            }
        }
        System.out.println(sb);
    }
}
