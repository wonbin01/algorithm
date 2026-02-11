import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class B1764 {
    static HashSet<String> notListening = new HashSet<>();
    static List<String> notListeningAndLooking = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 듣도 못한
        int m = Integer.parseInt(input[1]); // 보도 못한
        for(int i=0;i<n;i++) {
            notListening.add(br.readLine());
        }
        for(int i=0;i<m;i++) {
            String in = br.readLine();
            if(notListening.contains(in)) {
                notListeningAndLooking.add(in);
            }
        }
        Collections.sort(notListeningAndLooking);
        StringBuilder sb = new StringBuilder();
        sb.append(notListeningAndLooking.size()).append("\n");
        for(String name : notListeningAndLooking) {
            sb.append(name).append("\n");
        }
        System.out.println(sb.toString());
    }
}
