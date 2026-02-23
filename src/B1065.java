import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt=0;
        for(int i=1;i<=n;i++) {
            ArrayList<Integer> al = new ArrayList<>();
            int current=i;
            while(true) {
                int remain = current%10;
                al.add(remain);
                current/=10;
                if(current==0) {
                    break;
                }
            }
            if(calculateDiff(al)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    static boolean calculateDiff(ArrayList<Integer> list) {
        int length = list.size();
        if(length==1 || length==2) {
            return true;
        }
        int diff=list.get(0)-list.get(1);
        for(int i=0;i<length-1;i++) {
            int cx = list.get(i)-list.get(i+1);
            if(diff!=cx) {
                return false;
            }
        }
        return true;
    }
}
