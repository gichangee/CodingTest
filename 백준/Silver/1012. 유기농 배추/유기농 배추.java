import java.io.*;
import java.util.*;

public class Main {
    
    
    private static int M,N,K;
    private static int[][] arr;
    private static boolean[][] visited;
    
    private static int[] dy ={-1,1,0,0};
    private static int[] dx = {0,0,-1,1};
    
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
       
        
        for(int i=1;i<=T;i++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N][M];
            visited = new boolean[N][M];
            for(int j=0;j<K;j++){
               st = new StringTokenizer(br.readLine());
               int X = Integer.parseInt(st.nextToken());
               int Y = Integer.parseInt(st.nextToken());
               arr[Y][X] = 1;
            }
            int sum = 0;
            
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    if(!visited[j][k] && arr[j][k] == 1){
                        visited[j][k] = true;
                        sum++;
                        method(j,k);
                    }
                }
            }
            System.out.println(sum);
        }
    }
    
    private static void method(int starty,int startx){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{starty, startx});
        while(!q.isEmpty()){
            int[] temp = q.poll();
            for(int i=0;i<4;i++){
                int goY = dy[i] + temp[0];
                int goX = dx[i] + temp[1];
                if(goY >=0 && goX >=0 && goY< N && goX < M){
                    if(!visited[goY][goX]){
                        if(arr[goY][goX] == 1){
                            visited[goY][goX] = true;
                            q.add(new int[]{goY,goX});
                        }
                    }
                }
            }
        }
    }
}
