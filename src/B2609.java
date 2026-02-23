import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int num1 = Integer.parseInt(input[0]);
        int num2 = Integer.parseInt(input[1]);
        int min = Math.min(num1,num2);
        int max = Math.max(num1,num2);
        int maxValue = 1;
        int minValue = 1;
        for(int i=1;i<=min;i++) {
            if(min%i==0 && max%i==0) {
                maxValue = Math.max(maxValue,i); // 최대공약수
            }
        }
        minValue = maxValue * (max/maxValue) * (min/maxValue);
        System.out.println(maxValue);
        System.out.println(minValue);
    }
}
