import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력을 읽기 위한 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 한 줄을 읽고 공백으로 나눈다
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 두 개의 BigInteger 생성
        BigInteger bg = new BigInteger(st.nextToken());
        BigInteger bg2 = new BigInteger(st.nextToken());
        
        // 곱셈 수행 및 출력
        System.out.println(bg.multiply(bg2));
    }
}
