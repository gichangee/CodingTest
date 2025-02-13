import java.io.*;
import java.util.*;

public class Main {
    
    private static boolean[] visited;

    private static List<Integer> list[];
    
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i< M;i++){
            st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                list[x].add(y);
                list[y].add(x);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }
        
        dfs(start);
        Arrays.fill(visited, false);
        System.out.println();
        bfs(start);
        
    }
    
    private static void dfs(int start){
        visited[start] = true;
        System.out.print(start + " ");
        for(int x : list[start]){
            if(!visited[x]){
                dfs(x);
            }
        }
    }
    
    private static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int x = q.poll();
            System.out.print(x + " ");
            for(int i=0;i<list[x].size();i++){
                if(!visited[list[x].get(i)]){
                    visited[list[x].get(i)] = true;
                     q.add(list[x].get(i));
                }
               
            }
        }
    }
}
