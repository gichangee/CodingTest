import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        
        /*
            14 30
            20
        */
        
        int z=sc.nextInt();
        
        y+=z;
        int k=y/60;
        y=y%60;
        if(k>0){
            x+=k;
        }
        
        if(x>=24){
            x=x%24;
        }
        
        System.out.println(x+" "+y);
        
        
        
        
    }
}