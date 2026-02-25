import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1992 {
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i=0;i<n;i++) {
            String input = br.readLine();
            for(int j=0;j<n;j++) {
                map[i][j] = input.charAt(j)-'0';
            }
        }
        divide(0, 0, n);
        System.out.println(sb);
    }

    static void divide(int row, int col, int size) {
        if(isSame(row, col, size, map[row][col])) {
            sb.append(map[row][col]);
            return;
        } else {
            sb.append("(");
        }
        size /= 2;
        divide(row, col, size);
        divide(row,col+size,size);
        divide(row+size, col,size);
        divide(row+size, col+size, size);
        sb.append(")");
    }

    static boolean isSame(int row, int col, int size, int initColor) {
        for(int i=row;i<row+size;i++) {
            for(int j=col;j<col+size;j++) {
                if(map[i][j] != initColor) {
                    return false;
                }
            }
        }
        return true;
    }
}
