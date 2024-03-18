import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new ArrayDeque<>();
		int last=0;
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if(s.equals("push")) {
				int x = Integer.parseInt(st.nextToken());
				last =x;
				q.add(x);
			}else {
				if(s.equals("pop")) {
					if(q.isEmpty()) {
						System.out.println(-1);
					}else {
						System.out.println(q.poll());
					}
					
				}else if(s.equals("size")) {
					System.out.println(q.size());
				}else if(s.equals("empty")) {
					if(q.isEmpty()) {
						System.out.println(1);
					}else {
						System.out.println(0);
					}
				}else if(s.equals("front")) {
					if(!q.isEmpty()) {
						System.out.println(q.peek());
					}else {
						System.out.println(-1);
					}
					
				}else if(s.equals("back")) {
					if(!q.isEmpty()) {
						System.out.println(last);
					}else {
						System.out.println(-1);
					}
					
					
				}
			}
		}
	}

}