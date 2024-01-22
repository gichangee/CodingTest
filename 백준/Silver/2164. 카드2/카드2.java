
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(st.nextToken());
       
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=1;i<=t;i++) {
        	q.add(i);
        }
        
        
        while(q.size()>1) {
        	q.poll();
        	q.add(q.poll());
        }
        System.out.println(q.poll());
        
        
    }

}