import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        long[] arr = new long[101];
        
        arr[1] = 1l;
        arr[2] = 1l;
        arr[3] = 1l;
        
        for(int i=4;i<=100;i++){
            arr[i] = arr[i-2] + arr[i-3];
        }
        
        
        for(int i=0;i<T;i++){
            int n = sc.nextInt();
            System.out.println(arr[n]);
            
        }
    }
}
