import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        if(N == 1){
            return;
        }
        
        boolean[] prime= new boolean[N+1];
        
        Arrays.fill(prime,true);
        prime[0] = false;
        prime[1] = false;
        
        for(int i = 2; i<= Math.sqrt(N);i++){
            for(int j = i*i;j<=N;j=j+i){
                prime[j] = false;
            }
        }
        
        while(N != 1){
            for(int i=2;i<=prime.length;i++){
                if(prime[i]){
                    if(N % i == 0){
                        System.out.println(i);
                        N = N/i;
                        break;
                    }
                }
            }
        }        
        
        
    }
}
