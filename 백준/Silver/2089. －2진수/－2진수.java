import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        if(N == 0){
            System.out.println(0);
            return;
        }
        
        while (N != 1){
           sb.append(Math.abs(N % -2));

           N = (int)(Math.ceil((double)N/-2));
        }
        sb.append(N);
        
        System.out.println(sb.reverse());
    }
}