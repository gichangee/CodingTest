import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[] store;
    static int[] arr;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        store = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }
        method(0);
        System.out.println(max);
    }
    
    private static void method(int depth){
        if(depth == N){
            int sum = 0;
            for(int i=0;i<N-1;i++){
                   sum+=Math.abs(store[i] - store[i+1]);
            }
            
            if(max < sum){
                max = sum;
            }
        }else{
            for(int i=0;i<N;i++){
                if(!visited[i]){
                    visited[i] = true;
                    store[depth] = arr[i];
                    method(depth+1);
                    visited[i] = false;
                }
            }
        }
    }
}
