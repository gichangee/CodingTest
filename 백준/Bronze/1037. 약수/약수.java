import java.io.*;
import java.util.*;

public class Main {
    
    static List<Long> list = new ArrayList<>();
    
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer (br.readLine());

        for(int i=0;i<N;i++){
            list.add(Long.parseLong(st.nextToken()));
        }
        
        Collections.sort(list);
        
        System.out.println(list.get(0) * list.get(list.size()-1));
        
    }
    
}
