
import java.io.*;
import java.util.Arrays;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            String s = br.readLine();
            String[] split = s.split("");
            String[] test = new String[split.length];
            int le=split.length-1;
            
            for(int i=0;i<split.length;i++){
                test[i]=split[le--];
            }
            
            
            
            if(s.equals("0")){
                break;
            }
     
            if((Arrays.toString(split)).equals(Arrays.toString(test))){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
}