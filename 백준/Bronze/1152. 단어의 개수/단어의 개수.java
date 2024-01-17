import java.util.*;
public class Main{
        public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s=s.trim();
 if(s.equals("")|| s.equals("")) {
        	System.out.println("0");
        	return;
        }
        String[] split = s.split(" ");
        System.out.println(split.length);
   }
}