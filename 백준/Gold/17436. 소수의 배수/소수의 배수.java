import java.util.*;
import java.io.*;

public class Main {
    
    static int[] temp;
    static long sum;
    static long m;
    static int[] arr;
    public static void main(String[] args) throws IOException  {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        sum = 0;
        
        for(int i=0;i<arr.length;i++){
            sum += m/arr[i];
        }
        
        if(n == 1){
            System.out.print(sum);
            return;
        }
        
        for(int i=1;i<=n;i++){
            temp = new int[i+1];
            combine(0,0,i+1);
        }
        
        System.out.print(sum);
    }
    private static void combine(int depth, int start, int end){
        if(depth == end){
            long t = 1;
            for(int i=0;i<temp.length;i++){
                t *= temp[i];
            }
            
            if(end%2==0){
                sum = sum - (m/t);
            }else{
                sum = sum + (m/t);
            }
            
        }else{
            for(int i=start;i<arr.length;i++){
                temp[depth] = arr[i];
                combine(depth+1,i+1,end);
            }
        }
        
    }
}
