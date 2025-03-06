import java.io.*;
import java.util.*;

public class Main {
    private static int[] dy = {-1,1,0,0};
    private static int[] dx = {0,0,-1,1};
    private static boolean[][][] visited;
    private static int[][] arr;
    private static int N,M;
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M][2];
        for(int i=0;i<N;i++){
            String s  = br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(s.charAt(j)+"");
            }
        }
        
        int count = method(0,0);
        System.out.println(count);
    }
    
    private static int method(int starty, int startx){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{starty, startx,1,1});
        while(!q.isEmpty()){
            int[] temp = q.poll();
            
            if(temp[0] == N-1 && temp[1] == M-1){
                return temp[3];
            }
            
            for(int i=0;i<4;i++){
                int goY = dy[i] + temp[0];
                int goX = dx[i] + temp[1];
                if(goY >=0 && goX >=0 && goX < M && goY < N){
                    if(arr[goY][goX] == 0){
                        if(!visited[goY][goX][temp[2]]){
                            visited[goY][goX][temp[2]] = true;
                            q.add(new int[]{goY,goX,temp[2],temp[3]+1});
                        }
                    }else{
                        if(!visited[goY][goX][0] && temp[2] == 1){
                            visited[goY][goX][0] = true;
                            q.add(new int[]{goY,goX,0,temp[3]+1});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
