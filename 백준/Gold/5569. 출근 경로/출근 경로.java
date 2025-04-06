import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int[][][][] arr = new int[w+1][h+1][2][2];
        
        for(int i = 1; i <= w; i++) {
            arr[i][1][0][0] = 1;
        } 
        for(int i = 1; i <= h; i++) {
            arr[1][i][1][0] = 1;
        }
        
        for(int i=2;i<=w;i++){
            for(int j=2;j<=h;j++){
                    arr[i][j][0][1] = (arr[i-1][j][1][0]) % 100000;
                    arr[i][j][0][0] = (arr[i-1][j][0][1] + arr[i-1][j][0][0] )% 100000;
                    arr[i][j][1][1] = arr[i][j-1][0][0] % 100000;
                    arr[i][j][1][0] = (arr[i][j-1][1][0] + arr[i][j-1][1][1] )% 100000;
            }
        }
        
        System.out.println((arr[w][h][0][1] + arr[w][h][0][0] + arr[w][h][1][1] + arr[w][h][1][0]) % 100000);
        
    }
}
