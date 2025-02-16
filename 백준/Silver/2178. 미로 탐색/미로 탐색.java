import java.io.*;
import java.util.*;

public class Main {
    
    private static int N,M;
    private static int[][] arr;
    private static int[][] memo;
    private static boolean[][] visited; 
    
    private static int[] dy = {-1,1,0,0};
    private static int[] dx = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        memo = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                arr[i+1][j+1] = s.charAt(j) - '0';
                memo[i+1][j+1] = Integer.MAX_VALUE;
            }
        }
        
        
        
        bfs(1,1);
        
        System.out.println(memo[N][M]);
        
        
    }
    
    private static void bfs(int starty, int startx){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{starty,startx});
        visited[starty][startx] = true;
        memo[1][1] = 1;
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
             
            for(int i=0;i<4;i++){
                int goY = dy[i] + temp[0];
                int goX = dx[i] + temp[1];
                
                           
                if(goY >=1 && goX >=1 && goY <=N && goX <=M){
                    if(arr[goY][goX] == 1){
                        if(!visited[goY][goX]){
                            visited[goY][goX] = true;
                             memo[goY][goX] = memo[temp[0]][temp[1]] + 1;
                             q.add(new int[]{goY,goX});
                        }
                       
                    }
                }
            }
            
        }
    }
}
