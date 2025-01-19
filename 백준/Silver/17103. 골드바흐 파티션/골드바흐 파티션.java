import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        
        boolean[] prime = new boolean[1000001];
        Arrays.fill(prime,true);
        
        prime[0] = false;
        prime[1] = false;
        
        for(int i = 2;i<=Math.sqrt(1000000);i++){
            for(int j = i*i;j<=1000000;j=j+i){
                prime[j]= false;
            }
        }
        
        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            int count = 0;
            for(int j=2;j<=((double)N/2);j++){
                if(prime[j] && prime[N-j]){
                    count++;
                }
            }
            
            System.out.println(count);
            
            
        }
    }
}
