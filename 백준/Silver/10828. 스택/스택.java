
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
		
		for(int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			
			String s = st.nextToken();
			int num=0;
			if(s.equals("push")) {
				num = Integer.parseInt(st.nextToken());
				stack.push(num);
			}else if(s.equals("top")){
				if(stack.empty()) {
					sb.append(-1+"\n");
				}else {
					sb.append(stack.peek()+"\n");
				}
				
			}else if(s.equals("size")) {
				sb.append(stack.size()+"\n");
			}else if(s.equals("empty")) {
				if(stack.empty()) {
					sb.append(1+"\n");
				}else {
					sb.append(0+"\n");
				}
			}else if(s.equals("pop")) {
				if(stack.empty()) {
					sb.append(-1+"\n");
				}else{
					sb.append(stack.pop()+"\n");
				}
			}
		}
		System.out.println(sb.toString());
	}

}
