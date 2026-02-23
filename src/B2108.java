import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class B2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 숫자의 개수
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int total=0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++) {
            total+=arr[i];
            hm.putIfAbsent(arr[i], 0);
            hm.put(arr[i],hm.get(arr[i])+1);
        }
        double temp = (double) total / n;
        int average = (int) Math.round(temp);
        int middleValue = arr[n/2]; // 중앙값
        int popularValue = findPopularValue(hm);
        int range = Math.abs(arr[n-1] - arr[0]); // 범위
        StringBuilder sb = new StringBuilder();
        sb.append(average).append("\n");
        sb.append(middleValue).append("\n");
        sb.append(popularValue).append("\n");
        sb.append(range).append("\n");
        System.out.println(sb);
    }
    static int findPopularValue(HashMap<Integer,Integer> hm) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        int maxValue = Integer.MIN_VALUE;
        for(int key : hm.keySet()) {
            map.putIfAbsent(hm.get(key),new ArrayList<>());
            map.get(hm.get(key)).add(key);
            maxValue = Math.max(maxValue,hm.get(key));
        }
        if(map.get(maxValue).size()!=1) {
            Collections.sort(map.get(maxValue));
            return map.get(maxValue).get(1);
        }
        return map.get(maxValue).get(0);
    }
}
