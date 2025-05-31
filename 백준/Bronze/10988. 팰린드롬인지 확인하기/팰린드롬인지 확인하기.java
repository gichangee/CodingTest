import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] sp = s.split("");
        for(int i=0;i<sp.length/2;i++){
            if(sp[i].equals(sp[sp.length-i-1])){
                continue;
            }else{
                System.out.println("0");
                return;
            }
        }
        
        System.out.println("1");
    }
}
