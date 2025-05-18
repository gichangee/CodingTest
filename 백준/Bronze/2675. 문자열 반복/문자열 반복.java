import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<T;i++){
            String a = sc.nextLine();   
            String[] split = a.split(" ");
            int R = Integer.parseInt(split[0]);
            String s = split[1];
            
            a="";
            
            for(int j=0;j<s.length();j++){
                for(int k=0;k<R;k++){
                    a=a+s.charAt(j);
                }
                
            }
            System.out.println(a);
        }
    }
}
