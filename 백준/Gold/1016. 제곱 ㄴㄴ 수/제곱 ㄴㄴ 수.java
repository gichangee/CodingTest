import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong(); 
        long max = sc.nextLong(); 

        long count = max - min + 1;
        boolean[] check= new boolean[(int) count];


        for (long i = 2; i * i <= max; i++) {
            long num= i * i;
            long start =min/num;
            long end = max / num;
            for (long j = start; j <= end; j++) {
                if(j*num <= max &&j*num >= min&&!check[(int)(j*num-min)]){
                    check[(int)(j*num-min)] = true;
                }
            }
        }

        long result = 0;
        for (boolean value : check) {
            if (!value) result++;
        }

        System.out.println(result);
    }
}
