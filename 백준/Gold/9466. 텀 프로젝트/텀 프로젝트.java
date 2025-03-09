import java.io.*;
import java.util.*;

public class Main {
    
    private static int n,person;
    private static int[] arr;
    private static boolean[] visited;
    private static boolean[] isFinished;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t = 1; t<=T;t++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            arr = new int[n+1];
            visited = new boolean[n+1];
            isFinished= new boolean[n+1];
            person = n;
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            } 
            
            
            for(int i=1;i<=n;i++){
                if(!visited[i]){
                    bfs(i);
                }
            }
            
            
            System.out.println(person);
            
                                                
            
        }
    }
    
    
    private static void bfs(int cur){
        visited[cur] = true;
        int next = arr[cur];
        
        if(!visited[next]){
            bfs(next);
        }else if(!isFinished[next]){
            int temp = next;
            int count = 1;
            
            while(temp != cur){
                temp = arr[temp];
                count++;
            }
            
            person = person -count;
            
        }
        
        isFinished[cur] = true;
        
        
    }
}
