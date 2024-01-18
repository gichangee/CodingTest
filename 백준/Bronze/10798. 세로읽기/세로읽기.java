
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int max=0;
        String[] arr = new String[5];
        for(int i=0;i<5;i++){
            String s = br.readLine();
            if(max<s.length()){
                max=s.length();
            } 
            arr[i]=s;
        }
        
        
        for(int i=0;i<5;i++){
            String[] test = new String[max]; // [" "," "," "," "," "," "]
            for(int i2=0;i2<test.length;i2++){
                test[i2]=" ";
            }
            if(arr[i].length() <max){
                for(int j=0;j<arr[i].length();j++){
                    test[j]=String.valueOf(arr[i].charAt(j));
                }
                String a="";
                for(int i3=0;i3<test.length;i3++){
                	a+=test[i3];
                }
                arr[i]=a;
            }
        }
        
        for(int i=0;i<max;i++) {
        	for(int j=0;j<5;j++) {
        		if(arr[j].charAt(i)==' ') {
        			continue;
        		}
        		sb.append(arr[j].charAt(i));
        	}
        	
        }
        
        System.out.println(sb.toString());
        
        
    }
}