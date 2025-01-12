import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        System.out.println(gcd(a,b));
        System.out.println(lcm(a,b));
    }
    private static int gcd(int a, int b){
        if(a%b == 0){
            return b;
        }else{
            return gcd(b,a%b);
        }
    }
    private static int lcm(int a, int b){
        return a*b / gcd(a,b);
    }
}
