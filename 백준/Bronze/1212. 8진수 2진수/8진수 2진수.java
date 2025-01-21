import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] sp = s.split("");
        
        if(s.equals("0")){
            System.out.println(0);
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<sp.length;i++){
            Stack<Integer> stack = new Stack<>();
            int num = Integer.parseInt(sp[i]);
            while(true){
                stack.add(num%2);
                num = num / 2;
                
                if(num == 0 || num == 1){
                    if(num ==0){
                        stack.add(num);
                    }
                    stack.add(num);
                    if(stack.size() ==2){
                        stack.add(0);
                    }
                    break;
                }
            }
            if(i == 0){
                while(true){
                    int count = stack.pop();
                    if(count == 0){
                        continue;
                    }else{
                        sb.append(count);
                        break;
                    }  
                } 
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                } 
            }else{
               while(!stack.isEmpty()){
                    sb.append(stack.pop());
                } 
            }
 
        }
        
        System.out.println(sb.toString());
        
    }
}
