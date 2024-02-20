import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static StringBuilder sb;
	public static int N,M,V;
	public static boolean[][] bmap;
	
	public static void DFS() {
		boolean[] bcheckmap = new boolean[N+1];
		Stack<Integer> sta = new Stack<>();
		sta.push(V);
		sb.append(V).append(" ");
		bcheckmap[V] = true;
		
		while(!sta.isEmpty()) {
			int CheckNode = sta.peek();
			
			boolean isin = false;
			for(int i = 1;i<=N;i++) {
				if(i == CheckNode)
					continue;
				
				if(bmap[CheckNode][i] && !bcheckmap[i]) {
					bcheckmap[i] = true;
					sta.push(i);
					sb.append(i).append(" ");
					isin = true;
					break;
				}
			}
			
			if(!isin) {
				sta.pop();
			}
		}
	}
	
	public static void BFS() {
		boolean[] bcheckmap = new boolean[N+1];
		
		Queue<Integer> que = new ArrayDeque<Integer>();
		bcheckmap[V] = true;
		que.offer(V);
		sb.append(V).append(" ");
		
		while(!que.isEmpty()) {
			int topd = que.poll();
			
			for(int i=1;i<=N;i++) {
				if(i == topd)
					continue;
				
				if(bmap[topd][i] && !bcheckmap[i]) {
					bcheckmap[i] = true;
					que.offer(i);
					sb.append(i).append(" ");
				}
			}
			
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer stz = new StringTokenizer(str);
		sb  = new StringBuilder();
		
		N = Integer.parseInt(stz.nextToken());
		M = Integer.parseInt(stz.nextToken());
		V = Integer.parseInt(stz.nextToken());
		
		bmap = new boolean[N+1][10005];
		
		for(int i=0;i<M;i++) {
			str = br.readLine();
			stz = new StringTokenizer(str);
			int v1 = Integer.parseInt(stz.nextToken());
			int v2 = Integer.parseInt(stz.nextToken());
			bmap[v1][v2] = true;
			bmap[v2][v1] = true;
		}
		
		DFS();
		sb.append("\n");
		BFS();
		
		System.out.print(sb);
	}

}
