import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B16924 {
    static int row;
    static int col;
    static char[][] map;
    static int cnt=0;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<int[]> list = new ArrayList<>();
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        row = Integer.parseInt(input[0]); // 세로
        col = Integer.parseInt(input[1]); // 길이
        map = new char[row][col];
        visited=new boolean[row][col];
        for(int i=0;i<row;i++) {
            String in = br.readLine();
            for(int j=0;j<col;j++) {
                map[i][j] = in.charAt(j);
            }
        }
        for(int i=1;i<row-1;i++) {
            for(int j=1;j<col-1;j++) {
                if (map[i][j]=='*') {
                    calculateCnt(i, j);
                }
            }
        }
        boolean isChecked = true;
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(map[i][j]=='*' && !visited[i][j]) {
                    isChecked=false;
                }
            }
        }
        if(!isChecked || cnt==0) {
            System.out.println(-1);
            return;
        }
        sb.append(cnt).append("\n");
        for(int[] cx : list) {
            sb.append(cx[0]).append(" ").append(cx[1]).append(" ").append(cx[2]).append("\n");
        }
        System.out.println(sb);
    }
    static void calculateCnt(int cx,int cy) {
        int length=1;
        while(true) {
            if(cx-length < 0 || cx + length>=row ||
                cy-length < 0 || cy + length >=col
            ) {
                break;
            }
            if(map[cx-length][cy]!='*' || map[cx+length][cy]!='*' || map[cx][cy+length]!='*' || map[cx][cy-length]!='*') {
                break;
            }
            visited[cx][cy] = true;
            visited[cx-length][cy] = true; visited[cx+length][cy] = true;
            visited[cx][cy-length] = true; visited[cx][cy+length] = true;
            list.add(new int[] {cx+1,cy+1,length++});
            cnt++;
        }
    }
}
// 3 3
// *.*
// .*.
// *.*