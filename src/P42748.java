import java.util.*;
public class P42748 {
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int[] com : commands) {
            ArrayList<Integer> al = new ArrayList<>();
            int start = com[0]-1;
            int end = com[1]-1;
            int target = com[2]-1;
            for(int i=start;i<=end;i++) {
                al.add(array[i]);
            }
            Collections.sort(al);
            result.add(al.get(target));
        }
        int[] answer = new int[result.size()];
        for(int i=0;i<result.size();i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
}