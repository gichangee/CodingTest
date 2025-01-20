import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        

        if(m ==0){
            System.out.println(0);
            return;
        }
        
        long countfive = 0;
        
        for(long i=5;i<=n;i=i*5){
            countfive += n/i;
        }
        
         long countfive2 = 0;
        
        for(long i=5;i<=m;i=i*5){
            countfive2 += m/i;
        }
        
        long countfive3 = 0;
        long a = n-m;
        
        for(long i=5;i<=a;i=i*5){
            countfive3 += a/i;
        }
        
         long counttwo = 0;
        
        for(long i=2;i<=n;i=i*2){
            counttwo += n/i;
        }
        
         long counttwo2 = 0;
        
        for(long i=2;i<=m;i=i*2){
            counttwo2 += m/i;
        }
        
        long counttwo3 = 0;
        long b = n-m;
        
        for(long i=2;i<=b;i=i*2){
            counttwo3 += b/i;
        }
        
        long fivesum = countfive - countfive2 - countfive3;
        long twosum = counttwo - counttwo2 - counttwo3;
        if(fivesum >= twosum){
            System.out.println(twosum);
        }else{
             System.out.println(fivesum);
        }
        
        

        
        
        

        
    }
}
