import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 0kg을 만들기 위한 봉지 수는 0

        for (int i = 0; i <= N; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;

            if (i + 3 <= N) {
                dp[i + 3] = Math.min(dp[i + 3], dp[i] + 1);
            }

            if (i + 5 <= N) {
                dp[i + 5] = Math.min(dp[i + 5], dp[i] + 1);
            }
        }

        if (dp[N] == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(dp[N]);
        }
    }
}
