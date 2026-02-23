import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B4948 {
    static final int MAX = 246912;
    static boolean[] primaryNumber = new boolean[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        init();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            int count = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (primaryNumber[i]) count++;
            }
            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
    static void init() {
        // 1. 일단 전부 true로
        for (int i = 2; i <= MAX; i++) {
            primaryNumber[i] = true;
        }

        for(int i=2;i*i<=MAX;i++) {
            if(primaryNumber[i]) {
                for(int j=i*i;j<=MAX;j+=i) {
                    primaryNumber[j]=false;
                }
            }
        }
    }
}
