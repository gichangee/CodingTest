import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<>());
		}
		
		
		int[] degree = new int[N+1];
		for(int i=0;i<R;i++) {
			st= new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list.get(s).add(e);
			degree[e]++;
		}
		Queue<Integer> q = new ArrayDeque<>(); 
		for(int i=1;i<degree.length;i++) {
			if(degree[i]==0) {
				q.add(i);
			}
		}
		
		
		while(!q.isEmpty()) {
			int x = q.poll();
			System.out.print(x+" ");
			for(int now : list.get(x)) {
				degree[now]--;
				if(degree[now]==0) {
					q.add(now);
				}
			}
			
			
		}
		
		
		
		
	}

}