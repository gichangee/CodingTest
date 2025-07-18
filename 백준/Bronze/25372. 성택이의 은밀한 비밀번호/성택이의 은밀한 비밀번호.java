import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.nextLine();
        for(int i=0;i<n;i++){
            s = sc.nextLine();
            if(s.length() >= 6 && s.length() <=9){
                 System.out.println("yes");
            }else{
                 System.out.println("no");
            }

        }
    }
}
