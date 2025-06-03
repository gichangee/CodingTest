import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요\
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == 'A' || c == 'B'||c == 'C'){
                count = count + 3;
            }else if(c == 'D' || c == 'E'||c == 'F'){
                count = count + 4;
            }else if(c == 'G' || c == 'H'||c == 'I'){
                count = count + 5;
            }else if(c == 'J' || c == 'K'||c == 'L'){
                count = count + 6;
            }else if(c == 'M' || c == 'N'||c == 'O'){
                count = count + 7;
            }else if(c == 'P' || c == 'Q'||c == 'R' || c =='S'){
                count = count + 8;
            }else if(c == 'T' || c == 'U'||c == 'V'){
                count = count + 9;
            }else if(c == 'W' || c == 'X'||c == 'Y' || c=='Z'){
                count = count + 10;
            }
            
        }
        
        System.out.println(count);
    }
}
