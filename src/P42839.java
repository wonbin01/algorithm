import java.util.Arrays;
import java.util.HashSet;

public class P42839 {
    class Solution {
    HashSet<Integer> hs = new HashSet<>();
    boolean[] visited;
    int[] numbers;
    public int solution(String numbers) {
        int answer = 0;
        int length = numbers.length();
        int[] num = new int[length];
        for(int i=0;i<length;i++) {
            num[i] = numbers.charAt(i)-'0';
        }
        Arrays.sort(num);
        makeNumbers(length, num);
        for(int target : hs) {
            if(checkIsPrimaryNumber(target)) {
                answer++;
            }
        }
        return answer;
    }
    void makeNumbers(int length, int[] num) {
    numbers = num;
    visited = new boolean[length];

    for(int i = 1; i <= length; i++) {
        dfs(0, i, new StringBuilder());
    }
}

    boolean checkIsPrimaryNumber(int number) {
        int current=0;
        for(int i=1;i<=number/2;i++) {
            if(number%i==0) {
                current++;
            }
        }
        if(current==1) return true;
        return false;
    }

    void dfs(int depth, int targetLength, StringBuilder sb) {
        if(depth == targetLength) {
            hs.add(Integer.parseInt(sb.toString()));
            return;
        }
        for(int i=0;i<numbers.length;i++) {
            if(!visited[i]) {
                visited[i] = true;
                sb.append(numbers[i]);
                dfs(depth+1, targetLength, sb);
                visited[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
}
// 11과 011은 같은 숫자 처리
// 1 7 -> 7 17 71
// 0 1 1 -> 11 101
// 1 3 7 8