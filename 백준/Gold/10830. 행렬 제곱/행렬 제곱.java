import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        
        long[][] arr = new long[N][N];
        long[][] answer = new long[N][N];
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Long.parseLong(st.nextToken()) % 1000;
            }
        }
        
        answer = method(arr,B);
        
         for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }
        
    }
    
    private static long[][] method(long[][] arr, long B){
        if(B == 1){
            return arr;
        }else{
            long[][] answer = new long[arr.length][arr.length];
            answer = method(arr, B/2);
            
            answer = multi(answer ,answer);
            
            if(B % 2 != 0){
                answer = multi(answer ,arr); 
            }
            return answer;
        }
    }
    private static long[][] multi(long[][] a, long[][] arr){
        long[][] answer = new long[a.length][a.length];
        
        for(int i=0;i<a.length;i++){
            for(int j = 0;j<a.length;j++){
                for(int k=0;k<a.length;k++){
                    answer[i][j] = ((answer[i][j]) + (a[i][k] * arr[k][j]) %1000)%1000;
                    
                }
            }
            
        }
        return answer;
    }
}