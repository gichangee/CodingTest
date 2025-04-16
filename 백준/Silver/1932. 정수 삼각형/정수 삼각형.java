import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer (br.readLine());
            arr[i] = new int[i+1];
            for(int j = 1;j<=i;j++){
                arr[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        
    
        for(int i=1;i<n;i++){
            for(int j = 1;j<arr[i+1].length;j++){
                if(j==1){
                    arr[i+1][j] += arr[i][j];
                }else if(j==i+1){
                    arr[i+1][j] += arr[i][j-1];
                }else{
                    arr[i+1][j] += Math.max(arr[i][j-1], arr[i][j]);
                }
            }
        }
        
        int max = 0;
        for(int i=1;i<=n;i++){
            if(max < arr[n][i]){
                max = arr[n][i];
            }
        }
        System.out.println(max);
        
       

        
    }
}
