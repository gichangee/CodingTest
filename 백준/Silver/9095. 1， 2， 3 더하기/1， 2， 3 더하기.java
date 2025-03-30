import java.io.*;
import java.util.*;

public class Main {
    private static int[] store,arr;
    private static int n,c;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int T = Integer.parseInt(s);
        
        arr = new int[3];
    
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        for(int t = 1; t<=T;t++){
            s = br.readLine();
            n = Integer.parseInt(s);
            c= 0;
            for(int i=1;i<=n;i++){
                store = new int[i];
                method(0,i);
            }
            
            System.out.println(c);
            
        }
    }
    private static void method(int depth, int r){
        if(depth == r){
            int sum = 0;
            for(int i=0;i<store.length;i++){
                sum+=store[i];
            }
            
            if(sum == n){
                c++;
            }     
            
        }else{
            for(int i=0;i<3;i++){
                store[depth] = arr[i];
                method(depth+1,r);
            }
        }
    }
    
}
