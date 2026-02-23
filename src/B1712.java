import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long fix = Integer.parseInt(input[0]); // 고정비용
        long validate = Integer.parseInt(input[1]); // 가변비용
        long notebookPrice = Integer.parseInt(input[2]); // 노트북 가격
        if(validate>=notebookPrice) {
            System.out.println(-1);
            return;
        }
        long result = fix / (notebookPrice - validate) + 1;
        System.out.println(result);
    }
}
