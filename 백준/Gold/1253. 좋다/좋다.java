
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t= Integer.parseInt(st.nextToken());
        
        long[] arr = new long[t];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<t;i++) {
        	arr[i]=Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(arr);
  
        int count=0;
       for(int i=0;i<t;i++) {
    	   int start=0;
    	   int end =t-1;
    	   long sum=arr[i];
    	   
    	   while(start<end) {
    		   if(arr[start]+arr[end]==sum) {
    			   if(start != i && end !=i) {
    				   count++;
    				   break;
    			   }
    			   else if(start == i) {
       					start++;
	       		   }else if(end == i){
	       			    end--;
	       		   }
    		   }else if(arr[start]+arr[end]<sum) {
    			   start++;
    		   }
               else {
    			   end--;
    		   }
    	   }
    	   
    	   
       }
       
       sb.append(count);
       System.out.println(sb);
       br.close();
    }
}