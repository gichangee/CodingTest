import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t= Integer.parseInt(br.readLine());
        int[] arr= new int[t];
        for(int i=0;i<t;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        
        for(int i=0;i<t;i++){
            sb.append(arr[i]);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}