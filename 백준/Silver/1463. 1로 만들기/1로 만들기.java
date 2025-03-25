import java.io.*;
import java.util.*;

public class Main {
    
    private static int N;
    private static int[] arr;
    
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N+1];
        
        Arrays.fill(arr,Integer.MAX_VALUE);
        
        int count = method();
        System.out.println(count);
    }
    private static int method(){
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        q.add(new int[]{N,0});
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            
            if(temp[0] == 1){
                return temp[1];
            }
            
            if(temp[0] % 3 == 0 && arr[temp[0]/3] > temp[1]+1){
                arr[temp[0]/3] = temp[1]+1;
                q.add(new int[]{temp[0]/3,temp[1]+1});
            }
            
            if(temp[0] % 2 == 0 && arr[temp[0]/2] > temp[1]+1){
                arr[temp[0]/2] = temp[1]+1;
                q.add(new int[]{temp[0]/2,temp[1]+1});
            }
            
            if(temp[0] -1 >0 && arr[temp[0]-1] > temp[1]+1){
                arr[temp[0]-1] = temp[1]+1;
                q.add(new int[]{temp[0]-1,temp[1]+1});
            }
            
            
            
        }
        
        return -1;
        
        
        
        
    }
    
}
