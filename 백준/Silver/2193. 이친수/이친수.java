import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        long[] arr = new long[91];
        
        arr[0]=0l;
        arr[1]=1l;
        arr[2]=1l;
        arr[3]=2l;
        
        for(int i=4;i<=n;i++){
            arr[i] = arr[i-1]  + arr[i-2];
        }
        System.out.println(arr[n]);
        
        
        
        /*
        n = 1 -> 1
        n = 2 -> 1
        n = 3 -> 2
        n = 4 -> 3
                1010
                1001
                1000
        n = 5 -> 10000
                 10100
                 10010
                 10001
                 10101
       n = 6 -> 100000
                101000
                100100
                100010
                100001
                101010
                101001
                100101

        */
    }
}
