import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] store;
    static int k;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0){
                break;
            }else{
                arr = new int[k];
                store = new int[6];
                sb = new StringBuilder();
                for(int i=0;i<k;i++){
                    arr[i] = Integer.parseInt(st.nextToken());
                }
                
                method(0,0);
                
                System.out.println(sb.toString());
                
            }
        }
    }
    
    private static void method(int depth, int start){
        if(depth == 6){
            for(int i=0;i<6;i++){
                sb.append(store[i]+" ");
            }
            sb.append("\n");
        }else{
            for(int i=start; i<k;i++){
                store[depth] = arr[i];
                method(depth+1,i+1);
                
            }
        }
    }
}
