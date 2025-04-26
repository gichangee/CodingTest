import java.io.*;
import java.util.*;

/*
오늘 상담을 할지, 안 할지 결정해야 해.

오늘 상담을 하면:

상담 끝난 다음 날부터 다시 돈을 벌 수 있어.

→ 오늘 벌 돈 + 나중에 벌 수 있는 돈을 더해.

오늘 상담을 안 하면:

그냥 내일부터 버는 돈만 생각해.

둘 중 더 많이 버는 쪽을 고르면 돼!


*/
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] t = new int[N+2];
        int[] p = new int[N+2];
        int[] arr = new int[N+2];
        
        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=N;i>=1;i--){
            if(i+t[i] <= N+1){
                int max = Math.max(arr[i+1], arr[i+t[i]]+p[i]);
                arr[i] = max;
            }else{
                arr[i] = arr[i+1];
            }
        }
        
        System.out.println(arr[1]);
        
        
       
    }
}
