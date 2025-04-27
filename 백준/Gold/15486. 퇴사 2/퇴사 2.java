import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] t = new int[N+2];
        int[] p = new int[N+2];
        int[] arr = new int[N+2];
        
        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=N;i>=1;i--){
            if(i+t[i] <= N+1){
                int max = Math.max(arr[i+1], arr[i+t[i]]+p[i]);
                arr[i] = max;
            }else{
                arr[i] = arr[i+1];
            }
        }
        
        System.out.println(arr[1]);
        
        
       
    }
}