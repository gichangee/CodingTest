import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new ArrayDeque<Integer>();
		int last=0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String s = st.nextToken();
			if (s.equals("push")) {
				int a =Integer.parseInt(st.nextToken());
				q.add(a);
				last=a;
				
			} else if (s.equals("pop")) {
				if (q.isEmpty()) {
					sb.append(-1+"\n");
				} else {
					sb.append(q.poll()+"\n");

				}
			} else if (s.equals("size")) {
				sb.append(q.size()+"\n");
			} else if (s.equals("empty")) {
				if (q.isEmpty()) {
					sb.append(1+"\n");
				} else {
					sb.append(0+"\n");
				}
			} else if (s.equals("front")) {
				if (q.isEmpty()) {
					sb.append(-1+"\n");
				} else {
					sb.append(q.peek()+"\n");

				}
			} else if (s.equals("back")) {
				if (q.isEmpty()) {
					sb.append(-1+"\n");
				} else {
					sb.append(last+"\n");
					
				}
				
				
			}
		}
		
		System.out.println(sb.toString());
	}

}