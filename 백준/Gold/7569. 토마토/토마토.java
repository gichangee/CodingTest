import java.io.*;
import java.util.*;

public class Main {
    
    private static int[][][] arr;
    private static boolean[][][] visited;
    private static int[] dy = {-1,1,0,0};
    private static int[] dx = {0,0,-1,1};
    private static int[] dz = {-1,1};
    private static int N,M,H;
    
    private static Queue<int[]> q;
    
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[N][M][H];
        visited = new boolean[N][M][H];
        
        q = new LinkedList<>();
        
        for(int k = 0;k<H;k++){
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<M;j++){
                    int result = Integer.parseInt(st.nextToken());
                    arr[i][j][k] = result;
                    
                    if(result == 1){
                        q.add(new int[]{i,j,k,0});
                        visited[i][j][k] = true;
                    }
                    
                    if(result == -1){
                        visited[i][j][k] = true;
                    }
                }
            } 
        }
        
        int count = method();
        
         for(int k = 0;k<H;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(arr[i][j][k] == 0){
                        System.out.println("-1");
                        return;
                    }
                }
            } 
        }
        
        System.out.println(count);
        
    }
    
    private static int method(){
        
        int count =0;
        while(!q.isEmpty()){
            int[] temp = q.poll();
            
            int goZ = dz[0] + temp[2];
            int goZ2 = dz[1] + temp[2];
            
            count = Math.max(count,temp[3]);
               
            if(goZ >= 0 && goZ <H){
                if(!visited[temp[0]][temp[1]][goZ]){
                        arr[temp[0]][temp[1]][goZ] = 1;
                        visited[temp[0]][temp[1]][goZ] = true;
                        q.add(new int[]{temp[0],temp[1],goZ,temp[3]+1});
                }
            }
                
            if(goZ2 >= 0 && goZ2 <H){
                if(!visited[temp[0]][temp[1]][goZ2]){
                        arr[temp[0]][temp[1]][goZ2] = 1;
                        visited[temp[0]][temp[1]][goZ2] = true;
                        q.add(new int[]{temp[0],temp[1],goZ2,temp[3]+1});
                }
            }
 
            for(int i=0;i<4;i++){
                int goY = dy[i] + temp[0];
                int goX = dx[i] + temp[1];
                
                if(goY >=0 && goX>=0 && goY <N && goX <M){
                     if(!visited[goY][goX][temp[2]]){
                        arr[goY][goX][temp[2]] = 1;
                        visited[goY][goX][temp[2]] = true;
                        q.add(new int[]{goY,goX,temp[2],temp[3]+1});
                    }
                }
            }
        }
        return count;
    }
}
