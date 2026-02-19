import java.util.*;

public class P42747 {
    class Solution {
        public int solution(int[] citations) {
            Arrays.sort(citations);
            int length = citations.length;
            int maxValue = 0;
            for (int i = 0; i < length; i++) {
                int h = length - i;   // 뒤에 남은 논문 개수
                if (citations[i] >= h) {
                    maxValue = h;
                    break;  // 처음 만족하는 게 최대값
                }
            }
            return maxValue;
        }
    }
}
