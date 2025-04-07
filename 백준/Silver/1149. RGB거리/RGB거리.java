import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][3];
        int[][] store = new int[N+1][3];
        store[0][0] = 0;
        store[0][1] = 0;
        store[0][2] = 0;
        
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=1;i<=N;i++){
            store[i][0] = Math.min(store[i-1][1], store[i-1][2]) + arr[i][0];
            store[i][1] = Math.min(store[i-1][0], store[i-1][2]) + arr[i][1];
            store[i][2] = Math.min(store[i-1][0], store[i-1][1]) + arr[i][2];
        }
        

        
        System.out.println(Math.min(Math.min(store[N][0],store[N][1]),store[N][2]));
        
    }
}
