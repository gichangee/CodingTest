import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int N = 0;

        int[] arr = new int[M];

        for (int i = 0; i < M; i++) {
            int count = 0;
            count = Integer.parseInt(st.nextToken());
            arr[i] = count;
            N += count;

        }

        st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());

        if (K == 1) {
            System.out.println("1.0");
            return;
        }

        BigInteger bunja= new BigInteger("1");
        long count = K;
        while (count != 0) {
            bunja = bunja.multiply(BigInteger.valueOf(N));
            N--;
            count--;
        }

        BigInteger bunmo = BigInteger.ONE;
        for (int i = K; i >= 1; i--) {
            bunmo = bunmo.multiply(BigInteger.valueOf(i));
        }

        BigInteger totalcount = BigInteger.ZERO;

        totalcount = bunja.divide(bunmo);

        BigInteger successcount = BigInteger.ZERO;

        for (int i = 0; i < M; i++) {
            bunja = BigInteger.ONE;;
            count = K;
            while (count != 0) {
                bunja = bunja.multiply(BigInteger.valueOf(arr[i]));
                arr[i]--;
                count--;
            }

            bunmo = BigInteger.ONE;
            for (int j = K; j >= 1; j--) {
                bunmo = bunmo.multiply(BigInteger.valueOf(j));
            }

            successcount = successcount.add(bunja.divide(bunmo));
        }


        BigDecimal successDecimal = new BigDecimal(successcount);
        BigDecimal totalDecimal = new BigDecimal(totalcount);
        BigDecimal result = successDecimal.divide(totalDecimal, 15, RoundingMode.HALF_EVEN);


        System.out.println(result);


    }
}
