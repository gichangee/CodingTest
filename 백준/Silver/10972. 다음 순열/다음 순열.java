import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int step1 = -1;
        
        for(int i=N-1;i>=1;i--){
            if(arr[i] > arr[i-1]){
                step1 = i-1;
                break;
            }else{
                continue;
            }
        }


        if(step1 == -1){
            System.out.println(step1);
            return;
        }     
        
        int step2 = -1;
        
        for(int i=N-1;i>=0;i--){
            if(arr[step1] < arr[i]){
                step2 = i;
                break;
            }else{
                continue;
            }
        }
        
        int step3 = 0;
        
        step3 = arr[step1];
        arr[step1] = arr[step2];
        arr[step2] = step3;


       
        for(int i=step1+1; i< N - 1;i++){
            int temp = 0;
            int start = step1 + 1;
            while(arr[start] > arr[start+1]){
                temp = arr[start];
                arr[start] = arr[start+1];
                arr[start+1] = temp;
                start++;
                if(start == N-1){
                    break;
                }
            }
        }
        
        for(int i : arr){
            System.out.print(i+" ");
        }


           
        
    }
}
