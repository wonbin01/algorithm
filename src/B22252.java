import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class B22252{
    static HashMap<String,PriorityQueue<Integer>> hm = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        long total=0;
        for(int i=0;i<q;i++) {
            String[] input = br.readLine().split(" ");
            int option = Integer.parseInt(input[0]); // 옵션 선택
            if(option==1) {
                String name = input[1]; // 고릴라 이름
                int infoNums = Integer.parseInt(input[2]); // 가진 정보의 개수
                hm.putIfAbsent(name, new PriorityQueue<>(Collections.reverseOrder()));
                for(int j=0;j<infoNums;j++) {
                    int info = Integer.parseInt(input[j+3]); // 정보의 가치
                    hm.get(name).add(info); // 정보 집어넣음
                }
            }
            else if(option==2) {
                String name = input[1]; // 고릴라 이름
                int wanted = Integer.parseInt(input[2]); // 원하는 정보의 개수
                hm.putIfAbsent(name, new PriorityQueue<>(Collections.reverseOrder()));
                if(hm.get(name).size()<wanted) wanted=hm.get(name).size();
                
                for(int j=0;j<wanted;j++) {
                    total+=hm.get(name).poll();
                }
            }
        }
        System.out.println(total);
    }
}