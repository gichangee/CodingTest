import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();

		// 7 3
		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i=1;i<=N;i++) {
			q.offer(i);
		}
		sb.append("<");

		while(!q.isEmpty()) {
			
			int count=1;
			while(count<K) {
				
				q.offer(q.poll());
				count++;
			}
			if(q.size()==1) {
				sb.append(q.poll());
				break;
			}
			sb.append(q.poll()+", ");
			
			
		}
		
		sb.append(">");
		System.out.println(sb.toString());

	}

}