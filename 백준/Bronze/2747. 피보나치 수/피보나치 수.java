import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] arr = new int[46];
        arr[0]= 0;
        arr[1] = 1;
        for(int i=2;i<=45;i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        
        System.out.println(arr[n]);
    }
   
}
