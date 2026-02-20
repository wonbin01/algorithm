import java.util.*;
public class P42885 {
    class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int front = 0;
        int back = people.length-1;
        while(front<=back) {
            if(people[front] + people[back] <=limit) {
                front++; back--;
            }
            else {
                back--;
            }
            answer++;
        }
        return answer;
    }
}
}
