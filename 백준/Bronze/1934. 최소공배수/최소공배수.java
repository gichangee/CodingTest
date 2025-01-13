import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        int[] arr = new int[2];
        for(int i=0; i < T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            System.out.println(lcm(A,B));
        }
    }
    
    
    public static int gcd(int a, int b){
        if(a%b==0){
            return b;
        }else{
            return gcd(b,a%b);
        }
    }
    
    public static int lcm(int a, int b){
        return a*b / gcd(a,b);
    }
}
