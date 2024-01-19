import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[100][100];
        
        for(int i=0;i<t;i++){
            String s = br.readLine();
            
            String[] sp = s.split(" ");
            int a= Integer.parseInt(sp[0]);
            int b =Integer.parseInt(sp[1]);
            
            for(int j=a;j<a+10;j++){
                for(int z=b;z<b+10;z++){
                    arr[j][z]++;
                }
            }
        }
        int sum=0;
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(arr[i][j]>0){
                    sum++;
                }
            }
        }
        sb.append(sum);
        System.out.println(sb.toString());
        
    }
}