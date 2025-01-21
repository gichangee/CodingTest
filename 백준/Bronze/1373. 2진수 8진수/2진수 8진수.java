import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] sp = s.split("");
        
        Stack<Integer> stack = new Stack<>();

        if(s.equals("0")){
            System.out.println(0);
            return;
        }

        int[] arr = new int[sp.length/3];
        int sum = 0;
        int j = 1;
        for(int i=sp.length-1;i>=0;i--){
            
            sum+=j*Integer.parseInt(sp[i]);
            j=j*2;
            if(j == 8){
                stack.add(sum);
                sum=0;
                j=1;
            }
        }
        
        if(sum != 0){
            stack.add(sum);
        }
        
        while(!stack.isEmpty()){
            
            System.out.print(stack.pop());
        }

    }
}
