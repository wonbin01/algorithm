import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class B2941 {
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int total=0;
        int current=0;
        while(current<input.length()) {
            String twoSub = "";
            String threeSub = "";
            if(current+2<=input.length()) {
                twoSub = input.substring(current, current+2);
            }
            if(current+3<=input.length()) {
                threeSub = input.substring(current, current+3);
            }

            if(set.contains(threeSub)) {
                total++;
                current+=3;
            }
            else if(set.contains(twoSub)) {
                total++;
                current+=2;
            }
            else{
                total++;
                current++;
            }
        }
        System.out.println(total);
    }
    static void init() {
        set.add("c="); set.add("dz=");
        set.add("c-"); set.add("d-");
        set.add("lj"); set.add("nj");
        set.add("s="); set.add("z=");
    }
}
