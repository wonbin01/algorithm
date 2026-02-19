import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] playStudent = new boolean[n + 1];
        int cnt = 0;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for (int i = 1; i <= n; i++) {
            playStudent[i] = true;
        }
        for (int i = 0; i < lost.length; i++) {
            playStudent[lost[i]] = false;
        }

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    playStudent[lost[i]] = true; 
                    lost[i] = -1;    
                    reserve[j] = -1; 
                    break;
                }
            }
        }

        for (int i = 0; i < reserve.length; i++) {
            if (reserve[i] == -1) continue;

            if (reserve[i] - 1 >= 1 && !playStudent[reserve[i] - 1]) {
                playStudent[reserve[i] - 1] = true;
            } else if (reserve[i] + 1 <= n && !playStudent[reserve[i] + 1]) {
                playStudent[reserve[i] + 1] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (playStudent[i]) {
                cnt++;
            }
        }
        return cnt;
    }
}