import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        if(x>0 && y > 0){
            System.out.println(1);
        }
        
        if(x < 0 && y > 0){
            System.out.println(2);
        }
        
        if(x<0 && y < 0){
            System.out.println(3);
        }
        
        if(x>0 && y < 0){
            System.out.println(4);
        }
    }
}
