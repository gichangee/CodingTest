import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<10;i++){
            int x = sc.nextInt();
            x = x%42;
            hs.add(x);
        }
        
        System.out.println(hs.size());
    }
}
