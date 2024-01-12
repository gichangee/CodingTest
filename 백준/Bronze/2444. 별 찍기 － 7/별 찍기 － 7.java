
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x= sc.nextInt();
        
        for(int i=0;i<x;i++){
            for(int j=0;j<x-i-1;j++){
                System.out.print(" ");
            }
            for(int j=0;j<i+1;j++){
                System.out.print("*");
            }
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=0;i<x;i++){
            
            for(int j=0;j<i+1;j++){
                System.out.print(" ");
            }
             for(int j=0;j<x-i-1;j++){
                System.out.print("*");
            }
            for(int j=0;j<x-i-2;j++){
                System.out.print("*");
            }
            System.out.println();
        }
   
    }
}