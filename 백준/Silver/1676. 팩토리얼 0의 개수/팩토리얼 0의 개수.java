import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N == 0){
            System.out.println(0);
        }else{
            int count = 0;
            for(int i =5; i<= N; i=i*5){
              count+=(N/i);
            }
            System.out.println(count);
        }
       
    }
}
