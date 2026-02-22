import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1080 {
    static int[][] beginning;
    static int[][] target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        beginning = new int[n][m];
        target = new int[n][m];
        for(int i=0;i<n;i++) {
            String input1 = br.readLine();
            for(int j=0;j<m;j++) {
                beginning[i][j] = input1.charAt(j)-'0';
            }
        }
        for(int i=0;i<n;i++) {
            String input2 = br.readLine();
            for(int j=0;j<m;j++) {
                target[i][j] = input2.charAt(j)-'0';
            }
        }
        int cnt=0;
        for(int i=0;i<=n-3;i++) {
            for(int j=0;j<=m-3;j++) {
                if(beginning[i][j] != target[i][j]) {
                    flip(i,j);
                    cnt++;
                }
            }
        }
        if(checkSame(n, m)) {
            System.out.println(cnt);
        }
        else {
            System.out.println(-1);
        }
    }
    static void flip(int row, int col) {
        for(int i=row;i<row+3;i++) {
            for(int j=col;j<col+3;j++) {
                beginning[i][j] = 1-beginning[i][j];
            }
        }
    }
    static boolean checkSame(int n, int m) {
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(beginning[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
