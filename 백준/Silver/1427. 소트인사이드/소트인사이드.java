/**
* 주어지는 숫자의 최대 자릿수가 10개 정도 이기에 선택정렬 알고리즘을 사용해도 된다고 생각
* 주어지는 숫자가 하나이므로 그냥 스캐너 사용
*/
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        int[] arr= new int[s.length()];
        for(int i=0;i<s.length();i++){
            arr[i]=Integer.parseInt(s.substring(i,i+1));
        }
        
        for(int i=0;i<arr.length;i++){
            int max=arr[i];
            int index=0;
            for(int j=i+1;j<arr.length;j++){
                if(max<arr[j]){
                    max=arr[j];
                    index=j;
                }
            }
           
            if(arr[i]<max){
                int temp=arr[index];
                arr[index]=arr[i];
                arr[i]=temp;
            }
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
        sc.close();
        
    }
}