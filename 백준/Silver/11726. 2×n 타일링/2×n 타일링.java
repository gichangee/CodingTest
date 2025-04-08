import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        // 1 - > 1
        // 2 - > 2
        // 3 - > 3
        // 4 - > 5
        
        int n = sc.nextInt();
        
        int[] arr = new int[n+1];
        
        arr[1] = 1;
        if(n == 1){
            System.out.println(1);
            return;
        }
        arr[2] = 2;
        
        for(int i=3;i<=n;i++){
            arr[i] = (arr[i-1] + arr[i-2]) % 10007;
        }
        System.out.println(arr[n]);
    }
}
