import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int[] arr = new int[8];
        for(int i=0;i<8;i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        if(checkAsc(arr)) {
            System.out.println("ascending");
        }
        else if(checkDesc(arr)) {
            System.out.println("descending");
        }
        else {
            System.out.println("mixed");
        }
    }
    static boolean checkAsc(int[] arr) {
        for(int i=0;i<7;i++) {
            if(arr[i+1]<=arr[i]) {
                return false;
            }
        }
        return true;
    }
    static boolean checkDesc(int[] arr) {
        for(int i=0;i<7;i++) {
            if(arr[i+1]>=arr[i]) {
                return false;
            }
        }
        return true;
    }
}
