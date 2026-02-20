public class P43165 {
    class Solution {
        int answer=0;
    public int solution(int[] numbers, int target) {
        int n = numbers.length;
        calculate(n,0,0,target,numbers);
        return answer;
    }
    void calculate(int n,int index, int current, int target, int[] numbers) {
        if(index==n) {
            if(current==target) {
                answer++;
            }
            return;
        }
        calculate(n,index+1,current+numbers[index],target,numbers);
        calculate(n,index+1,current-numbers[index],target,numbers);
    }
}
}
// [1, 1, 1, 1, 1]
// 3 -> 5

// -1+1+1+1+1 = 3
// +1-1+1+1+1 = 3
// +1+1-1+1+1 = 3
// +1+1+1-1+1 = 3
// +1+1+1+1-1 = 3