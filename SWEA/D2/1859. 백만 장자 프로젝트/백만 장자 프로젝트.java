import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            long answer = 0;
            int[] arr = new int[n];
            
            // 입력 받기
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int maxPrice = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (maxPrice < arr[i]) {
                    maxPrice = arr[i];
                }
                answer += (maxPrice - arr[i]);
            }
            
            // 결과 출력
            System.out.println("#" + test_case + " " + answer);
        }
    }
}