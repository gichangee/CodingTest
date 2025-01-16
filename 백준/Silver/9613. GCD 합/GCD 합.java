import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for(int j= 0;j<n;j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            long sum = 0;
            for(int j= 0;j<n;j++){
                for(int k=j+1;k<n;k++){
                    sum += gcd(arr[j],arr[k]);
                }    
           }
           System.out.println(sum);
        }
    }
    
    private static int gcd(int a, int b){
        if(a % b == 0){
            return b;
        }else{
            return gcd(b,a%b);
        }
    }
}
