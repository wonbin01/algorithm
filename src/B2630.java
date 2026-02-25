import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2630 {
    static int[][] map;
    static int blue = 0;
    static int white = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        divide(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    // 분할 정복 함수
    static void divide(int row, int col, int size) {
        if(checkPaper(row, col, size)) {
            if(map[row][col] == 1) {
                blue++;
            } else {
                white++;
            }
            return;
        }
        int newSize = size / 2;
        // 4등분
        divide(row, col, newSize);
        divide(row, col + newSize, newSize);
        divide(row + newSize, col, newSize);
        divide(row + newSize, col + newSize, newSize);
    }

    // 해당 영역이 한 색인지 검사
    static boolean checkPaper(int row, int col, int size) {
        int color = map[row][col];

        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(map[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }
}
