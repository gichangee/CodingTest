import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력 받기
        long n = sc.nextLong();
        
        // 피보나치 수열 계산을 위한 배열 선언
        long[] arr = new long[91];
        arr[0] = 0;
        arr[1] = 1;
        
        // 반복문으로 피보나치 수열 채우기
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        
        // 결과 출력
        System.out.println(arr[(int)n]);
    }
}