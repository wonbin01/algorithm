import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        int total=0;
        for(int i=m;i<=n;i++) {
            if(checkPrimaryNumber(i)) {
                list.add(i);
            }
        }
        Collections.sort(list);
        if(list.size()==0) {
            System.out.println(-1);
            return;
        }
        for(int num : list) {
            total+=num;
        }
        System.out.println(total);
        System.out.println(list.get(0));
    }
    static boolean checkPrimaryNumber(int target) {
        int cnt=0;
        for(int i=1;i<=target/2;i++) {
            if(target%i==0) {
                cnt++;
            }
        }
        return cnt==1; // 소수면 true, 아니면 false
    }
}
