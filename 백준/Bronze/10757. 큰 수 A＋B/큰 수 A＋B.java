import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        BigInteger bg = new BigInteger(st.nextToken());
        BigInteger bg2 = new BigInteger(st.nextToken());
        System.out.println(bg.add(bg2));
    }
}
