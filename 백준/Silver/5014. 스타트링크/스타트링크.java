import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        
        if(G == S){
            System.out.println(0);
            return;
        }
        
        boolean[] visited = new boolean[F+1];
        
        visited[S] = true;
        visited[0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{S,0});
        while(!q.isEmpty()){
            int[] temp = q.poll();
            
            if(temp[0] == G){
                System.out.println(temp[1]);
                return;
            }
            
            int goU = temp[0] + U;
            int goD = temp[0] - D;
            if(goU <=F && goU >=1){
                if(!visited[goU]){
                    visited[goU] = true;
                    q.add(new int[]{goU,temp[1]+1});
                }
            }
            
             if(goD <=F && goD >=1){
                if(!visited[goD]){
                    visited[goD] = true;
                    q.add(new int[]{goD,temp[1]+1});
                }
            }
        }
        
                
        
        
        System.out.println("use the stairs");
        
        
    }
}
