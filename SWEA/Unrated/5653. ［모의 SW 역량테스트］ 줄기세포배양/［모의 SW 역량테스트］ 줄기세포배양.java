import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution {
 
    static class Cell{
        int x,y;
        int status;
        Cell next;
        public Cell(int x, int y , int status, Cell next){
            this.x=x;
            this.y=y;
            this.status= status;
            this.next = next;
        }
    }
    static Cell cells[];
    static int cnt ;
    static int N,M,K;
    static int map[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int T = Integer.parseInt(st.nextToken());
        for(int t = 1;t<=T;t++){
 
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            cells = new Cell[11]; //1~10
            cnt = 0;
            map = new int[N+K][M+K];
            int start = K/2;
            for(int i =start ; i<start+N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=start; j<start+M;j++){
                    int X = Integer.parseInt(st.nextToken());
                    map[i][j]=X;
                    if(X!=0){
                        cells[X] = new Cell(i,j,2*X,cells[X]);
                        cnt++;
                    }
                }
            }
            go();
            System.out.println("#"+t+" "+cnt);
        }
    }
    public static void go(){
        for(int i=0;i<K;i++){
            for(int j=10;j>0;j--){
                for(Cell cell = cells[j];cell!=null;cell = cell.next){
                    cell.status--;
                    if(cell.status>=j){
                        continue;
                    }
 
                    if(cell.status==0){
                        cnt--;
                    }
 
                    for(int a=0;a<4;a++){
                        int x = cell.x+dx[a];
                        int y = cell.y+dy[a];
                        if(map[x][y]==0){
                            cnt++;
                            map[x][y] = j;
                            cells[j] = new Cell(x,y,2*j,cells[j]);
                        }
                    }
                }
            }
        }
    }
}