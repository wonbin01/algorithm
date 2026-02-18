import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class hello {
    static int[][] box;
    static int[][] direction = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int col = Integer.parseInt(input[0]);
        int row = Integer.parseInt(input[1]);
        box = new int[row][col];
        int prior = 0;
        int days=0;
        for(int i=0;i<row;i++) {
            input = br.readLine().split(" ");
            for(int j=0;j<col;j++) {
                box[i][j] = Integer.parseInt(input[j]);
                if(box[i][j]==1) prior++;
            }
        }
        while(true) {
            int current=0;
            for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(box[i][j]==1) { //익은 토마토인 경우
                    bfs(i,j,row,col);
                }
            }
        }
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(box[i][j]==1) {
                    current++;
                }
            }
        }
        if(current==prior && current!=row*col) {
            System.out.println(0);
            break;
        }
        prior=current;
        days++;
        if(current==row*col) break;
        }
        System.out.println(days);
    }
    static void bfs(int x, int y, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            for(int i=0;i<4;i++) {
                int nx = cx + direction[i][0];
                int ny = cy + direction[i][1];
                if(nx>=0 && nx<row && ny>=0 && ny<col && box[nx][ny]==0) {
                    box[nx][ny]=1;
                    queue.add(new int[]{nx,ny});
                }
            }
        }
    }
}