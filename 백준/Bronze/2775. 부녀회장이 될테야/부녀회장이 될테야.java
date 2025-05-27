import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        
        

        
        int[][] arr = new int[15][15];
        for(int i=1;i<15;i++){
            arr[0][i] = i;  
        }
        
        for(int i=1;i<15;i++){
            for(int j=1;j<15;j++){
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        
        
        for(int t=0;t<T;t++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine()); 
            System.out.println(arr[k][n]);
        }
    }
}
