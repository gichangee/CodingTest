import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] prime = new boolean[N+1];
        
        for(int i=0;i<=N;i++){
            prime[i] = true;
        }
        
        prime[0] = false;
        prime[1] = false;
      
        for(int i=2;i<=Math.sqrt(N);i++){
            if(prime[i]){
                for(int j = i*i;j<=N;j=j+i){
                    prime[j] = false;
                }
            }
        }
        
        for(int i=2;i<M;i++){
            prime[i] = false;
        }
        
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<=N;i++){
            if(prime[i]){
                 sb.append(i+"\n");
            }
        }
        System.out.println(sb.toString());
    }
}
