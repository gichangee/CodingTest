import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int V, E;
	static int[] parents;
	static class Edge implements Comparable<Edge> {

		int from;
		int to;
		int weigth;

		public Edge(int from, int to, int weigth) {
			this.from = from;
			this.to = to;
			this.weigth = weigth;
		}

		@Override
		public int compareTo(Edge o) {

			return this.weigth - o.weigth;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= t; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			Edge[] edges = new Edge[E];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edges[i] = new Edge(from, to, weight);
			}
			
			
			
			Arrays.sort(edges);
			
			parents = new int[V+1];
			for(int i=1;i<=V;i++) {
				parents[i]=i;
			}
			
			long weight =0;
			int cnt = 0;
			for(Edge e : edges) {
				if(!union(e.from,e.to)) {
					continue;
				}else {
					weight += e.weigth;
					cnt++;
					if(cnt == V-1) {
						break;
					}
				}
			}
			
			System.out.println("#"+test_case+" "+weight);
			
		}

	}

	private static boolean union(int from, int to) {
		int x = find(from);
		int y = find(to);
		
		if(x==y) {
			return false;
		}else {
			parents[y]=x;
			return true;
		}
		
	}

	private static int find(int from) {
		if(from == parents[from]) {
			return from;
		}else {
			return parents[from] = find(parents[from]);
		}
	}
	

}