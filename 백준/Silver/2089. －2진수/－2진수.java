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
          if(N < 0){
            sb.append(Math.abs(N%-2));
            if((N%-2) != 0){
                N = N / -2;
                N++;
            }else{
                N = N / -2;
            }
          }else{
            sb.append(Math.abs(N%-2));
             N = N /-2;
          }
        }
        
        sb.append(1);
        System.out.println(sb.reverse());
    }
}