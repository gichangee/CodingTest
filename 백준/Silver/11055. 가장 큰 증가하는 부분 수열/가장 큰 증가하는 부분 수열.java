import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int[] arr = new int[A];
        int[] dp = new int[A];
         for (int i = 0; i < A; i++) {
            arr[i] = sc.nextInt();
            dp[i] = arr[i]; 
        }

        

        for(int i=0;i<A;i++){
            for(int j=0;j<i;j++){
                if(arr[j] < arr[i]){
                   dp[i]= Math.max(dp[i], arr[i] + dp[j]);
                }
            }
        }
       
        int max =Integer.MIN_VALUE;
        
        for(int i=0;i<A;i++){
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
        
        
    }
}
