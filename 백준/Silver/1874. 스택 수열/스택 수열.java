import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(st.nextToken());
       
        Stack<Integer> stack = new Stack<>();
        
        int[] arr= new int[t];
        for(int i=0;i<t;i++) {
        	arr[i]=Integer.parseInt(br.readLine());
        }
        
        int num=1;
        for(int i=0;i<arr.length;i++) {
        	if(arr[i]>=num) {
        		while(arr[i]>=num) {
        			stack.push(num++);
        			sb.append("+\n");
        		}
        		stack.pop();
        		sb.append("-\n");
        	}else {
        		int n=stack.pop();
        		if(n>arr[i]) {
        			System.out.println("NO");
        			return;
        		}else {
        			sb.append("-\n");
        		}
        	}
        }
        System.out.println(sb);
        
    }

}