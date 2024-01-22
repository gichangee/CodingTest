import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			int first = Math.abs(o1);
			int second = Math.abs(o2);

			if (first == second) {
				return o1 > o2 ? 1 : -1;
			}
			return first - second;
		});
		
		
		for(int i=0;i<t;i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x !=0) {
				pq.add(x);
			}else {
				if(pq.isEmpty()) {
					sb.append("0\n");
				}else{
                    sb.append(pq.poll()+"\n");
				}
				
			}
		}
        System.out.println(sb);

	}

}