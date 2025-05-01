import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            int x = sc.nextInt();
            if(x > max){
                max = x;
            }
            
            if(x < min){
                min = x;
            }
        }
        
        
        System.out.println(min + " "+ max);
    }
}
