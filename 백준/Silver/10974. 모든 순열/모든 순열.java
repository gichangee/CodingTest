import java.util.*;
import java.io.*;

public class Main {
    
    static int N;
    static int[] arr;
    static int[] store;
    static boolean[] visited;
    
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr  = new int[N];
        visited= new boolean[N];
        for(int i=0;i<N;i++){
            arr[i] = i+1;
        }
        
        store = new int[N];
        
        method(0);
    }
    
    private static void method(int depth){
        if(N == depth){
          for(int i=0;i<store.length;i++){
            System.out.print(store[i] +" ");    
          }  
          System.out.println();
        }else{
            for(int i=0;i<N;i++){
                if(!visited[i]){
                    visited[i]=true;
                    store[depth] = arr[i];
                    method(depth+1);
                    visited[i]=false;
                }
            }
        }
    }
}
