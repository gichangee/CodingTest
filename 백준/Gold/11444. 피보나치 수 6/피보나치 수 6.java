import java.io.*;
import java.util.*;

public class Main {
    
    private static long[][] arr = {{1,1},{1,0}};
    
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        
        System.out.println(method(n));
    }
    
    private static long method(long n){
        if(n == 0 || n ==1){
            return n;
        }else{
            arr = power(arr,n-1);
            return arr[0][0];
        }
    }
    
    private static long[][] power(long[][] arr, long n){
        
       
        
        long[][] base = {{1, 1}, {1, 0}};
        
        if(n == 0){
            return new long[][]{{1,0},{0,1}};
        }
        
        if(n == 1){
            return base;
        }
        
        arr = power(arr, n/2);
        
        arr = multi(arr,arr);
        
        if(n%2 != 0){
            arr = multi(arr,base);
        }
        
        return arr;
    }
    
    private static long[][] multi(long[][] arr, long[][] base){
        
        long[][] temp = new long[2][2];
        
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<2;k++){
                    temp[i][j] = ((temp[i][j])%1000000007 + (arr[i][k] * base[k][j])%1000000007)%1000000007;
                }
            }
        }
        return temp;
    }
}
