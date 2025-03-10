import java.io.*;
import java.util.*;

public class Main {
    private static int[] dy ={-1,-2,-2,-1,1,2,2,1};
    private static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    
    private static int[] my = {-1,1,0,0};
    private static int[] mx = {0,0,-1,1};
    
    private static int K,W,H;
    private static int[][] arr;
    private static boolean[][][] visited;
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        arr = new int[H][W];
        visited = new boolean[H][W][K+1];
        for(int i=0;i<H;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<W;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<K;i++){
            visited[0][0][i] = true;
        }
     
        System.out.println(bfs(0,0,K));
        
    }
    
    private static int bfs(int starty,int startx,int count){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{starty,startx,count,0});
        while(!q.isEmpty()){
            int[] temp = q.poll();
            
            if(temp[0] == H-1 && temp[1] == W-1){
                return temp[3];
            }
            
            if(temp[2] > 0){
                 for(int i=0;i<8;i++){
                    int goY = dy[i] + temp[0];
                    int goX = dx[i] + temp[1];
                    if(goY >=0 && goX >=0 && goY < H && goX < W){
                        if(!visited[goY][goX][temp[2]-1]){
                            if(arr[goY][goX] == 0){
                                visited[goY][goX][temp[2]-1] = true;
                                q.add(new int[]{goY,goX,temp[2]-1,temp[3]+1});
                            }
                          
                        }
                    }
                }
            }
            for(int i=0;i<4;i++){
                    int goY = my[i] + temp[0];
                    int goX = mx[i] + temp[1];
                    if(goY >=0 && goX >=0 && goY < H && goX < W){
                        if(!visited[goY][goX][temp[2]]){
                            if(arr[goY][goX] == 0){
                                visited[goY][goX][temp[2]] = true;
                                q.add(new int[]{goY,goX,temp[2],temp[3]+1});
                            }
                        }
                    }
            }
 
        }
        return -1;
    }
}
