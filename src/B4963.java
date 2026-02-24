import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class B4963 {
    static int[][] direction = new int[][] {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String[] input = br.readLine().split(" ");
            int col = Integer.parseInt(input[0]); // 너비
            int row = Integer.parseInt(input[1]); // 높이
            int cnt=0; // 섬의 개수
            if(col==0 && row ==0) {
                break;
            }
            int[][] map = new int[row][col];
            boolean[][] visited = new boolean[row][col];
            for(int i=0;i<row;i++) {
                input = br.readLine().split(" ");
                for(int j=0;j<col;j++) {
                    int info = Integer.parseInt(input[j]);
                    map[i][j] = info;
                    visited[i][j] = false;
                }
            }
            for(int i=0;i<row;i++) {
                for(int j=0;j<col;j++) {
                    if(!visited[i][j] && map[i][j]==1) {
                        dfs(map,i,j,visited,row,col);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int[][] map, int xindex, int yindex, boolean[][] visited, int row, int col) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {xindex,yindex});
        visited[xindex][yindex] = true;
        while(!deque.isEmpty()) {
            int[] current = deque.getFirst();
            deque.removeFirst();
            int cx = current[0];
            int cy = current[1];
            for(int i=0;i<8;i++) {
                int nx = cx+direction[i][0];
                int ny = cy+direction[i][1];
                if(nx>=0 && nx<row && ny>=0 && ny<col && !visited[nx][ny] && map[nx][ny]==1) {
                    visited[nx][ny] = true;
                    deque.addLast(new int[] {nx,ny});
                } 
            }
        }
    }
}
