import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int[] arr = new int[26];
        
        String s = sc.nextLine();
        
        for(char c : s.toCharArray()){
            int x = c-97;
            arr[x]++;
        }
        
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}