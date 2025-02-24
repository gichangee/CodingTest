import java.io.*;
import java.util.*;

public class Main {
    
    
    private static char[][] arr;
    private static int N;
    private static boolean[][] visited;
    private static int[] dy = {-1,1,0,0};
    private static int[] dx = {0,0,-1,1};
    
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr= new char[N][N];
        visited = new boolean[N][N];
        
        for(int i=0;i<N;i++){
            String s = br.readLine();
            arr[i] = s.toCharArray();
        }
        
        int sum =0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    method(i,j);
                    sum++;
                }
            }
        }
        
        System.out.print(sum+" ");
        
         for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                visited[i][j] = false;
                if(arr[i][j] == 'G'){
                    arr[i][j] = 'R';
                }
            }
        }
        
        sum =0;
         for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    method(i,j);
                    sum++;
                }
            }
        }
        
        System.out.println(sum);
        
        
    }
    private static void method(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});
        while(!q.isEmpty()){
            int[] temp = q.poll();
            for(int i=0;i<4;i++){
                int goY = temp[0] + dy[i];
                int goX = temp[1] + dx[i];
                if(goY >=0 && goX >=0 && goX < N & goY <N){
                    if(!visited[goY][goX]){
                        if(arr[temp[0]][temp[1]] == arr[goY][goX]){
                            visited[goY][goX] = true;
                            q.add(new int[]{goY,goX});
                        }
                    }
                }
            }
        }
    }
   
}
