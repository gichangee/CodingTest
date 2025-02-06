import java.io.*;
import java.util.*;

public class Main {
    
    static long[][] arr = {{1,1},{1,0}};
    
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        System.out.println(method(n));
    }
    
    private static long method(long n){
        if(n == 1 || n == 0){
            return n;
        }else{
            arr = power(arr,n-1);
            return arr[0][0];
        }
    }
    
    private static long[][] power(long[][] arr, long n){
        
        if(n == 1){
            return new long[][] {{1,1},{1,0}};
        }else{
            long[][] answer = new long[arr.length][arr.length];
            answer= power(arr,n/2);
            
            answer = multi(answer ,answer );
            
             if(n % 2 != 0){
                answer = multi(answer ,arr); 
            }
            return answer;
        }
    }
    
    private static long[][] multi(long[][] a, long[][] arr){
        long[][] temp = new long[a.length][a.length];
        for(int i=0;i<a.length;i++){
            for(int j = 0;j<a.length;j++){
                for(int k=0;k<a.length;k++){
                    temp[i][j] = ((temp[i][j]%1000000) + (( a[i][k] * arr[k][j]) %1000000))%1000000;
                }
            }
            
        }
        
        return temp;
    }
}
