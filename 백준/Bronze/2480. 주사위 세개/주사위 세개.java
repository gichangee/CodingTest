import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        
        int sum = 0;
        
        if(A == B && A == C){
            sum = 10000 + A * 1000;
        }else if(A != B && A != C && B != C){
            
            sum = Math.max(Math.max(A,B),C);
            sum = sum * 100;
        }else{
            if(A == B){
                sum = 1000 + A * 100;
            }else if(A==C){
                 sum = 1000 + A * 100;
            }else{
                 sum = 1000 + B * 100;
            }
        }
        
        System.out.println(sum);
        
    }
}
