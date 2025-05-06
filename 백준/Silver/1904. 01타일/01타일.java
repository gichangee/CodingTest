import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[1000001];
        /*
        
        dp[1] = 1
        dp[2] = 2
        dp[3] = 3
        dp[4] = 5

        
        */
        
        dp[1]= 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;
        
        if(N<=4){
            System.out.println(dp[N]);
            return;
        }
        
        for(int i=5;i<=1000000;i++){
            dp[i] = (dp[i-1]+ dp[i-2])%15746;
        }
        
        System.out.println(dp[N]);
    }
}
