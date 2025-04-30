import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[][] arr = new int[N+1][10];
        
        for(int i=1;i<=9;i++){
            arr[1][i] = 1;
        }
        
        
        for(int i=2;i<=N;i++){
            for(int j=0;j<10;j++){
                
                if(j == 0){
                    arr[i][j] = (arr[i][j] + arr[i-1][j+1])% 1000000000;
                    continue;
                }
                
                if(j==9){
                    arr[i][j] = (arr[i][j] + arr[i-1][j-1]) % 1000000000;
                    continue;
                }
            
                arr[i][j] = arr[i][j] + (arr[i-1][j-1] + arr[i-1][j+1])% 1000000000;
              
            }
        }
        
        int result = 0;

        for(int j=0;j<=9;j++){
                result = (result + arr[N][j]) % 1000000000;
        }
        
        System.out.println(result);
    }
}
