import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] len = new int[N];
         
        for(int i=0;i<N;i++){
          len[i] = Math.abs(S-arr[i]);
        }
        
        System.out.println(method(len));
        
    }
    
    private static int gcd(int a, int b){
        if(a%b ==0){
            return b;
        }else{
            return gcd(b, a%b);
        }
    }
    
    private static int method(int[] len){
        int first = len[0];
        for(int i=1;i<len.length;i++){
            first = gcd(first,len[i]);
        }
        return first;
    }
}
