import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class B2529 {
    static String[] brace;
    static long max=Long.MIN_VALUE;
    static long min=Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine()); // 부등호의 개수
        brace = br.readLine().split(" ");
        for(int i=0;i<=9;i++) {
            boolean[] visited = new boolean[10];
            List<Integer> list = new LinkedList<>();
            list.add(i);
            visited[i]=true;
            makeNumbers(0, visited, k, list);
        }
        System.out.println(max);
        String realMin=(min+"");
        if((min+"").length()==k) {
            realMin="0"+(min+"");
        }
        System.out.println(realMin);
    }
    static void makeNumbers(int index, boolean[] visited, int k, List<Integer> list) {
        if(list.size()==k+1) {
            StringBuilder sb = new StringBuilder();
            for(int n : list) {
                sb.append(n);
            }
            long candidate = Long.parseLong(sb.toString());
            max = Math.max(candidate, max);
            min = Math.min(candidate,min);
            return;
        }
        int prior = list.get(index);
        String currentBrace = brace[index];
        if(currentBrace.equals(">")) {
            for(int i=0;i<=9;i++) {
                if(!visited[i] && prior>i) {
                    visited[i]=true;
                    list.add(i);
                    makeNumbers(index+1, visited, k, list);
                    visited[i]=false;
                    list.remove(list.size()-1);
                }
            }
        }
        else if(currentBrace.equals("<")) {
            for(int i=0;i<=9;i++) {
                if(!visited[i] && prior<i) {
                    visited[i]=true;
                    list.add(i);
                    makeNumbers(index+1, visited, k, list);
                    visited[i]=false;
                    list.remove(list.size()-1);
                }
            }
        }
    }
}
// < > -> 897, 021