import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int r = K;
        if(K == 0 || K==N){
            System.out.println(1);
            return;
        }
        
    
        
      long result = 1;
        // 조합 공식: C(N, K) = N! / (K! * (N-K)!)
        // 분자: N * (N-1) * ... * (N-K+1)
        for (int i = 0; i < K; i++) {
            result *= (N - i);
            result /= (i + 1);  // K!에 해당하는 부분 나누기
        }
        
        System.out.println(result);
    }
}
