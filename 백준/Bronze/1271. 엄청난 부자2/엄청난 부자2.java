import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger m = new BigInteger(st.nextToken()); // 생명체 수
        BigInteger n = new BigInteger(st.nextToken()); // 가진 돈

        // 한 명당 받을 금액 = n / m
        BigInteger perCreature = m.divide(n);
        // 남는 돈 = n % m
        BigInteger remaining = m.remainder(n);

        // 출력
        System.out.println(perCreature);
        System.out.println(remaining);
    }
}
