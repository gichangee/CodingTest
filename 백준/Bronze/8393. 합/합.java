import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = 0;
        for(int i=1; i<=n;i++){
            sum += i;
        }
        System.out.println(sum);
        
    }
}
