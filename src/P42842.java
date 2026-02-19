public class P42842 {
    class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        long target = brown+yellow;
        for(int row=1;row<=yellow;row++) {
            int col = yellow/row;
            if(yellow%row!=0) continue;
            int targetRow = row+2;
            int targetCol = col+2;
            if(targetRow * targetCol == target && targetCol >= targetRow) {
                answer = new int[] {targetCol,targetRow};
                break;
            }
        }
        return answer;
    }
}
}
// 가로가 세로보다 길거나 같아야함.
