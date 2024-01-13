import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] list = new int[7];
        for(int i=0;i<7;i++){
            int x = sc.nextInt();
            list[i]= x;
        }
        
        Arrays.sort(list);
        
        int sum=0;
        for(int x : list){
            if(x%2 !=0){
                   sum+=x;
            }
        }
        
        if(sum==0){
            sum=-1;
        }
        
        
        
        System.out.println(sum);
        
        for(int x : list){
            if(x%2 !=0){
                  System.out.println(x);
                break;
            }
        }
        
       
    }
}