import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        InputStream is = System.in;
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);
        
        OutputStream os = System.out;
        Writer writer = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(writer);
        
  
        String str = br.readLine();
        int t = Integer.parseInt(str);
        
        for(int i=0;i<t;i++){
            int sum=0;
            String str2 = br.readLine();
            String[] s = str2.split(" ");
            sum+=Integer.parseInt(s[0]);
            sum+=Integer.parseInt(s[1]);
            bw.write(Integer.toString(sum));
            bw.write("\n");
           
        }
        bw.flush();
        bw.close();
        br.close();
    }
}