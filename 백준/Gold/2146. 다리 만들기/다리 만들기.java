import java.io.*;
import java.util.*;

public class Main {
    
    private static int N,land = 2;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int[] dy = {-1,1,0,0};
    private static int[] dx = {0,0,-1,1};
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0){
                    visited[i][j] = true;
                }
            }
        }
        
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j] && arr[i][j] == 1){
                    visited[i][j] = true;
                    method(i,j);
                    land++;
                }
            }
        }
        
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                boolean side = false;
                
                if(arr[i][j] == 0){
                    continue;
                }
                
                for(int k=0;k<4;k++){
                    int goY = dy[k] + i;
                    int goX = dx[k] + j;
                    if(goY >=0 && goX >=0 && goY < N && goX <N){
                        if(arr[i][j] != 0 && arr[goY][goX] == 0){
                            side = true;
                            break;
                        }
                    }
                }
                if(side){   
                    method2(i,j,arr[i][j]);
                }  
            }
         } 
        
        /*
            for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(memo[i][j]+" ");
            }
            System.out.println();
        }
        */
        
        
        
        System.out.println(min);
    }
    
    private static void method(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});
        arr[y][x] = land;
        
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            for(int i=0;i<4;i++){
                int goY = temp[0] + dy[i];
                int goX = temp[1] + dx[i];
                if(goY >=0 && goX >=0 && goY < N && goX <N){
                    if(!visited[goY][goX] && arr[goY][goX] == 1){
                        arr[goY][goX] = land;
                        visited[goY][goX] = true;
                        q.add(new int[]{goY,goX});
                    }
                }
            }
        }
    }
    
    private static void method2(int y,int x, int landValue){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x,0});
        
        boolean[][] check = new boolean[N][N];
        
        while(!q.isEmpty()){
            int[] temp = q.poll(); 
              
            for(int i=0;i<4;i++){
                int goY = temp[0] + dy[i];
                int goX = temp[1] + dx[i];
                
                if(min > temp[2]){

                    if(goY >=0 && goX >=0 && goY < N && goX <N){
                        
                        if(arr[goY][goX] == 0 && !check[goY][goX]){
                            check[goY][goX] = true;
                            q.add(new int[]{goY,goX,temp[2]+1});
                        }else if(arr[goY][goX] != landValue && arr[goY][goX] !=0){
                            if(min > temp[2]){
                                min = temp[2];
                            }
                            return;
                        }
                    }
                }
            }
        }
    }
}
