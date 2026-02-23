import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 회원의 수
        ArrayList<Member> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            String[] input = br.readLine().split(" ");
            int age = Integer.parseInt(input[0]);
            String name = input[1];
            Member member = new Member(age, name, i);
            list.add(member);
        }
        Collections.sort(list,(a,b) -> {
            if(a.age == b.age) {
                return Integer.compare(a.order,b.order);
            }
            return Integer.compare(a.age,b.age);
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            Member member = list.get(i);
            sb.append(member.age).append(" ").append(member.name).append("\n");
        }
        System.out.println(sb);
    }
}
class Member {
    int age;
    String name;
    int order;
    Member(int age, String name, int order) {
        this.age = age;
        this.name = name;
        this.order = order;
    }
}
