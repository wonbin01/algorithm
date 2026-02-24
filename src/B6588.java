import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B6588 {
    static int max = 1000001;
    static boolean[] isPrimaryNumber=new boolean[max];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init();
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n==0) {
                break;
            }
            ArrayList<int[]> list = new ArrayList<>();
            for(int i=3;i<n;i++) {
                if(isPrimaryNumber[i]) {
                    int oddNumber = n-i;
                    if(isPrimaryNumber[oddNumber]) {
                        int max = Math.max(i,oddNumber);
                        int min = Math.min(i,oddNumber);
                        list.add(new int[] {min,max});
                        break;
                    }
                }
            }
            Collections.sort(list,(a,b) -> {
                return Integer.compare(b[1]-b[0],a[1]-a[0]);
            });
            makeResult(list, n);
        }
        System.out.println(sb);
    }
    static void init() {
        for(int i=1;i<=max-1;i++) {
            isPrimaryNumber[i] = true;
        }
        isPrimaryNumber[1]=false;
        for(int i=2;i*i<=max-1;i++) {
            if(isPrimaryNumber[i]) {
                for(int j=i*i;j<max;j+=i) {
                    isPrimaryNumber[j] = false;
                }
            }
        }
    }

    static void makeResult(ArrayList<int[]> list, int n) {
        if(list.size()==0) {
            sb.append("Goldbach's conjecture is wrong.").append("\n");
            return;
        }
        sb.append(n).append(" = ").append(list.get(0)[0]).append(" + ").append(list.get(0)[1]).append("\n");
    }
}
