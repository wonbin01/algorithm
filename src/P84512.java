import java.util.TreeSet;

public class P84512 {
    class Solution {
    char[] moum = new char[] {'A','E','I','O','U'};
    TreeSet<String> ts = new TreeSet<>();
    public int solution(String word) {
        int cnt=1;
        for(int i=1;i<=5;i++) {
            init(i,new StringBuilder());
        }
        for(String candidate : ts) {
            if(candidate.equals(word)) {
                break;
            }
            cnt++;
        }
        return cnt;
    }
    void init(int targetLength, StringBuilder sb) {
        if(sb.length()==targetLength) {
            ts.add(sb.toString());
            return;
        }
        for(int i=0;i<moum.length;i++) {
            sb.append(moum[i]);
            init(targetLength, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
}
// A, E, I, O, U