import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        //5 2
        //4 1 2 3 5
        
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        
        int[] arr= new int[t];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<t;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        System.out.println(arr[count-1]);
        
    }
}