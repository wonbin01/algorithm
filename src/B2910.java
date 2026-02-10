import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class B2910 {
    static HashMap<Integer,Integer> hm = new HashMap<>();
    static HashMap<Integer,Integer> firstInfo = new HashMap<>();
    static List<Integer> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 메시지의 길이
         // int c = Integer.parseInt(input[1]); // 나올 수 있는 최대값 
        int[] numbers = new int[n];
        input = br.readLine().split(" ");
        for(int i=0;i<n;i++) {
            numbers[i] = Integer.parseInt(input[i]);
            hm.put(numbers[i], hm.getOrDefault(numbers[i], 0)+1);
            firstInfo.putIfAbsent(numbers[i], i);
        }
        for(int key : hm.keySet()) {
            list.add(key);
        }
        Collections.sort(list,(a,b)-> {
            if(hm.get(a)==hm.get(b)) {
                return Integer.compare(firstInfo.get(a),firstInfo.get(b));
            }
            return Integer.compare(hm.get(b), hm.get(a));
        });
        StringBuilder sb = new StringBuilder();
        for(int num : list) {
            int size = hm.get(num);
            for(int i=0;i<size;i++) {
                sb.append(num).append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}