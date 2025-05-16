import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] arr = new int[26];
        for(int i=0;i<26;i++){
            arr[i] = -1;
        }
        
        for(int i=0;i<s.length();i++){
            if(arr[s.charAt(i)-'a'] == -1){
                 arr[s.charAt(i)-'a'] = i;
            }
           
        }
        
         for(int i=0;i<26;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
