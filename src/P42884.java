import java.util.Arrays;

public class P42884 {
    class Solution {
        public int solution(int[][] routes) {
            int answer = 0;

            Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

            int camera = Integer.MIN_VALUE;

            for (int[] route : routes) {
                int start = route[0];
                int end = route[1];

                // 현재 카메라로 못 잡는 경우
                if (camera < start) {
                    camera = end;  // 새 카메라 설치
                    answer++;
                }
            }

            return answer;
        }
    }
}
