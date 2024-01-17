import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
       
  
        int sum=0;
        for(int i=0;i<t;i++){
        	int[] arr = new int[26];
            String s= br.readLine();
            char f = s.charAt(0);
            arr[f-97]++;
            for(char c : s.toCharArray()){
                if(f==c){
                    continue;
                }else{
                    arr[c-97]++;
                    f=c;
                }
            }
            boolean a=false;
            for(int j=0;j<arr.length;j++){
                if(arr[j]>=2){
                    a=false;
                    break;
                }
                a=true;
            }
            if(a){
                sum++;
            }
           
        }
        System.out.println(sum);
        
    }
}